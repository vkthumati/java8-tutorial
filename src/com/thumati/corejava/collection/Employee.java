package com.thumati.corejava.collection;

import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private String name;
    private Double salary;

    public Employee(String name, Double salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        //return name.equals(employee.name) && salary.equals(employee.salary);
        return Double.compare(employee.salary, salary)==0 && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    // Compare two employee objects by their salary
    @Override
    public int compareTo(Employee employee) {
        if(this.getSalary() > employee.getSalary()){
            return 1;
        }else if(this.getSalary() < employee.getSalary()){
            return -1;
        }else{
            return 0;
        }
    }
}
