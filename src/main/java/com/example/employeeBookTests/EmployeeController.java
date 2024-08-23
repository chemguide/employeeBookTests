package com.example.employeeBookTests;

import com.example.employeeBookTests.Services.DepartmentService;
import com.example.employeeBookTests.Services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/print")
    public Map<Integer, List<Employee>> printAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("name") String name,
                                @RequestParam("surname") String surname,
                                @RequestParam("department") int department,
                                @RequestParam("salary") Double salary) {
        return employeeService.addEmployee(name, surname, department, salary);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("name") String name,
                                 @RequestParam("surname") String surname,
                                 @RequestParam("department") int department,
                                 @RequestParam("salary") Double salary) {
        return employeeService.findEmployee(name, surname, department, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("name") String name,
                                   @RequestParam("surname") String surname,
                                   @RequestParam("department") int department,
                                   @RequestParam("salary") Double salary) {
        return employeeService.removeEmployee(name, surname, department, salary);
    }
}
