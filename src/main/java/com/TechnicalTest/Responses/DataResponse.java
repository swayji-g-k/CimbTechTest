package com.TechnicalTest.Responses;

public class DataResponse<T extends Object> extends ResponseTemplate {
    private T data;

    public DataResponse(Integer status, String message, T data) {
        super(status, message);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}