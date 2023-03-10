package com.shop.shopWithBaskets.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {BadIdException.class})
    public ResponseEntity<Object> handleApiRequestException(BadIdException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(e.getMessage(), badRequest);
        return new ResponseEntity<>(apiException, badRequest);
    }

    @ExceptionHandler(value = {BlankValueException.class})
    public ResponseEntity<Object> handleApiRequestException(BlankValueException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(e.getMessage(), badRequest);
        return new ResponseEntity<>(apiException, badRequest);
    }
}
