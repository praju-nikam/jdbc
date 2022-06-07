package com.bridgelabz.employeepayroll;

public class Employee
{

    int empId;
    String empName,phoneNumber,address,startDate,gender;
    double basicPay,deductions,taxablePay,netPay;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String empStart) {
        this.startDate = startDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public double getTaxablePay() {
        return taxablePay;
    }

    public void setTaxablePay(double taxablePay) {
        this.taxablePay = taxablePay;
    }

    public double getNetPay() {
        return netPay;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", startDate='" + startDate + '\'' +
                ", gender='" + gender + '\'' +
                ", basicPay=" + basicPay +
                ", deductions=" + deductions +
                ", taxablePay=" + taxablePay +
                ", netPay=" + netPay +
                '}';
    }
}
