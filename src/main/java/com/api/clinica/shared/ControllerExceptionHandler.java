package com.api.clinica.shared;

import com.api.clinica.exceptions.InvalidCredentialsException;
import com.api.clinica.exceptions.ResourceNotFoundException;
import com.api.clinica.shared.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotFoundException(ResourceNotFoundException exception, WebRequest request){
        return new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now(),
                exception.getMessage(),
                request.getDescription(false));
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorMessage invalidCredentialsException(InvalidCredentialsException exception, WebRequest request){
        return new ErrorMessage(
                HttpStatus.FORBIDDEN.value(),
                LocalDateTime.now(),
                exception.getMessage(),
                request.getDescription(false)
        );
    }

}
