package com.TechnicalTest.Responses;

import lombok.Data;

@Data
public class ResponseTemplate {
    private String status;
    private String message;

    public ResponseTemplate(Integer status, String message) {
        this.status = status.toString();
        this.message = message;
    }
}
