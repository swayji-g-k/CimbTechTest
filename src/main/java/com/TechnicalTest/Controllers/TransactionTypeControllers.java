package com.TechnicalTest.Controllers;

import com.TechnicalTest.Requests.TransactionTypeRequests;
import com.TechnicalTest.Responses.DataResponse;
import com.TechnicalTest.Services.TransactionTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/transaction-type")
@PreAuthorize("hasAuthority('SCOPE_ADMIN')")
public class TransactionTypeControllers {

    @Autowired
    TransactionTypeService transactionTypeService;

    @Operation(security = {@SecurityRequirement(name = "Authorization")})
    @RequestMapping(method = RequestMethod.GET, value = "/getAllTransactionType")
    public DataResponse getAllTransactionType() {
        return transactionTypeService.getAllTransactionType();
    }

    @Operation(security = {@SecurityRequirement(name = "Authorization")})
    @RequestMapping(method = RequestMethod.GET, value = "/getTransactionType/{id}")
    public DataResponse getTransactionType(@PathVariable("id") Integer transTypeId) {
        return transactionTypeService.getTransactionType(transTypeId);
    }

    @Operation(security = {@SecurityRequirement(name = "Authorization")})
    @RequestMapping(method = RequestMethod.POST, value = "/addTransactionType")
    public DataResponse addTransactionType(@RequestBody TransactionTypeRequests transTypeRequests) {
        return transactionTypeService.addTransactionType(transTypeRequests);
    }

    @Operation(security = {@SecurityRequirement(name = "Authorization")})
    @RequestMapping(method = RequestMethod.PUT, value = "/updateTransactionType/{id}")
    public DataResponse updateTransactionType(@PathVariable("id") Integer transTypeId, @RequestBody TransactionTypeRequests transTypeRequests) {
        return transactionTypeService.updateTransactionType(transTypeId, transTypeRequests);
    }

    @Operation(security = {@SecurityRequirement(name = "Authorization")})
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteTransactionType/{id}")
    public DataResponse deleteTransactionType(@PathVariable("id") Integer transTypeId) {
        return transactionTypeService.deleteTransactionType(transTypeId);
    }
}
