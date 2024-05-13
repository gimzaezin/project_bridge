package com.example.repo.bridge.service;

import com.example.repo.bridge.domain.GenderCode;
import com.example.repo.bridge.domain.User;
import com.example.repo.bridge.repository.userrepository.DataJpaUserRepository;
import com.example.repo.bridge.request.RegisterUserRequest;
import jakarta.transaction.Transactional;
import org.hibernate.internal.build.AllowNonPortable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    private final UserService userService;
    private final DataJpaUserRepository d;


    @Autowired
    UserServiceTest(UserService userService, DataJpaUserRepository d) {
        this.userService = userService;
        this.d = d;
    }



    @Test
    public void signUp(){
        RegisterUserRequest rr = new RegisterUserRequest("정민","wjdals","1234","wjdals@gmail.com",
                GenderCode.MALE, LocalDate.now(),"jungminkiller");

        User save = userService.save(rr);

        User s = d.findByLoginIdAndPassword("wjdals", "1234");

        System.out.println("s.toString() = " + s.toString());
    }
}