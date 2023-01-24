package com.vti.backend.dataLayer;

import com.vti.entity.Employee;
import com.vti.entity.Role;
import com.vti.entity.User;
import com.vti.ultis.jdbcUltis;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository{
    jdbcUltis jdbc;

    public Repository() throws IOException {
        jdbc = new jdbcUltis();
    }

    @Override
    public User checkLogin(String email, String password) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM testingexam.user where Email = ? AND `password` = ?;";
        PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            User user = new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), Role.valueOf(result.getString(5).toUpperCase()));
            return user;
        } else
            return null;
    }

    @Override
    public List<Employee> getAllUser() throws SQLException, ClassNotFoundException {
        String sql = "SELECT id, fullname, email, `password`, `Role`, ProSkill FROM testingexam.user\n" +
                "join employee using(id);";
        ResultSet result = jdbc.executeQuery(sql);
        List<Employee> employeeList = new ArrayList<>();
        while (result.next()) {
            Employee e = new Employee(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), Role.valueOf(result.getString(5).toUpperCase()),result.getString(6));
            employeeList.add(e);
        }
        return employeeList;
    }

    @Override
    public User searchByID(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM testingexam.user where id =?;";
        PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet result = preparedStatement.executeQuery();
        User user = null;
        if (result.next()){
            user = new User();
            user.setId(result.getInt(1));
            user.setFullname(result.getString(2));
            user.setEmail(result.getString(3));
            user.setPassword(result.getString(4));
            user.setRole(Role.valueOf(result.getString(5).toUpperCase()));
        }
        return user;
    }

    @Override
    public boolean createEmployee(String fullname, String email, String password, Role role) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO `testingexam`.`user` (`FullName`, `Email`, `password`, `Role`) VALUES (?, ?, ?, ?);";
        PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
        preparedStatement.setString(1,fullname);
        preparedStatement.setString(2,email);
        preparedStatement.setString(3,password);
        preparedStatement.setString(4,role.toString());
        if (preparedStatement.executeUpdate() == 1){
            return true;
        }else return false;
    }

    @Override
    public boolean deleteByID(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM `testingexam`.`user` WHERE (`id` = ? );";
        PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
        preparedStatement.setInt(1,id);
        if (preparedStatement.executeUpdate() == 1){
            return true;
        }else return false;

    }
}
