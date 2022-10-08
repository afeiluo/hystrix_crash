package com.afeiluo.crash.controller;


import java.io.Serializable;
import java.util.Map;
import lombok.Data;

@Data
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -5189250864896219179L;
    private boolean success;
    private int code;
    private String msg;
    private T data;
    private Map<String, Object> _extend;


    public static <T> Response<T> success(T data) {
        Response<T> response = new Response();
        response.setSuccess(true);
        response.setData(data);
        return response;
    }
}
