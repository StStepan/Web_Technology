package com.khudnitski.library.dao.factory.impl;

import com.khudnitski.library.dao.BookInStorageDAO;
import com.khudnitski.library.dao.BookDAO;
import com.khudnitski.library.dao.FinalBookOrderDAO;
import com.khudnitski.library.dao.UserDAO;
import com.khudnitski.library.dao.factory.DAOFactory;

public class DAOFactoryImpl implements DAOFactory {

    private static final DAOFactoryImpl instance = new DAOFactoryImpl();

    public static DAOFactory getInstance(){
        return instance;
    }

    private DAOFactoryImpl(){}

    @Override
    public BookInStorageDAO getBookInStorageDAO() {
        return null;
    }

    @Override
    public FinalBookOrderDAO getFinalBookOrderDAO() {
        return null;
    }

    @Override
    public UserDAO getUserDAO() {
        return null;
    }

    @Override
    public BookDAO getBookDAO() {
        return null;
    }
}
