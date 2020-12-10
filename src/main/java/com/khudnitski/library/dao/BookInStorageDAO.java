package com.khudnitski.library.dao;

import com.khudnitski.library.bean.BookInStorage;
import com.khudnitski.library.dao.exception.DAOException;
import java.util.UUID;

public interface BookInStorageDAO extends GenericDAO<BookInStorage, UUID> {
    BookInStorage addToStorage(UUID id, Long quantity) throws DAOException;
    BookInStorage removeFromStorage(UUID id, Long quantity) throws DAOException;
}
