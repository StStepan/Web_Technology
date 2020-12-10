package com.khudnitski.library.dao;

import com.khudnitski.library.bean.FinalBookOrder;
import com.khudnitski.library.dao.exception.DAOException;
import java.util.UUID;

public interface FinalBookOrderDAO extends GenericDAO<FinalBookOrder, UUID> {
    FinalBookOrder complete(UUID idOrder) throws DAOException;
    FinalBookOrder returned(UUID idOrder) throws DAOException;
}
