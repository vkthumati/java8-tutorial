package com.thumati.java8.streams;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsGroupByExample {
    public static void main(String[] args) throws FileNotFoundException {
        String empFileName = "/Users/vthumati/git/java8-tutorial/employees.csv";

        List<Employee> empList = process(empFileName);

        Map<Long, Long> groupByDeptID = totalSalaryForDepartment(empList);

        groupByDeptID.forEach((k,v) -> System.out.println("DeptId : "+k+" - TotalSalary : "+v));
        //groupByDeptID.entrySet().stream().forEach(System.out::println);
    }

    public static List<Employee> process(String empFileName) throws FileNotFoundException{
        File file = new File("/Users/vthumati/git/java8-tutorial/employees.csv");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        Function<String, Employee> csv2EmpObj = (line) -> {
            Employee employee = new Employee();
            String[] record = line.split(",");
            if (record[0] != null && record[0].trim().length() > 0) {
                employee.setEmpName(record[0]);
            }
            if (record[1] != null && record[1].trim().length() > 0) {
                employee.setEmpID(Long.valueOf(record[1]));
            }
            if (record[2] != null && record[2].trim().length() > 0) {
                employee.setDeptID(Long.valueOf(record[2]));
            }
            if (record[3] != null && record[3].trim().length() > 0) {
                employee.setSalary(Long.valueOf(record[3]));
            }
            return employee;
        };

        List<Employee> empList = bufferedReader.lines().skip(1).map(csv2EmpObj).collect(Collectors.toList());
        return empList;
    }

    public static Map<Long, Long>  totalSalaryForDepartment(List<Employee> empList){
        return empList.stream().collect(Collectors.groupingBy(Employee::getDeptID, Collectors.summingLong(Employee::getSalary)));
    }

    //Find the employee with the maximum salary:
    public static Employee mostExpensiveResource(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.<Employee>maxBy(
                        Comparator.comparing(Employee::getSalary))).get();
    }
}
