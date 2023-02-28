package com.TechnicalTest.Services;

import com.TechnicalTest.Models.UserEntity;
import com.TechnicalTest.Requests.UserRequests;
import com.TechnicalTest.Responses.DataResponse;

import java.util.List;

public interface UserService {

    DataResponse getListUsers();
    DataResponse getUser(Integer userId);
    DataResponse createUser(UserRequests userRequests);
    DataResponse UpdateUser(Integer userId, UserRequests updateUserRequests);
    DataResponse DeleteUser(Integer userId);
}
