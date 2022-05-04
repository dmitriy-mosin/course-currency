package com.example.coursecurrency.error.handler;


import com.example.coursecurrency.error.exception.CourseNotFoundException;
import com.example.coursecurrency.error.exception.CourseParseException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final ErrorResponseBuilder responseBuilder;

    @ExceptionHandler(value = CourseNotFoundException.class)
    protected ResponseEntity<Object> handleNotFound(CourseNotFoundException ex, WebRequest request) {
        return handleExceptionInternal(ex, responseBuilder.build("404", ex.getMessage()),
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = CourseParseException.class)
    protected ResponseEntity<Object> handleParseError(CourseParseException ex, WebRequest request) {
        return handleExceptionInternal(ex, responseBuilder.build("500", ex.getMessage()),
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
