package com.example.coursecurrency.error.handler;


import com.example.coursecurrency.model.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static java.util.Collections.emptyList;

@Component
@RequiredArgsConstructor
public class ErrorResponseBuilder {

    public ErrorResponse build(String code, String message) {
        return new ErrorResponse()
                .errorId(UUID.randomUUID().toString())
                .errorCode(code)
                .errorMessage(message)
                .errorDetails(emptyList());
    }
}
