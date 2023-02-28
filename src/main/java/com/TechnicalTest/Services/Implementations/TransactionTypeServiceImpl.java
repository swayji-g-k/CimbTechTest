package com.TechnicalTest.Services.Implementations;

import com.TechnicalTest.Models.TransactionTypeEntity;
import com.TechnicalTest.Models.UserEntity;
import com.TechnicalTest.Repositorys.TransactionTypeEntityRepository;
import com.TechnicalTest.Requests.TransactionTypeRequests;
import com.TechnicalTest.Requests.UserRequests;
import com.TechnicalTest.Responses.DataResponse;
import com.TechnicalTest.Services.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionTypeServiceImpl implements TransactionTypeService {

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
    public DataResponse addTransactionType(TransactionTypeRequests transTypeRequests) {
        TransactionTypeEntity newTransType = new TransactionTypeEntity();
        TransactionTypeEntity checkTransTypeCode = transactionTypeEntityRepository.findTopByTransactionCode(transTypeRequests.getTransactionCode());
        if (checkTransTypeCode == null) {
            newTransType.setTransactionCode(transTypeRequests.getTransactionCode());
            newTransType.setTransactionName(transTypeRequests.getTransactionName());
            newTransType = transactionTypeEntityRepository.save(newTransType);
            return new DataResponse(HttpStatus.OK.value(), "success", newTransType);
        } else {
            return new DataResponse(HttpStatus.FOUND.value(), "failed", null);
        }
    }

    @Transactional
    public DataResponse updateTransactionType(Integer transTypeId, TransactionTypeRequests transTypeRequests) {
        BigInteger id = BigInteger.valueOf(transTypeId);
        Optional<TransactionTypeEntity> currentTransType = transactionTypeEntityRepository.findById(id);
        if (currentTransType.isPresent()) {
            TransactionTypeEntity TransType = currentTransType.get();
            TransType.setTransactionCode(transTypeRequests.getTransactionCode());
            TransType.setTransactionName(transTypeRequests.getTransactionName());
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
