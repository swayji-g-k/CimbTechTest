package com.TechnicalTest.Requests;

import lombok.Data;

@Data
public class TransactionHistoryRequests {

    private Integer amount;
    private Integer userId;
    private Integer transTypeId;
}