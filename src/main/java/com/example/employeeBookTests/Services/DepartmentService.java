package com.example.employeeBookTests.Services;

import com.example.employeeBookTests.Employee;

import java.util.List;

public interface DepartmentService {
    public double getSumByDepartment(int id);

    public Employee getMaxByDepartment(int id);

    public Employee getMinByDepartment(int id);
}
