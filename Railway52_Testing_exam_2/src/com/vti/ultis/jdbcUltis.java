package com.vti.ultis;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class jdbcUltis {
    private Properties properties;
    private Connection connection;

    public jdbcUltis() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\nguye\\OneDrive\\eclipse-workspace\\Railway52_TestingSystem10_DB\\Railway52_Testing_exam_1\\src\\com\\vti\\resources\\database.properties"));
    }


    public void connectionTesting() throws ClassNotFoundException, SQLException {
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        Class.forName(driver);
        connection = DriverManager.getConnection(url,username,password);
        System.out.println("Connection Success");
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        Class.forName(driver);
        connection = DriverManager.getConnection(url,username,password);
        return connection;
    }

    public void disConnection() throws SQLException {
        connection.close();
    }

    public ResultSet executeQuery(String sql) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet result =  statement.executeQuery(sql);
        return result;
    }

    public PreparedStatement createPrepareStatement(String sql) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        return preparedStatement;
    }
}
