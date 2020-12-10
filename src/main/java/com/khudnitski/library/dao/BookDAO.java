package com.khudnitski.library.dao;

import com.khudnitski.library.bean.Book;
import com.khudnitski.library.dao.exception.DAOException;
import java.util.UUID;

public interface BookDAO extends GenericDAO<Book, UUID> {
    Book addToOrder(UUID id, Float quantity) throws DAOException;
    Book removeFromOrder(UUID id, Float quantity) throws DAOException;
}
