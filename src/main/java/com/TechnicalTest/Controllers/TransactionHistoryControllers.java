package com.TechnicalTest.Controllers;

import com.TechnicalTest.Requests.TransactionHistoryRequests;
import com.TechnicalTest.Responses.DataResponse;
import com.TechnicalTest.Services.TransactionHistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/transaction-history")
@PreAuthorize("hasAuthority('SCOPE_ADMIN')")
public class TransactionHistoryControllers {

    @Autowired
    TransactionHistoryService transactionHistoryService;

    @Operation(security = {@SecurityRequirement(name = "Authorization")})
    @RequestMapping(method = RequestMethod.GET, value = "/getAllTransactionHistory")
    public DataResponse getAllTransactionHistory() {
        return transactionHistoryService.getAllTransactionHistory();
    }

    @Operation(security = {@SecurityRequirement(name = "Authorization")})
    @RequestMapping(method = RequestMethod.GET, value = "/getTransactionHistory/{id}")
    public DataResponse getTransactionHistory(@PathVariable("id") Integer transHistoryId) {
        return transactionHistoryService.getTransactionHistory(transHistoryId);
    }

    @Operation(security = {@SecurityRequirement(name = "Authorization")})
    @RequestMapping(method = RequestMethod.POST, value = "/addTransactionHistory")
    public DataResponse addTransactionHistory(@RequestBody TransactionHistoryRequests transHistoryRequests) {
        return transactionHistoryService.addTransactionHistory(transHistoryRequests);
    }

    @Operation(security = {@SecurityRequirement(name = "Authorization")})
    @RequestMapping(method = RequestMethod.PUT, value = "/updateTransactionHistory/{id}")
    public DataResponse updateTransactionHistory(@PathVariable("id") Integer transHistoryId, @RequestBody TransactionHistoryRequests transHistoryRequests) {
        return transactionHistoryService.updateTransactionHistory(transHistoryId, transHistoryRequests);
    }

    @Operation(security = {@SecurityRequirement(name = "Authorization")})
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteTransactionHistory/{id}")
    public DataResponse deleteTransactionHistory(@PathVariable("id") Integer transHistoryId) {
        return transactionHistoryService.deleteTransactionHistory(transHistoryId);
    }
}
