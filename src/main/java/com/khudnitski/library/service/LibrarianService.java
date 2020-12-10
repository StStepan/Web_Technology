package com.khudnitski.library.service;

import com.khudnitski.library.bean.BookInStorage;
import com.khudnitski.library.bean.Book;
import com.khudnitski.library.service.exception.ServiceException;
import java.util.UUID;

public interface LibrarianService {
    //todo: merge bookInStorage with books?
    BookInStorage addBookToStorage(UUID bookInStorageId, Long quantity) throws ServiceException;
    BookInStorage removeBookFromStorage(UUID bookInStorageId, Long quantity) throws ServiceException;

    //todo should librarian rights overlap readers rights in ordering books?
    void addBookToOrder(UUID bookId, Long quantity, UUID bookOrderId) throws ServiceException;
    void removeBookFromOrder(UUID bookId, Long quantity, UUID bookOrderId) throws ServiceException;

    void orderCompleted(UUID bookOrderId) throws ServiceException;
    void orderReturned(UUID bookOrderId) throws ServiceException;
}
