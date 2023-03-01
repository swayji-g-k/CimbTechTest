package com.TechnicalTest.Services.Implementations;

import com.TechnicalTest.Models.TransactionHistoryEntity;
import com.TechnicalTest.Models.TransactionTypeEntity;
import com.TechnicalTest.Models.UserEntity;
import com.TechnicalTest.Repositorys.TransactionHistoryEntityRepository;
import com.TechnicalTest.Repositorys.TransactionTypeEntityRepository;
import com.TechnicalTest.Repositorys.UserEntityRepository;
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
    UserEntityRepository userEntityRepository;

    @Autowired
    TransactionTypeEntityRepository transTypeEntityRepository;

    @Autowired
    TransactionHistoryEntityRepository transHistoryEntityRepository;

    public DataResponse getAllTransactionHistory() {
        List<TransactionHistoryEntity> historyList = transHistoryEntityRepository.findAll();
        return new DataResponse(HttpStatus.OK.value(), "success", historyList);
    }

    public DataResponse getTransactionHistory(Integer transHistoryId) {
        BigInteger id = BigInteger.valueOf(transHistoryId);
        Optional<TransactionHistoryEntity> currentTransHistory = transHistoryEntityRepository.findById(id);
        if (currentTransHistory.isPresent()) {
            return new DataResponse(HttpStatus.OK.value(), "success", currentTransHistory.get());
        } else {
            return new DataResponse(HttpStatus.NOT_FOUND.value(), "failed", null);
        }
    }

    @Transactional
    public DataResponse addTransactionHistory(TransactionHistoryRequests transHistoryRequests) {
        BigInteger userId = BigInteger.valueOf(transHistoryRequests.getUserId());
        BigInteger transTypeId = BigInteger.valueOf(transHistoryRequests.getTransTypeId());

        Optional<UserEntity> checkUser = userEntityRepository.findById(userId);
        Optional<TransactionTypeEntity> checkTransType = transTypeEntityRepository.findById(transTypeId);
        if (checkUser.isPresent() && checkTransType.isPresent()) {
            TransactionHistoryEntity newTransHistory = new TransactionHistoryEntity();
            newTransHistory.setAmount(BigInteger.valueOf(transHistoryRequests.getAmount()));
            newTransHistory.setUserEntity(checkUser.get());
            newTransHistory.setTransactionType(checkTransType.get());
            newTransHistory = transHistoryEntityRepository.save(newTransHistory);
            return new DataResponse(HttpStatus.OK.value(), "success", newTransHistory);
        } else {
            return new DataResponse(HttpStatus.FOUND.value(), "failed", null);
        }
    }

    @Transactional
    public DataResponse updateTransactionHistory(Integer transHistoryId, TransactionHistoryRequests transHistoryRequests) {
        BigInteger userId = BigInteger.valueOf(transHistoryRequests.getUserId());
        BigInteger transTypeId = BigInteger.valueOf(transHistoryRequests.getTransTypeId());
        BigInteger historyId = BigInteger.valueOf(transHistoryId);

        Optional<TransactionHistoryEntity> checkTransHistory = transHistoryEntityRepository.findById(historyId);
        Optional<UserEntity> checkUser = userEntityRepository.findById(userId);
        Optional<TransactionTypeEntity> checkTransType = transTypeEntityRepository.findById(transTypeId);
        if (checkTransHistory.isPresent() && checkUser.isPresent() && checkTransType.isPresent()) {
            TransactionHistoryEntity currentTransHistory = checkTransHistory.get();
            currentTransHistory.setAmount(BigInteger.valueOf(transHistoryRequests.getAmount()));
            currentTransHistory.setUserEntity(checkUser.get());
            currentTransHistory.setTransactionType(checkTransType.get());
            currentTransHistory = transHistoryEntityRepository.save(currentTransHistory);
            return new DataResponse(HttpStatus.OK.value(), "success", currentTransHistory);
        } else {
            return new DataResponse(HttpStatus.FOUND.value(), "failed", null);
        }
    }

    @Transactional
    public DataResponse deleteTransactionHistory(Integer transHistoryId) {
        BigInteger id = BigInteger.valueOf(transHistoryId);
        Optional<TransactionHistoryEntity> currentTransHistory = transHistoryEntityRepository.findById(id);
        if (currentTransHistory.isPresent()) {
            TransactionHistoryEntity transHistory = currentTransHistory.get();
            transHistoryEntityRepository.delete(transHistory);
            return new DataResponse(HttpStatus.OK.value(), "success", transHistory);
        } else {
            return new DataResponse(HttpStatus.NOT_FOUND.value(), "failed", null);
        }
    }
}
