package com.TechnicalTest.Repositorys;

import com.TechnicalTest.Models.TransactionTypeEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface TransactionTypeEntityRepository extends CrudRepository<TransactionTypeEntity, BigInteger> {
}