package com.sadek.jpa.test.core.helpers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.lang.reflect.ParameterizedType;

@Getter
public class Response<T> {
    private T data;
    private String message;
    private  int statusCode;
    private String object;
    private boolean isError;

    public Response(T data, java.lang.String message, int statusCode) {
        this.data = data;
        this.message = message;
        this.statusCode = statusCode;
        this.isError = false;
    }

    public Response(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
        this.data = null;
        this.object = null;
        this.isError = true;
    }

    public boolean isError(){
        return this.isError;
    }
}
