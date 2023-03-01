package com.TechnicalTest.Services;

import com.TechnicalTest.Requests.TransactionHistoryRequests;
import com.TechnicalTest.Responses.DataResponse;

public interface TransactionHistoryService {

    DataResponse getAllTransactionHistory();
    DataResponse getTransactionHistory(Integer transHistoryId);
    DataResponse addTransactionHistory(TransactionHistoryRequests transHistoryRequests);
    DataResponse updateTransactionHistory(Integer transHistoryId, TransactionHistoryRequests transHistoryRequests);
    DataResponse deleteTransactionHistory(Integer transHistoryId);
}
