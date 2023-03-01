package com.TechnicalTest.Services;

import com.TechnicalTest.Requests.TransactionHistoryRequests;
import com.TechnicalTest.Responses.DataResponse;

public interface TransactionHistoryService {

    DataResponse getAllTransactionType();
    DataResponse getTransactionType(Integer userId);
    DataResponse addTransactionType(TransactionHistoryRequests transHistoryRequests);
    DataResponse updateTransactionType(Integer transTypeId, TransactionHistoryRequests transHistoryRequests);
    DataResponse deleteTransactionType(Integer transTypeId);
}
