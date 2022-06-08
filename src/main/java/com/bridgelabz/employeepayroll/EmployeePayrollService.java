package com.bridgelabz.employeepayroll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollService
{
    public ArrayList<Employee> employeeArrayList;
    PreparedStatement preparedStatement;
    EmployeeConfig employeeConfig = new EmployeeConfig();
    Connection connection = employeeConfig.getConfig();

    public List<Employee> queryExecute(String query)
    {
       employeeArrayList = new ArrayList<>();
       try {
             preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery();
             while (resultSet.next())
             {
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
          }
       catch (SQLException e)
       {
           e.printStackTrace();
       }
        return employeeArrayList;
    }

    public void display()
    {
        for (Employee employee:employeeArrayList)
        {
            System.out.println(employee.toString());
        }
    }

    public double updateBasicPay(String empName,double basicPay)
    {
        String update = "update employee_payroll set Basic_Pay = ? where name = ? ";
        try
        {
           preparedStatement = connection.prepareStatement(update);
           preparedStatement.setDouble(1,basicPay);
           preparedStatement.setString(2,empName);
           preparedStatement.executeUpdate();
            System.out.println("Update Successfully");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
         String sql = "select * from employee_payroll";
         queryExecute(sql);
        for (Employee employee:employeeArrayList)
        {
            if (employee.getEmpName().equals(empName))
            {
                return employee.basicPay;
            }
        }
        return 0.0;
    }

    public void selectEmployee(LocalDate start,LocalDate end)
    {
        ArrayList<Employee> empSelected = new ArrayList<>();
        String select = "select * from employee_payroll where empStart between ? AND ? ";
        String startDate = String.valueOf(start);
        String endDate = String.valueOf(end);

        try
        {
            preparedStatement = connection.prepareStatement(select);
            preparedStatement.setString(1,startDate);
            preparedStatement.setString(2,endDate);
            ResultSet resultSet =preparedStatement.executeQuery();

            while (resultSet.next())
            {
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
            for (Employee employee:empSelected)
            {
                System.out.println(employee);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
