package com.student.ms.student.controller;

import com.student.ms.student.exception.NotFoundException;
import com.student.ms.student.model.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    private static final String ERROR = "exception.student.";

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> handleStudentNotFoundException(NotFoundException exc) {
        return new ResponseEntity<>(new ExceptionDto(ERROR+exc.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> handleRuntimeException() {
        return new ResponseEntity<>(new ExceptionDto(ERROR+"unexpected-error"), HttpStatus.valueOf(500));
    }
}