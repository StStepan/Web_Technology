package com.khudnitski.library.dao.impl;

import com.khudnitski.library.bean.BookInStorage;
import com.khudnitski.library.dao.BookInStorageDAO;
import com.khudnitski.library.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

public class OrderDAOImpl extends AbstractJDBCDAO<BookInStorage, UUID> implements BookInStorageDAO {
    public OrderDAOImpl(Connection connection) {
        super(connection);
    }

    @Override
    public BookInStorage addToStorage(UUID id, Long quantity) throws DAOException {
        BookInStorage bookInStorage = get(id);
        return update(bookInStorage);
    }

    @Override
    public BookInStorage removeFromStorage(UUID id, Long quantity) throws DAOException {
        BookInStorage bookInStorage = get(id);
        return update(bookInStorage);
    }

    @Override
    protected String getSelectQuery() {
        return null;
    }

    @Override
    protected String getDeleteQuery() {
        return null;
    }

    @Override
    protected String getUpdateQuery() {
        return null;
    }

    @Override
    protected String getCreateQuery() {
        return null;
    }

    @Override
    protected void prepareStatementForDelete(PreparedStatement statement, UUID id) {

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, BookInStorage item) {

    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, BookInStorage newItem) {

    }

    @Override
    protected List<BookInStorage> parseResultSet(ResultSet rs) {
        return null;
    }
}
