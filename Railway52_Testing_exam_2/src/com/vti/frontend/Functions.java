package com.vti.frontend;

import com.vti.backend.presentationLayer.Controller;
import com.vti.entity.Employee;
import com.vti.entity.Role;
import com.vti.entity.User;
import com.vti.ultis.ScannerUltis;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class Functions {
    private Controller controller;

    public Functions() throws IOException {
        super();
        controller = new Controller();
    }

    public void checkLogin() throws SQLException, ClassNotFoundException {
        System.out.println("===========================================Login==========================================");
        System.out.println("enter email:");
        String email = ScannerUltis.inputEmail();

        System.out.println("enter password:");
        String password = ScannerUltis.inputPassword();

        User user = controller.checkLogin(email,password);
        if (user != null){
            if (user.getRole().toString().equals("ADMIN")){
                showMenuAdmin();
            }else {
                showMenuUser();
            }
        }else System.out.println("invalid email or password");
    }

    private void showMenuUser() throws SQLException, ClassNotFoundException {
        boolean check = false;
        while (!check){
            System.out.println("please select options");
            String leftAlignFormat = "| %-86s |%n";
            System.out.println("+----------------------------------------------------------------------------------------+");
            System.out.println("|                                      Choose please                                     |");
            System.out.println("+----------------------------------------------------------------------------------------+");
            System.out.format(leftAlignFormat,"1. List user in system");
            System.out.format(leftAlignFormat,"2. Search by ID");
            System.out.format(leftAlignFormat,"3. Exit");
            System.out.println("+----------------------------------------------------------------------------------------+");
            switch (ScannerUltis.inputIntPositive()){
                case 1:
                    getAllUser();
                    break;
                case 2:
                    searchByID();
                    break;
                case 3:
                    ScannerUltis.nextLine();
                    check = true;
                    break;
                default:
                    System.out.println("enter again(1->3)");
                    break;
            }

        }
    }

    private void searchByID() throws SQLException, ClassNotFoundException {
        System.out.println("enter ID");
        int id = ScannerUltis.inputInt();
        User user = controller.searchByID(id);
        System.out.println("+----+------------------------+------------------------+------------------------+--------+");
        System.out.println("| ID |        FullName        |          Email         |        password        |  Role  |");
        System.out.println("+----+------------------------+------------------------+------------------------+--------+");
        System.out.format("| %-2d | %-22s | %-22s | %-22s | %-6s |%n", user.getId(), user.getFullname(), user.getEmail(), user.getPassword(), user.getRole());
        System.out.println("+----+------------------------+------------------------+------------------------+--------+");
    }

    private void getAllUser() throws SQLException, ClassNotFoundException {
        List<Employee> userList = controller.getAllUser();
        System.out.println("+----+------------------------+------------------------+------------------------+--------+--------------+");
        System.out.println("| ID |        FullName        |          Email         |        password        |  Role  |   ProSkill   |");
        System.out.println("+----+------------------------+------------------------+------------------------+--------+--------------+");
        for (Employee u:userList) {
            System.out.format("| %-2d | %-22s | %-22s | %-22s | %-6s | %-12s |%n", u.getId(), u.getFullname(), u.getEmail(), u.getPassword(), u.getRole(), u.getProSkill());
        }
        System.out.println("+----+------------------------+------------------------+------------------------+--------+--------------+");
    }

    private void showMenuAdmin() throws SQLException, ClassNotFoundException {
        boolean check = false;
        while (!check){
            System.out.println("please select options");
            String leftAlignFormat = "| %-86s |%n";
            System.out.println("+----------------------------------------------------------------------------------------+");
            System.out.println("|                                      Choose please                                     |");
            System.out.println("+----------------------------------------------------------------------------------------+");
            System.out.format(leftAlignFormat,"1. Create new employee");
            System.out.format(leftAlignFormat,"2. delete employee by ID");
            System.out.format(leftAlignFormat,"3. Exit");
            System.out.format("+-----------------------------------------------------------------------------------------+%n");
            switch (ScannerUltis.inputIntPositive()){
                case 1:
                    createEmployee();
                    break;
                case 2:
                    deleteByID();
                    break;
                case 3:
                    ScannerUltis.nextLine();
                    check = true;
                    break;
                default:
                    System.out.println("enter again(1->3)");
                    break;
            }

        }
    }

    private void deleteByID() throws SQLException, ClassNotFoundException {
        System.out.println("enter ID");
        int id = ScannerUltis.inputIntPositive();
        if (controller.deleteByID(id)){
            System.out.println("user with id "+id+" have been deleted");
        }else System.out.println("cannot delete user");
    }

    private void createEmployee() throws SQLException, ClassNotFoundException {
        System.out.println("enter fullname:");
        String fullname = ScannerUltis.inputString();
        System.out.println("enter Email");
        String email = ScannerUltis.inputEmail();
        System.out.println("enter password");
        String password = ScannerUltis.inputPassword();
        System.out.println("enter role");
        Role role = Role.valueOf(ScannerUltis.inputString());
        if (controller.createEmployee(fullname, email, password, role)){
            System.out.println("employee is created");
        }else System.out.println("cannot create employee");
    }
}
