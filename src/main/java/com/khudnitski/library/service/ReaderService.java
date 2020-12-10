package com.khudnitski.library.service;

import com.khudnitski.library.bean.User;
import com.khudnitski.library.service.exception.ServiceException;

import java.util.UUID;

public interface ReaderService {
    User authorize(String login, String password) throws ServiceException;
    User register(User user) throws ServiceException;
    void addToOrder(UUID userId, UUID bookId, Long quantity) throws ServiceException;
    void removeToOrder(UUID userId, UUID drinkId, Long quantity) throws ServiceException;
    void orderFinalize(UUID userId) throws ServiceException;
}
