package com.booster.proyectoAPI.Util;

import java.util.List;

public class ModelError {

    private String message;

    private  String code;

    private List<String> list;

    public ModelError(String message, String code, List<String> list) {
        this.message = message;
        this.code = code;
        this.list = list;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
