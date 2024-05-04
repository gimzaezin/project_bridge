package com.example.repo.bridge.controller;

import com.example.repo.bridge.domain.User;
import com.example.repo.bridge.request.LoginRequest;
import com.example.repo.bridge.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Member;
@Slf4j
@RequiredArgsConstructor
@Controller
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest loginrequest,
                        BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "/login";
        }

        User loginUser = loginService.login(loginrequest);

        log.info("loginUser: {}", loginUser);

        if (loginUser == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "/login";
        }
        return "redirect:/";
    }
}
