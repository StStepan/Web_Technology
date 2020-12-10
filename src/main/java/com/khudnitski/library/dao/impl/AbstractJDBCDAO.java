package com.khudnitski.library.dao.impl;

import com.khudnitski.library.dao.GenericDAO;
import com.khudnitski.library.dao.exception.DAOException;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Абстрактный класс предоставляющий базовую реализацию CRUD операций с использованием JDBC.
 *
 * @param <T>  тип объекта персистенции
 * @param <PK> тип первичного ключа
 */
public abstract class AbstractJDBCDAO<T, PK extends Serializable> implements GenericDAO<T, PK> {

    private final Connection connection;

    /**
     * Возвращает sql запрос для получения всех записей.
     * <p/>
     * SELECT * FROM [Table]
     */
    protected abstract String getSelectQuery();

    /**
     * Возвращает sql запрос для удаления записи.
     * <p/>
     * DELETE FROM [Table]
     */
    protected abstract String getDeleteQuery();

    /**
     * Возвращает sql запрос для обновления записи.
     * <p/>
     * UPDATE [Table] SET [column1] = ?, [column2] = ?, [...]
     */
    protected abstract String getUpdateQuery();

    /**
     * Возвращает sql запрос для создания записи.
     * <p/>
     * INSERT INTO [Table] SET ([column1], [column2], [...]) VALUES (?, ?, [...])
     */
    protected abstract String getCreateQuery();


    protected abstract void prepareStatementForDelete(PreparedStatement statement, PK id);

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T item);

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T newItem);


    /**
     * Разбирает ResultSet и возвращает список объектов соответствующих содержимому ResultSet.
     */
    protected abstract List<T> parseResultSet(ResultSet rs);

    //todo ask about more convenient ways & Should user be able to select several books?
    @Override
    public T get(PK key) throws DAOException {
        List<T> list;
        String sql = getSelectQuery();
        sql += " WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setObject(1, key);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() > 1) {
            throw new DAOException("Received more than one record.");
        }
        return list.iterator().next();
    }

    @Override
    public List<T> getAll(long from, long count) throws DAOException {
        List<T> list;
        String sql = getSelectQuery();
        sql +=" LIMIT ?, ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, from);
            statement.setLong(2, count);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return list;
    }

    @Override
    public T add(T newItem) throws DAOException {
        T persistInstance;
        // Add note
        String sql = getCreateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForInsert(statement, newItem);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DAOException("On persist modify more then 1 record: " + count);
            }
        } catch (Exception e) {
            throw new DAOException(e);
        }
        // Get most recent note
        sql = getSelectQuery() + "WHERE id = last_insert_id();";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            List<T> list = parseResultSet(rs);
            if ((list == null) || (list.size() != 1)) {
                throw new DAOException("Exception on finding created row.");
            }
            persistInstance = list.iterator().next();
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return persistInstance;
    }

    @Override
    public void remove(PK id) throws DAOException {
        String sql = getDeleteQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForDelete(statement, id);//later
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DAOException("On delete modify more then 1 record: " + count);
            }
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }


    @Override
    public T update(T item) throws DAOException {
        String sql = getUpdateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForUpdate(statement, item); // later
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DAOException("On update modify more then 1 record: " + count);
            }
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return item;
    }



    public AbstractJDBCDAO(Connection connection) {
        this.connection = connection;
    }
}