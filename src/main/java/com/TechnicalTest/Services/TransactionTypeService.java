package com.TechnicalTest.Services;

import com.TechnicalTest.Requests.UserRequests;
import com.TechnicalTest.Responses.DataResponse;

public interface TransactionTypeService {

    DataResponse getListUsers();
    DataResponse getUser(Integer userId);
    DataResponse createUser(UserRequests userRequests);
    DataResponse UpdateUser(Integer userId, UserRequests updateUserRequests);
    DataResponse DeleteUser(Integer userId);
}
