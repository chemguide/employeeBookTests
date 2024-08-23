package com.example.employeeBookTests;

import com.example.employeeBookTests.Exceptions.DepartmentIsEmptyException;
import com.example.employeeBookTests.Services.DepartmentService;
import com.example.employeeBookTests.Services.DepartmentServiceImpl;
import com.example.employeeBookTests.Services.EmployeeService;
import com.example.employeeBookTests.Services.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class DepartmentServiceTests {


    private static final List<Employee> employeeList = List.of(
            new Employee("Ivan", "Ivanov", 1, 1000),
            new Employee("Petr", "Ivanov", 1, 2000),
            new Employee("Semen", "Ivanov", 1, 3000),
            new Employee("Pavel", "Ivanov", 1, 4000),
            new Employee("Michail", "Ivanov", 1, 5000));

    private final int realDepartment = 1, ghostDepartment = 2;


    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl departmentService;


    @Test
    public void shouldReturnCorrectSumByDepartment() {
        when(employeeServiceMock.getAllEmployeeByDepartment(realDepartment)).thenReturn(employeeList);
        double expected = 0;
        for (Employee employee : employeeList) {
            expected += employee.getSalary();
        }
        Assertions.assertEquals(expected, departmentService.getSumByDepartment(realDepartment));
    }

    @Test
    public void shouldThrowExceptionWhenDepartmentNotExistWhenCalculatingSum() {
        when(employeeServiceMock.getAllEmployeeByDepartment(ghostDepartment)).thenThrow(DepartmentIsEmptyException.class);
        Assertions.assertThrows(DepartmentIsEmptyException.class,
                () -> departmentService.getSumByDepartment(ghostDepartment));
    }


    @Test
    public void shouldReturnCorrectMinByDepartment() {
        when(employeeServiceMock.getAllEmployeeByDepartment(realDepartment)).thenReturn(employeeList);
        Employee expected = new Employee("Ivan", "Ivanov", 1, 1000);
        Assertions.assertEquals(expected, departmentService.getMinByDepartment(realDepartment));
    }

    @Test
    public void shouldThrowExceptionWhenDepartmentNotExistWhenCalculatingMin() {
        when(employeeServiceMock.getAllEmployeeByDepartment(ghostDepartment)).thenThrow(DepartmentIsEmptyException.class);
        Assertions.assertThrows(DepartmentIsEmptyException.class,
                () -> departmentService.getMinByDepartment(ghostDepartment));
    }

    @Test
    public void shouldReturnCorrectMaxByDepartment() {
        when(employeeServiceMock.getAllEmployeeByDepartment(realDepartment)).thenReturn(employeeList);
        Employee expected = new Employee("Michail", "Ivanov", 1, 5000);
        Assertions.assertEquals(expected, departmentService.getMaxByDepartment(realDepartment));
    }

    @Test
    public void shouldThrowExceptionWhenDepartmentNotExistWhenCalculatingMax() {
        when(employeeServiceMock.getAllEmployeeByDepartment(ghostDepartment)).thenThrow(DepartmentIsEmptyException.class);
        Assertions.assertThrows(DepartmentIsEmptyException.class,
                () -> departmentService.getMaxByDepartment(ghostDepartment));
    }

}
