package com.vti.backend.dataLayer;

import com.vti.entity.Employee;
import com.vti.entity.Role;
import com.vti.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IRepository {
    User checkLogin(String email, String password) throws SQLException, ClassNotFoundException;

    List<Employee> getAllUser() throws SQLException, ClassNotFoundException;

    User searchByID(int id) throws SQLException, ClassNotFoundException;

    boolean createEmployee(String fullname, String email, String password, Role role) throws SQLException, ClassNotFoundException;

    boolean deleteByID(int id) throws SQLException, ClassNotFoundException;
}
