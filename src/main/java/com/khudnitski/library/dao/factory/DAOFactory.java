package com.khudnitski.library.dao.factory;

import com.khudnitski.library.dao.BookInStorageDAO;
import com.khudnitski.library.dao.BookDAO;
import com.khudnitski.library.dao.FinalBookOrderDAO;
import com.khudnitski.library.dao.UserDAO;

public interface DAOFactory {
    BookInStorageDAO getBookInStorageDAO();
    FinalBookOrderDAO getFinalBookOrderDAO();
    UserDAO getUserDAO();
    BookDAO getBookDAO();
}
