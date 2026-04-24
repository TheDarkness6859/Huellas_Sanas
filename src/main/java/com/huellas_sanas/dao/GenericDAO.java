package com.huellas_sanas.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO <T>{

    void save (T object) throws SQLException;
    T edit (T object) throws SQLException;
    void delete (String value) throws SQLException;
    T findByNameOrId (String value) throws SQLException;
    List<T> findAll () throws SQLException;

}
