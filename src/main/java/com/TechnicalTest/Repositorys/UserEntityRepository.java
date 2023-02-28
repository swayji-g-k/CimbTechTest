package com.TechnicalTest.Repositorys;

import com.TechnicalTest.Models.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface UserEntityRepository extends CrudRepository<UserEntity, BigInteger> {

    List<UserEntity> findAll();
    UserEntity findTopByUsername(String username);
}