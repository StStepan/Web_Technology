package com.khudnitski.library.dao;

import com.khudnitski.library.bean.User;
import com.khudnitski.library.dao.exception.DAOException;

import java.util.UUID;

public interface UserDAO extends GenericDAO<User, UUID> {
    User signIn(String login, String password) throws DAOException;
    User logOut(UUID id) throws DAOException;
}
