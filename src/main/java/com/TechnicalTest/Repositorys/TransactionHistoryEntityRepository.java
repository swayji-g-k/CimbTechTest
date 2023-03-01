package com.TechnicalTest.Repositorys;

import com.TechnicalTest.Models.TransactionHistoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface TransactionHistoryEntityRepository extends CrudRepository<TransactionHistoryEntity, BigInteger> {

    List<TransactionHistoryEntity> findAll();
}