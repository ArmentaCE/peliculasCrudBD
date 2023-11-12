package com.booster.proyectoAPI.controller;
import com.booster.proyectoAPI.Exceptions.EmptyErrorException;
import com.booster.proyectoAPI.Exceptions.NotFoudErrorException;
import com.booster.proyectoAPI.Util.ModelError;
import com.booster.proyectoAPI.Util.ModelErrorNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = EmptyErrorException.class)
    public ResponseEntity<ModelError> modelErrorResponseEntity(EmptyErrorException exception){
        List<String> errors = exception.getResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        ModelError modelError = new ModelError(exception.getMessage(), exception.getCode(), errors);
        return new ResponseEntity<>(modelError, exception.getHttpStatus());
    }

    public ResponseEntity<ModelError> updateMovieEmptyException(EmptyErrorException exception){
        List<String> errors = exception.getResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        ModelError modelError = new ModelError(exception.getMessage(), exception.getCode(), errors);
        return  new ResponseEntity<>(modelError, exception.getHttpStatus());
    }

    @ExceptionHandler(value = NotFoudErrorException.class)
    public ResponseEntity<ModelErrorNotFound> getMovieByIdNotFound(NotFoudErrorException exception){
        ModelErrorNotFound notFound = new ModelErrorNotFound(exception.getMessage(), exception.getCode());
        return new ResponseEntity<>(notFound,exception.getHttpStatus());
    }

    public ResponseEntity<ModelErrorNotFound> deteleMovieByIdNotFound(NotFoudErrorException exception){
        ModelErrorNotFound notFound = new ModelErrorNotFound(exception.getMessage(), exception.getCode());
        return  new ResponseEntity<>(notFound, exception.getHttpStatus());
    }

}
