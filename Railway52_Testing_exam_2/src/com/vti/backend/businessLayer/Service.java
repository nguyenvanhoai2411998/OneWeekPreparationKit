package com.vti.backend.businessLayer;

import com.vti.backend.dataLayer.Repository;
import com.vti.entity.Employee;
import com.vti.entity.Role;
import com.vti.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Service implements  IService{
    Repository repository;

    public Service() throws IOException {
        repository = new Repository();
    }

    @Override
    public User checkLogin(String email, String password) throws SQLException, ClassNotFoundException {
        return repository.checkLogin(email, password);
    }

    @Override
    public List<Employee> getAllUser() throws SQLException, ClassNotFoundException {
        return repository.getAllUser();
    }

    @Override
    public User searchByID(int id) throws SQLException, ClassNotFoundException {
        return repository.searchByID(id);
    }

    @Override
    public boolean createEmployee( String fullname, String email, String password, Role role) throws SQLException, ClassNotFoundException {
        return repository.createEmployee(fullname, email, password, role);
    }

    @Override
    public boolean deleteByID(int id) throws SQLException, ClassNotFoundException {
        return repository.deleteByID(id);
    }
}
