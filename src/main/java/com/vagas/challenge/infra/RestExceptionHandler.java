package com.vagas.challenge.infra;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ErrorHandler MethodNotNull(MethodArgumentNotValidException exception) {
        FieldError fieldErros = exception.getBindingResult().getFieldErrors().get(0);
        var errorHandler = new ErrorHandler(fieldErros.getField(), fieldErros.getDefaultMessage());
        return errorHandler ;
    }
}
