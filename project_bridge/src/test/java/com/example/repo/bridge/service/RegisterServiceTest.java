package com.example.repo.bridge.service;

import com.example.repo.bridge.domain.GenderCode;
import com.example.repo.bridge.domain.User;
import com.example.repo.bridge.repository.userrepository.DataJpaUserRepository;
import com.example.repo.bridge.request.RegisterUserRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
@Slf4j
@SpringBootTest
class RegisterServiceTest {

    private final RegisterService registerService;
    private final DataJpaUserRepository d;

    LocalDate localDate = LocalDate.now().minusDays(1);

    @Autowired
    RegisterServiceTest(RegisterService registerService, DataJpaUserRepository d) {
        this.registerService = registerService;
        this.d = d;
    }



    @Test
    public void signUp(){

        RegisterUserRequest rr = new RegisterUserRequest("김정민","wjda1ls","1234567","wjdals@gmail.com",
                GenderCode.MALE, localDate, "jungmin");

        User save = registerService.signUp(rr);
        log.info(save.toString());
    }

    @Test
    public void signUpOverName(){

        RegisterUserRequest request = new RegisterUserRequest("재진재진재진재진재진재진재진재진재진재진재진재진재진재재진재재진재진재진재진재재진재진재진재진재진재"
                ,"kimjaejin","1234","wjdals@gmail.com",
                GenderCode.MALE, localDate,"aqaqaq");
        //User user = registerService.signUp(request);
        assertThrows(ConstraintViolationException.class, () -> {
            registerService.signUp(request);
        });
        log.info("이름 초과");
    }

    @Test
    public void signUpOverLoginId(){

        RegisterUserRequest request = new RegisterUserRequest("김재진"
                ,"kimjaejinkimjaejinkimjaejinkimjaejinkimjaejinkimjaejinkimjaejinkimjaejin","12341234"
                ,"wjdals",
                GenderCode.MALE, localDate,"aqaqaq");
        //User user = registerService.signUp(request);
        assertThrows(ConstraintViolationException.class, () -> {
            registerService.signUp(request);
        });
        log.info("로그인 아이디가 길다");
    }

    @Test
    public void signUpOverPassword(){

        RegisterUserRequest request = new RegisterUserRequest("김재진"
                ,"kimjaejin","12341234123412341234123412341234123412341234123412341234123412341234"
                ,"wjdals@gmail.com",
                GenderCode.MALE, localDate,"aqaqaq");
        //User user = registerService.signUp(request);
        assertThrows(ConstraintViolationException.class, () -> {
            registerService.signUp(request);
        });
        log.info("비밀번호 초과");
    }

    @Test
    public void signUpOverNickname(){

        RegisterUserRequest request = new RegisterUserRequest("김재진"
                ,"kimjaejin","12341234"
                ,"wjdals",
                GenderCode.MALE, localDate,"aqaqaqaqaqaqaqaqaqaqaqaqaqaqaqaqaqaqaqaqaqaqaqaqaqaqaqaqaqaqaqaqaqaqaqaq");
        //User user = registerService.signUp(request);
        assertThrows(ConstraintViolationException.class, () -> {
            registerService.signUp(request);
        });
        log.info("닉네임이길다");
    }


    @Test
    public void signUpNotEmail(){

        RegisterUserRequest request = new RegisterUserRequest("김재진"
                ,"kimjaejinkimjaejinkimjaejinkimjaejinkimjaejinkimjaejinkimjaejinkimjaejin","12341234"
                ,"wjdals",
                GenderCode.MALE, localDate,"aqaqaq");
        //User user = registerService.signUp(request);
        assertThrows(ConstraintViolationException.class, () -> {
            registerService.signUp(request);
        });
        log.info("email 형식이 아님");
    }

    @Test
    public void signUpNow(){

        RegisterUserRequest request = new RegisterUserRequest("김재진"
                ,"kimjaejin","12341234"
                ,"wjdals",
                GenderCode.MALE, LocalDate.now(),"aqaqaq");
        //User user = registerService.signUp(request);
        assertThrows(ConstraintViolationException.class, () -> {
            registerService.signUp(request);
        });
        log.info("현재보다 과거의 날짜가 필요함");
    }
}