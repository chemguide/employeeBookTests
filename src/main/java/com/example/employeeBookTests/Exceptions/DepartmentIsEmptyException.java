package com.example.employeeBookTests.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class DepartmentIsEmptyException extends RuntimeException {
    public DepartmentIsEmptyException() {
        super();
    }
}
