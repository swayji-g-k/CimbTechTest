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

    @RequestMapping(method = RequestMethod.GET, value = "/getAllTransactionHistory")
    public DataResponse getAllTransactionHistory() {
        return transactionHistoryService.getAllTransactionHistory();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getTransactionHistory/{id}")
    public DataResponse getTransactionHistory(@PathVariable("id") Integer transHistoryId) {
        return transactionHistoryService.getTransactionHistory(transHistoryId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addTransactionHistory")
    public DataResponse addTransactionHistory(@RequestBody TransactionHistoryRequests transHistoryRequests) {
        return transactionHistoryService.addTransactionHistory(transHistoryRequests);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateTransactionHistory/{id}")
    public DataResponse updateTransactionHistory(@PathVariable("id") Integer transHistoryId, @RequestBody TransactionHistoryRequests transHistoryRequests) {
        return transactionHistoryService.updateTransactionHistory(transHistoryId, transHistoryRequests);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteTransactionHistory/{id}")
    public DataResponse deleteTransactionHistory(@PathVariable("id") Integer transHistoryId) {
        return transactionHistoryService.deleteTransactionHistory(transHistoryId);
    }
}
