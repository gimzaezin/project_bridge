package com.example.repo.bridge.service;


import com.example.repo.bridge.domain.GenderCode;
import com.example.repo.bridge.domain.User;
import com.example.repo.bridge.repository.userrepository.DataJpaUserRepository;
import com.example.repo.bridge.request.LoginRequest;
import com.example.repo.bridge.request.RegisterUserRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class LoginServiceTest {
    @Autowired
    private DataJpaUserRepository userRepository;

    @Autowired
    private LoginService loginService;

    @Test
    public void loginTest() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLoginId("kimjaejin");
        loginRequest.setPassword("1234");

        User loginuser= loginService.login(loginRequest);

        assertNotNull(loginuser);
    }
}

//INSERT INTO user_table (user_id, login_id, password, name, email, birth, introduction, nickname, state, gender_code)
//    VALUES
//    (1, 'kimjaejin', '1234', '김재진', 'kimjaejin@example.com', '2000-01-01', 'Hello, I am John Doe.', 'kim', 1, 'MALE');