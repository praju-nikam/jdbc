package com.bridgelabz;

import java.sql.*;
import java.util.Enumeration;

public class DBDemo {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://127.0.0.1:3306/emp_payroll";
        String userName = "root";
        String password = "Anvi@1112";
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded ");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }

        try {
               System.out.println("Connecting to DataBase:" + jdbcURL);
                con = DriverManager.getConnection(jdbcURL, userName, password);
                System.out.println("Connection is successfully" + con);

               Statement statement = con.createStatement();

               statement.executeUpdate("insert into employee(Name,Age,Salary,Department,Join_Date) values('Aniket',22,30000,'Software Engineer','2020-04,01'),('Namrata',28,45000,'IT Engineer','2016-02,16')");

               statement.executeUpdate("update employee set Age=61 where Emp_Id in (2)");
               statement.executeUpdate("alter table employee modify column salary double");
               statement.executeQuery("desc employee");
               ResultSet resultSet = statement.executeQuery("Select * from employee");

              while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt("Emp_Id"));
                System.out.println("Name: " + resultSet.getString("Name"));
                System.out.println("Age: " + resultSet.getInt("Age"));
                System.out.println("Salary: " + resultSet.getInt("Salary"));
                System.out.println("Department: " + resultSet.getString("Department"));
                System.out.println("Joining_Date: " + resultSet.getDate("Join_Date"));
                System.out.println("City: " + resultSet.getString("City"));

            }

//            PreparedStatement preparedStatement = con.prepareStatement("update employee set city=? where id in (?,?)");
//            preparedStatement.setString(1, "Bangalore");
//            preparedStatement.setInt(2, 2);
//            preparedStatement.setInt(3, 4);
//            //ResultSet resultSet = preparedStatement.executeQuery();
//            boolean b = preparedStatement.execute();
//            if (b) {
//                ResultSet resultSet1 = preparedStatement.getResultSet();
//                while (resultSet1.next()) {
//                System.out.println("Id: " + resultSet.getInt("Emp_Id"));
//                System.out.println("Name: " + resultSet.getString("Name"));
//                System.out.println("Age: " + resultSet.getInt("Age"));
//                System.out.println("Salary: " + resultSet.getInt("Salary"));
//                System.out.println("Department: " + resultSet.getString("Department"));
//                System.out.println("Joining_Date: " + resultSet.getDate("Join_Date"));
//                System.out.println("City: " + resultSet.getString("City"));
//                }
//            }
//            else {
//                int i = preparedStatement.getUpdateCount();
//                System.out.println(i + " rows updated!");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
