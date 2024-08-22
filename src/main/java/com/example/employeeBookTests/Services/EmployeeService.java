package com.example.employeeBookTests.Services;

import com.example.employeeBookTests.Employee;
import com.example.employeeBookTests.EmployeeController;
import com.example.employeeBookTests.Exceptions.EmployeeNotFoundException;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String name, String surname, int department, double salary);

    Map<Integer, List<Employee>> getAllEmployee();

    List<Employee> getAllEmployeeByDepartment(int id);

    Employee findEmployee(String name, String surname, int department, double salary);

     Employee removeEmployee(String name, String surname, int department, double salary);
}
