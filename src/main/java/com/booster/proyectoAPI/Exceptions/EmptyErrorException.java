package com.booster.proyectoAPI.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

public class EmptyErrorException extends RuntimeException{

    private String code;

    private HttpStatus httpStatus;

    private BindingResult result;

    public EmptyErrorException(String message, String code, HttpStatus httpStatus, BindingResult result) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public BindingResult getResult() {
        return result;
    }

    public void setResult(BindingResult result) {
        this.result = result;
    }
}
