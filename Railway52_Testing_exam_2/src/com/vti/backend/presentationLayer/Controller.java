package com.vti.backend.presentationLayer;

import com.vti.backend.businessLayer.Service;
import com.vti.entity.Employee;
import com.vti.entity.Role;
import com.vti.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Controller {
    Service service;

    public Controller() throws IOException {
        service = new Service();
    }

    public User checkLogin(String email, String password) throws SQLException, ClassNotFoundException {
        return service.checkLogin(email, password);
    }

    public List<Employee> getAllUser() throws SQLException, ClassNotFoundException {
        return service.getAllUser();
    }

    public User searchByID(int id) throws SQLException, ClassNotFoundException {
        return service.searchByID(id);
    }

    public boolean createEmployee(String fullname, String email, String password, Role role) throws SQLException, ClassNotFoundException {
        return service.createEmployee(fullname, email, password, role);
    }

    public boolean deleteByID(int id) throws SQLException, ClassNotFoundException {
        return service.deleteByID(id);
    }
}
