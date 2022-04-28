package com.example.coursecurrency.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class CourseParseException extends RuntimeException {

    public CourseParseException(String message) {
        super(message);
    }
}
