package com.example.employeeBookTests.Services;

import com.example.employeeBookTests.Employee;
import com.example.employeeBookTests.Services.DepartmentService;
import com.example.employeeBookTests.Services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public double getSumByDepartment(int id) {
        double sum = 0;
        List<Employee> list = employeeService.getAllEmployeeByDepartment(id);
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getSalary();
        }
        return sum;
    }

    public Employee getMaxByDepartment(int id) {
        List<Employee> list = employeeService.getAllEmployeeByDepartment(id);
        Employee max = list.get(0);
        for (Employee employee : list) if (employee.getSalary() > max.getSalary()) max = employee;
        return max;
    }

    public Employee getMinByDepartment(int id) {
        List<Employee> list = employeeService.getAllEmployeeByDepartment(id);
        Employee min = list.get(0);
        for (Employee employee : list) if (employee.getSalary() < min.getSalary()) min = employee;
        return min;
    }
}
