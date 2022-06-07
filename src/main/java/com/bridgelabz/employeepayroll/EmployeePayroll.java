package com.bridgelabz.employeepayroll;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayroll
{
    public static void main(String[] args)
    {
        System.out.println("*-*-*-*-*-*- Wel come to jdbc Program -*-*-*-*-*-*");
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        Scanner scanner = new Scanner(System.in);
        int choice=0;
        int exit = 4;
        while (choice != exit)
        {
            System.out.println("Enter your choice :\n 1.Get Employee data \n 2.Update Basic Pay \n 3.Display Employee \n 4.Exit");
            choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                {
                    String query = "select * from employee_payroll";
                    employeePayrollService.queryExecute(query);
                    employeePayrollService.display();
                    System.out.println("");
                }
                break;

                case 2:
                {
                    System.out.println("Enter Employee Name : ");
                    String empName = scanner.next();
                    System.out.println("Enter Basic Pay You want to Update");
                    double basicPay = scanner.nextDouble();
                    employeePayrollService.updateBasicPay(empName,basicPay);
                    System.out.println("");
                }
                break;

                case 3:
                    employeePayrollService.display();
                    System.out.println("");
                    break;

                case 4:
                    System.out.println(" You are Exit");
                    System.out.println("");
            }
        }

    }
}
