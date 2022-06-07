package com.bridgelabz.employeepayroll;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeePayroll
{
    public static void main(String[] args) {
        System.out.println("*-*-*-*-*-*- Wel come to jdbc Program -*-*-*-*-*-*");
        EmployeeConfig employeeConfig = new EmployeeConfig();
        employeeConfig.getConfig();
        String query = "select * from employee_payroll";
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = employeeConfig.getConfig().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmpId(resultSet.getInt("Id"));
                employee.setEmpName(resultSet.getString("Name"));
                employee.setPhoneNumber(resultSet.getString("Salary"));
                employee.setStartDate(resultSet.getString("Start_Date"));
                employee.setGender(resultSet.getString("Gender"));
                employee.setPhoneNumber(resultSet.getString("Phone"));
                employee.setAddress(resultSet.getString("Address"));
                employee.setBasicPay(resultSet.getDouble("Basic_Pay"));
                employee.setDeductions(resultSet.getDouble("Deductions"));
                employee.setTaxablePay(resultSet.getDouble("Taxbale_Pay"));
                employee.setNetPay(resultSet.getDouble("Net_Pay"));
                employeeArrayList.add(employee);
            }
            for (Employee e : employeeArrayList) {
                System.out.println(e.toString());

            }
        } catch (SQLException e) {
            throw new EmployeeException("Invalid Column Name");
        }
    }
}
