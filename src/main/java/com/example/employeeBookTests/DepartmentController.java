package com.example.employeeBookTests;

import com.example.employeeBookTests.Services.DepartmentService;
import com.example.employeeBookTests.Services.EmployeeService;
import com.example.employeeBookTests.Services.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    public DepartmentController (DepartmentService departmentService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }
    @GetMapping("/{id}/employees")
    public List<Employee> getAllEmployeeByDepartment(@PathVariable int id) {
        return employeeService.getAllEmployeeByDepartment(id);
    }

    @GetMapping("/{id}/salary/sum")
    public double getSumByDepartment(@PathVariable int id) {
        return departmentService.getSumByDepartment(id);
    }

    @GetMapping("/{id}/salary/max")
    public Employee getMaxByDepartment(@PathVariable int id) {
        return departmentService.getMaxByDepartment(id);
    }

    @GetMapping("/{id}/salary/min")
    public Employee getMMinByDepartment(@PathVariable int id) {
        return departmentService.getMinByDepartment(id);
    }
}
