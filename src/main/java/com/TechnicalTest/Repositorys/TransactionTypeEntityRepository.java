package com.TechnicalTest.Repositorys;

import com.TechnicalTest.Models.TransactionTypeEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface TransactionTypeEntityRepository extends CrudRepository<TransactionTypeEntity, BigInteger> {

    List<TransactionTypeEntity> findAll();
    TransactionTypeEntity findTopByTransactionCode(String transTypeCode);
}