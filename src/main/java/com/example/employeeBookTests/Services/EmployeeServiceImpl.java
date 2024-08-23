package com.example.employeeBookTests.Services;

import com.example.employeeBookTests.Employee;
import com.example.employeeBookTests.Exceptions.*;
import com.example.employeeBookTests.Services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class EmployeeServiceImpl implements EmployeeService {

    public List<Employee> employees = new ArrayList<>();
    private final int employeeNumber = 10;

    public Employee addEmployee(String name, String surname, int department, double salary) {
        if (employees.size() >= employeeNumber) throw new EmployeeLimitException();
        Employee employee = new Employee(name, surname, department, salary);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    public Employee findEmployee(String name, String surname, int department, double salary) {
        Employee employee = new Employee(name, surname, department, salary);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee removeEmployee(String name, String surname, int department, double salary) {
        Employee employee = new Employee(name, surname, department, salary);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    public Map<Integer, List<Employee>> getAllEmployee() {
        Set<Integer> departments = new TreeSet<>();
        Map<Integer, List<Employee>> employeeMap = new HashMap<>();
        if (employees.isEmpty()) throw new NoEmployeeInCompanyException();
        for (Employee employee : employees) {
            departments.add(employee.getDepartment());
        }
        for (Integer id : departments) {
            employeeMap.put(id, getAllEmployeeByDepartment(id));
        }
        return employeeMap;
    }

    public List<Employee> getAllEmployeeByDepartment(int id) {
        if (employees.isEmpty()) {
            throw new NoEmployeeInCompanyException();
        }
        List<Employee> list = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getDepartment() == id) list.add(employee);
        }
        if (list.isEmpty()) throw new DepartmentIsEmptyException();
        return list;
    }

}
