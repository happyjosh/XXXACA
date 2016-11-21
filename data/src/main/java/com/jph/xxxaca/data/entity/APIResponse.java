package com.jph.xxxaca.data.entity;

/**
 * 服务器返回的最基础的结构
 * Created by jph on 2016/11/18.
 */
public class APIResponse<T> {
    /**
     * 服务器处理成功code
     */
    public static final int SUCCESS_CODE = 200;

    private int code;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public boolean isSuccess() {
        return getCode() == SUCCESS_CODE;
    }
}
