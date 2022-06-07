package com.bridgelabz.employeepayroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeConfig
{
    public static final String URL_ID = "jdbc:mysql://localhost:3306/payroll_service";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "Anvi@1112";
    static Connection connection;

    public  Connection getConfig()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            connection = DriverManager.getConnection(URL_ID,USER_NAME,PASSWORD);
            System.out.println("Connection is successful !");
        } catch (ClassNotFoundException | SQLException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath !",e);
        }
        return connection;
    }

}