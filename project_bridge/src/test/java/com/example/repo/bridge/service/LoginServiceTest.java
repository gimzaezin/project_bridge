package com.example.repo.bridge.service;


import com.example.repo.bridge.domain.User;
import com.example.repo.bridge.repository.userrepository.DataJpaUserRepository;
import com.example.repo.bridge.request.LoginRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class LoginServiceTest {
    private static final Logger log = LoggerFactory.getLogger(LoginServiceTest.class);
    @Autowired
    private DataJpaUserRepository userRepository;

    @Autowired
    private LoginService loginService;

    @Test
    public void loginTest() {   //db에 있는 아이디 비밀번호로 정상로그인
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLoginId("kimjaejin");
        loginRequest.setPassword("1234");

        User loginuser = loginService.login(loginRequest);
        log.info(String.valueOf(loginuser.getUserId()));
        log.info(loginuser.getLoginId());
        log.info(loginuser.getPassword());
        log.info(loginuser.getNickname());
        assertNotNull(loginuser);
    }

    @Test
    public void incorrectIdTest() { //아이디 틀렸을때 테스트
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLoginId("incorrectID");
        loginRequest.setPassword("1234");
        User loginuser = loginService.login(loginRequest);
        assertNull(loginuser);
    }

    @Test
    public void incorrectPasswordTest() {   //비밀번호 틀렸을때 테스트
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLoginId("kimjaejin");
        loginRequest.setPassword("incorrectPassword");
        User loginuser = loginService.login(loginRequest);
        assertNull(loginuser);
    }

    @Test
    public void incorrectIdPasswordTest() {   //아이디 비밀번호 둘다 틀렸을때 테스트
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLoginId("incorrectID");
        loginRequest.setPassword("incorrectPassword");
        User loginuser = loginService.login(loginRequest);
        assertNull(loginuser);
    }
}
//INSERT INTO user_table (user_id, login_id, password, name, email, birth, introduction, nickname, state, gender_code)
//    VALUES
//    (1, 'kimjaejin', '1234', '김재진', 'kimjaejin@example.com', '2000-01-01', 'Hello, I am John Doe.', 'kim', 1, 100, 'MALE');