package com.TechnicalTest.Controllers;

import com.TechnicalTest.Requests.UserRequests;
import com.TechnicalTest.Responses.DataResponse;
import com.TechnicalTest.Services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/users")
@PreAuthorize("hasAuthority('SCOPE_ADMIN')")
public class UserControllers {

    @Autowired
    UserService userService;

    @Operation(security = {@SecurityRequirement(name = "Authorization")})
    @RequestMapping(method = RequestMethod.GET, value = "/getAllUsers")
    public DataResponse getAllUsers() {
        return userService.getListUsers();
    }

    @Operation(security = {@SecurityRequirement(name = "Authorization")})
    @RequestMapping(method = RequestMethod.GET, value = "/getUser/{id}")
    public DataResponse getUser(@PathVariable("id") Integer userId) {
        return userService.getUser(userId);
    }

    @Operation(security = {@SecurityRequirement(name = "Authorization")})
    @RequestMapping(method = RequestMethod.POST, value = "/addUser")
    public DataResponse addUser(@RequestBody UserRequests userRequests) {
        return userService.createUser(userRequests);
    }

    @Operation(security = {@SecurityRequirement(name = "Authorization")})
    @RequestMapping(method = RequestMethod.PUT, value = "/updateUser/{id}")
    public DataResponse updateUser(@PathVariable("id") Integer userId, @RequestBody UserRequests userRequests) {
        return userService.UpdateUser(userId, userRequests);
    }

    @Operation(security = {@SecurityRequirement(name = "Authorization")})
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser/{id}")
    public DataResponse deleteUser(@PathVariable("id") Integer userId) {
        return userService.DeleteUser(userId);
    }
}
