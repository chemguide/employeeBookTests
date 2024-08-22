package com.example.employeeBookTests;

import com.example.employeeBookTests.Exceptions.DepartmentIsEmptyException;
import com.example.employeeBookTests.Exceptions.EmployeeAlreadyAddedException;
import com.example.employeeBookTests.Exceptions.EmployeeNotFoundException;
import com.example.employeeBookTests.Exceptions.NoEmployeeInCompanyException;
import com.example.employeeBookTests.Services.EmployeeService;
import com.example.employeeBookTests.Services.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class EmployeeServiceTests {

    private final EmployeeService employeeService = new EmployeeServiceImpl();

    private final int ghostDepartment = 2, realDepartment = 1;
    Employee employee = new Employee("Ivan", "Ivanov", realDepartment, 1000);


    @Test
    public void shouldNotPrintEmployeeIfEmployeesIsNull() {
        Assertions.assertThrows(NoEmployeeInCompanyException.class,
                () -> employeeService.getAllEmployee());
    }

    @Test
    public void shouldAddEmployeeIfNotPresent() {
        List<Employee> list = new ArrayList<>();
        list.add(employee);
        Map<Integer, List<Employee>> outMap = new HashMap<>();
        outMap.put(1, list);
        employeeService.addEmployee("Ivan", "Ivanov", realDepartment, 1000);
        Assertions.assertEquals(employeeService.getAllEmployee(), outMap);
    }

    @Test
    public void shouldNotAddEmployeeIfPresent() {
        employeeService.addEmployee("Ivan", "Ivanov", realDepartment, 1000);
        Assertions.assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService.addEmployee("Ivan", "Ivanov", realDepartment, 1000));
    }

    @Test
    public void shouldFindEmployeeIfItExist() {
        employeeService.addEmployee("Ivan", "Ivanov", realDepartment, 1000);
        Assertions.assertEquals(employeeService.findEmployee("Ivan", "Ivanov", realDepartment, 1000), employee);
    }

    @Test
    public void shouldThrowExceptionWhenLookingForIfEmployeeNotExist() {
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.findEmployee("Ivan", "Ivanov", realDepartment, 1000));
    }

    @Test
    public void shouldRemoveEmployeeIfItExist() {
        List<Employee> list = new ArrayList<>();
        list.add(employee);
        Map<Integer, List<Employee>> outMap = new HashMap<>();
        employeeService.addEmployee("Ivan", "Ivanov", realDepartment, 1000);
        employeeService.addEmployee("Petr", "Petrov", realDepartment, 1000);
        employeeService.removeEmployee("Petr", "Petrov", realDepartment, 1000);
        outMap.put(1, list);
        Assertions.assertEquals(employeeService.getAllEmployee(), outMap);
    }

    @Test
    public void shouldThrowExceptionWhenRemovingIfEmployeeNotExist() {
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.removeEmployee("Ivan", "Ivanov", realDepartment, 1000));
    }

    @Test
    public void shouldThrowExceptionIfDepartmentNotExist() {
        employeeService.addEmployee("Ivan", "Ivanov", realDepartment, 1000);
        Assertions.assertThrows(DepartmentIsEmptyException.class,
                () -> employeeService.getAllEmployeeByDepartment(ghostDepartment));
    }
}
