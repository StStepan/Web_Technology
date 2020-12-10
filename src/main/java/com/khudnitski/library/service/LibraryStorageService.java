package com.khudnitski.library.service;

import com.khudnitski.library.bean.BookInStorage;
import com.khudnitski.library.service.exception.ServiceException;
import java.util.List;

public interface LibraryStorageService {
    List<BookInStorage> getCatalog() throws ServiceException;
}
