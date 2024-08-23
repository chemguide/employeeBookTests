package com.example.employeeBookTests.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
public class EmployeeLimitException extends RuntimeException {
    public EmployeeLimitException() {
        super();
    }
}
