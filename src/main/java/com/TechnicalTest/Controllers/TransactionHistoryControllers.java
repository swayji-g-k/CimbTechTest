package com.TechnicalTest.Controllers;

import com.TechnicalTest.Requests.TransactionHistoryRequests;
import com.TechnicalTest.Responses.DataResponse;
import com.TechnicalTest.Services.TransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/transaction-history")
public class TransactionHistoryControllers {

    @Autowired
    TransactionHistoryService transactionHistoryService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAllTransactionType")
    public DataResponse getAllTransactionType() {
        return transactionHistoryService.getAllTransactionType();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getTransactionType/{id}")
    public DataResponse getTransactionType(@PathVariable("id") Integer userId) {
        return transactionHistoryService.getTransactionType(userId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addTransactionType")
    public DataResponse addTransactionType(@RequestBody TransactionHistoryRequests transHistoryRequests) {
        return transactionHistoryService.addTransactionType(transHistoryRequests);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateTransactionType/{id}")
    public DataResponse updateTransactionType(@PathVariable("id") Integer transTypeId, @RequestBody TransactionHistoryRequests transHistoryRequests) {
        return transactionHistoryService.updateTransactionType(transTypeId, transHistoryRequests);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteTransactionType/{id}")
    public DataResponse deleteTransactionType(@PathVariable("id") Integer userId) {
        return transactionHistoryService.deleteTransactionType(userId);
    }
}
