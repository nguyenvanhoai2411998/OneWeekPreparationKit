package com.vti.frontend;

import java.io.IOException;
import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        Functions functions = new Functions();
        while (true){
            functions.checkLogin();
        }
    }
}
