package com.module.user.domain;

import java.io.Serializable;

public class BaseResp<T>
        implements Serializable {
    protected int status;
    protected String message;
    protected T data;

    public BaseResp() {
    }

    public BaseResp(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

