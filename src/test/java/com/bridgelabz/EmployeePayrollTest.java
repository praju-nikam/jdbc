package com.bridgelabz;

import com.bridgelabz.employeepayroll.EmployeePayrollService;
import org.junit.Assert;
import org.junit.Test;


public class EmployeePayrollTest
{
    EmployeePayrollService employeePayrollService = new EmployeePayrollService();

    @Test
    public void givenUpdatingMayuriBasicPay_whenUpdate_ShouldReturnUpdatedPay() {
        double BasicPay = 35000;
        String Name = "Mayuri";
        double salaryUpdated = employeePayrollService.updateBasicPay(Name, BasicPay);
        Assert.assertEquals(BasicPay, salaryUpdated,35000);
    }


}
