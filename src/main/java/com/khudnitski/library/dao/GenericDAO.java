package com.khudnitski.library.dao;

import com.khudnitski.library.dao.exception.DAOException;
import java.util.List;

public interface GenericDAO<T, PK> {
    T get(PK key) throws DAOException;
    List<T> getAll(long from, long count) throws DAOException;
    T add(T newItem) throws DAOException;
    void remove (PK id) throws DAOException;
    T update(T item) throws DAOException;
}
