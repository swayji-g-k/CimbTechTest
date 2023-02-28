package com.TechnicalTest.Services.Implementations;

import com.TechnicalTest.Models.UserEntity;
import com.TechnicalTest.Repositorys.UserEntityRepository;
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
    UserEntityRepository userEntityRepository;

    public DataResponse getListUsers() {
        List<UserEntity> usersList = userEntityRepository.findAll();
        return new DataResponse(HttpStatus.OK.value(), "success", usersList);
    }

    public DataResponse getUser(Integer userId) {
        BigInteger id = BigInteger.valueOf(userId);
        Optional<UserEntity> currentUser = userEntityRepository.findById(id);
        if (currentUser.isPresent()) {
            UserEntity user = currentUser.get();
            return new DataResponse(HttpStatus.OK.value(), "success", user);
        } else {
            return new DataResponse(HttpStatus.NOT_FOUND.value(), "failed", null);
        }
    }

    @Transactional
    public DataResponse createUser(UserRequests createUserRequests) {
        UserEntity newUser = new UserEntity();
        UserEntity checkUsername = userEntityRepository.findTopByUsername(createUserRequests.getUsername());
        if (checkUsername == null) {
            newUser.setUsername(createUserRequests.getUsername());
            String password = new BCryptPasswordEncoder().encode(createUserRequests.getPassword());
            newUser.setPasswordHash(password);
            newUser.setAccountNumber(createUserRequests.getAccountNumber());
            newUser = userEntityRepository.save(newUser);
            return new DataResponse(HttpStatus.OK.value(), "success", newUser);
        } else {
            return new DataResponse(HttpStatus.FOUND.value(), "failed", null);
        }
    }

    @Transactional
    public DataResponse UpdateUser(Integer userId, UserRequests updateUserRequests) {
        BigInteger id = BigInteger.valueOf(userId);
        Optional<UserEntity> currentUser = userEntityRepository.findById(id);
        if (currentUser.isPresent()) {
            UserEntity user = currentUser.get();
            user.setUsername(updateUserRequests.getUsername());
            String password = new BCryptPasswordEncoder().encode(updateUserRequests.getPassword());
            user.setPasswordHash(password);
            user.setAccountNumber(updateUserRequests.getAccountNumber());
            user = userEntityRepository.save(user);
            return new DataResponse(HttpStatus.OK.value(), "success", user);
        } else {
            return new DataResponse(HttpStatus.NOT_FOUND.value(), "failed", null);
        }
    }

    @Transactional
    public DataResponse DeleteUser(Integer userId) {
        BigInteger id = BigInteger.valueOf(userId);
        Optional<UserEntity> currentUser = userEntityRepository.findById(id);
        if (currentUser.isPresent()) {
            UserEntity user = currentUser.get();
            userEntityRepository.delete(user);
            return new DataResponse(HttpStatus.OK.value(), "success", user);
        } else {
            return new DataResponse(HttpStatus.NOT_FOUND.value(), "failed", null);
        }
    }
}
