package com.example.employeeBookTests;

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

    private final int id = 1;


    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @BeforeEach
    public void getList() {
        when(employeeServiceMock.getAllEmployeeByDepartment(id)).thenReturn(employeeList);
    }


    @Test
    public void shouldReturnCorrectSumByDepartment() {
        double expected = 0;
        for (Employee employee : employeeList) {
            expected += employee.getSalary();
        }
        Assertions.assertEquals(expected, departmentService.getSumByDepartment(id));
    }


    @Test
    public void shouldReturnCorrectMinByDepartment() {
        Employee expected = new Employee("Ivan", "Ivanov", 1, 1000);
        Assertions.assertEquals(expected, departmentService.getMinByDepartment(id));
    }

    @Test
    public void shouldReturnCorrectMaxByDepartment() {
        Employee expected = new Employee("Michail", "Ivanov", 1, 5000);
        Assertions.assertEquals(expected, departmentService.getMaxByDepartment(id));
    }

}
