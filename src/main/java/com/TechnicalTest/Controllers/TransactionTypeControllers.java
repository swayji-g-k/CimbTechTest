package com.TechnicalTest.Controllers;

import com.TechnicalTest.Requests.UserRequests;
import com.TechnicalTest.Responses.DataResponse;
import com.TechnicalTest.Services.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/transaction-type")
public class TransactionTypeControllers {

    @Autowired
    TransactionTypeService transactionTypeService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAllUsers")
    public DataResponse getAllUsers() {
        return transactionTypeService.getListUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getUser/{id}")
    public DataResponse getUser(@PathVariable("id") Integer userId) {
        return transactionTypeService.getUser(userId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addUser")
    public DataResponse addUser(@RequestBody UserRequests userRequests) {
        return transactionTypeService.createUser(userRequests);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateUser/{id}")
    public DataResponse updateUser(@PathVariable("id") Integer userId, @RequestBody UserRequests userRequests) {
        return transactionTypeService.UpdateUser(userId, userRequests);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser/{id}")
    public DataResponse deleteUser(@PathVariable("id") Integer userId) {
        return transactionTypeService.DeleteUser(userId);
    }
}
