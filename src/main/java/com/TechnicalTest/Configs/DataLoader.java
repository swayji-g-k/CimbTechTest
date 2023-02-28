package com.TechnicalTest.Configs;

import com.TechnicalTest.Models.UserEntity;
import com.TechnicalTest.Repositorys.UserEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

//@Component
public class DataLoader implements CommandLineRunner {

    private UserEntityRepository userEntityRepository;

    public <userEntityRepository> DataLoader(userEntityRepository userRepository) {
        this.userEntityRepository = (UserEntityRepository) userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        LoadUsers();
    }

    private void LoadUsers() {
        List<UserEntity> userLists = new ArrayList<>();
        UserEntity newUser = new UserEntity();
        newUser.setUsername("user 1");
        newUser.setPasswordHash(new BCryptPasswordEncoder().encode("user 1"));
        newUser.setUsername("1234567890");
        userLists.add(newUser);
        newUser.setUsername("user 2");
        newUser.setPasswordHash(new BCryptPasswordEncoder().encode("user 2"));
        newUser.setUsername("0987654321");
        userLists.add(newUser);
        userEntityRepository.saveAll(userLists);
    }
}
