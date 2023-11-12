package com.booster.proyectoAPI.Exceptions;

import org.springframework.http.HttpStatus;

public class NotFoudErrorException extends RuntimeException{

    private String code;

    private HttpStatus httpStatus;

    public NotFoudErrorException(String message, String code, HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
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
}
