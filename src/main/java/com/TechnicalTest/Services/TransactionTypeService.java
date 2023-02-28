package com.TechnicalTest.Services;

import com.TechnicalTest.Requests.TransactionTypeRequests;
import com.TechnicalTest.Requests.UserRequests;
import com.TechnicalTest.Responses.DataResponse;

public interface TransactionTypeService {

    DataResponse getAllTransactionType();
    DataResponse getTransactionType(Integer userId);
    DataResponse addTransactionType(TransactionTypeRequests transTypeRequests);
    DataResponse updateTransactionType(Integer transTypeId, TransactionTypeRequests transTypeRequests);
    DataResponse deleteTransactionType(Integer transTypeId);
}
