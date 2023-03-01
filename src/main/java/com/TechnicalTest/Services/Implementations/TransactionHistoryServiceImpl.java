package com.TechnicalTest.Services.Implementations;

import com.TechnicalTest.Models.TransactionTypeEntity;
import com.TechnicalTest.Repositorys.TransactionTypeEntityRepository;
import com.TechnicalTest.Requests.TransactionHistoryRequests;
import com.TechnicalTest.Responses.DataResponse;
import com.TechnicalTest.Services.TransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {

    @Autowired
    TransactionTypeEntityRepository transactionTypeEntityRepository;

    public DataResponse getAllTransactionType() {
        List<TransactionTypeEntity> usersList = transactionTypeEntityRepository.findAll();
        return new DataResponse(HttpStatus.OK.value(), "success", usersList);
    }

    public DataResponse getTransactionType(Integer userId) {
        BigInteger id = BigInteger.valueOf(userId);
        Optional<TransactionTypeEntity> currentTransType = transactionTypeEntityRepository.findById(id);
        if (currentTransType.isPresent()) {
            TransactionTypeEntity transType = currentTransType.get();
            return new DataResponse(HttpStatus.OK.value(), "success", transType);
        } else {
            return new DataResponse(HttpStatus.NOT_FOUND.value(), "failed", null);
        }
    }

    @Transactional
    public DataResponse addTransactionType(TransactionHistoryRequests transHistoryRequests) {
        TransactionTypeEntity newTransType = new TransactionTypeEntity();
        TransactionTypeEntity checkTransTypeCode = transactionTypeEntityRepository.findTopByTransactionCode(transHistoryRequests.getTransactionCode());
        if (checkTransTypeCode == null) {
            newTransType.setTransactionCode(transHistoryRequests.getTransactionCode());
            newTransType.setTransactionName(transHistoryRequests.getTransactionName());
            newTransType = transactionTypeEntityRepository.save(newTransType);
            return new DataResponse(HttpStatus.OK.value(), "success", newTransType);
        } else {
            return new DataResponse(HttpStatus.FOUND.value(), "failed", null);
        }
    }

    @Transactional
    public DataResponse updateTransactionType(Integer transTypeId, TransactionHistoryRequests transHistoryRequests) {
        BigInteger id = BigInteger.valueOf(transTypeId);
        Optional<TransactionTypeEntity> currentTransType = transactionTypeEntityRepository.findById(id);
        if (currentTransType.isPresent()) {
            TransactionTypeEntity TransType = currentTransType.get();
            TransType.setTransactionCode(transHistoryRequests.getTransactionCode());
            TransType.setTransactionName(transHistoryRequests.getTransactionName());
            TransType = transactionTypeEntityRepository.save(TransType);
            return new DataResponse(HttpStatus.OK.value(), "success", TransType);
        } else {
            return new DataResponse(HttpStatus.NOT_FOUND.value(), "failed", null);
        }
    }

    @Transactional
    public DataResponse deleteTransactionType(Integer userId) {
        BigInteger id = BigInteger.valueOf(userId);
        Optional<TransactionTypeEntity> currentTransType = transactionTypeEntityRepository.findById(id);
        if (currentTransType.isPresent()) {
            TransactionTypeEntity transType = currentTransType.get();
            transactionTypeEntityRepository.delete(transType);
            return new DataResponse(HttpStatus.OK.value(), "success", transType);
        } else {
            return new DataResponse(HttpStatus.NOT_FOUND.value(), "failed", null);
        }
    }
}
