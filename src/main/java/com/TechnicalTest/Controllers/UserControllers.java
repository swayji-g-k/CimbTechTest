package com.TechnicalTest.Controllers;

import com.TechnicalTest.Models.UserEntity;
import com.TechnicalTest.Requests.UserRequests;
import com.TechnicalTest.Responses.DataResponse;
import com.TechnicalTest.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/users")
public class UserControllers {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAllUsers")
    public DataResponse getAllUsers() {
        return userService.getListUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getUser/{id}")
    public DataResponse getUser(@PathVariable("id") Integer userId) {
        return userService.getUser(userId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addUser")
    public DataResponse addUser(@RequestBody UserRequests userRequests) {
        return userService.createUser(userRequests);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateUser/{id}")
    public DataResponse updateUser(@PathVariable("id") Integer userId, @RequestBody UserRequests userRequests) {
        return userService.UpdateUser(userId, userRequests);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser/{id}")
    public DataResponse deleteUser(@PathVariable("id") Integer userId) {
        return userService.DeleteUser(userId);
    }
}
