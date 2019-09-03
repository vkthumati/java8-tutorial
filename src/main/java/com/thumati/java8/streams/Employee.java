package com.thumati.java8.streams;

public class Employee {
    private String empName;
    private long empID;
    private long deptID;
    private long salary;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public long getEmpID() {
        return empID;
    }

    public void setEmpID(long empID) {
        this.empID = empID;
    }

    public long getDeptID() {
        return deptID;
    }

    public void setDeptID(long deptID) {
        this.deptID = deptID;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee["+empName+","+empID+","+deptID+","+salary+"]";
    }
}
