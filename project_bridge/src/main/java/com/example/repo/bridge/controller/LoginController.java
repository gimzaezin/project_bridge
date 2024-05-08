package com.example.repo.bridge.controller;

import com.example.repo.bridge.domain.User;
import com.example.repo.bridge.request.LoginRequest;
import com.example.repo.bridge.service.LoginService;
import com.example.repo.bridge.web.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Member;
@Slf4j
@RequiredArgsConstructor
@Controller
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public String login(
            @RequestParam (name = "loginId") String loginId,
            @RequestParam (name = "password") String password,
            @ModelAttribute LoginRequest loginrequest,
            BindingResult bindingResult, HttpServletRequest request)
    {
        if (bindingResult.hasErrors()) {
            return "redirect:/login";
        }
        loginrequest.setLoginId(loginId);
        loginrequest.setPassword(password);
        User loginUser = loginService.login(loginrequest);

        if (loginUser == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            log.info("login fail");
        } else {
            log.info("login success! loginUser: {}", loginUser.getLoginId());

            HttpSession session = request.getSession();
            log.info(String.valueOf(session.getCreationTime()));
            session.setAttribute(SessionConst.LOGIN_USER, loginUser);
        }
        return "redirect:/";
    }


    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            log.info(String.valueOf(session.getAttribute(SessionConst.LOGIN_USER)));
            session.invalidate();
            log.info("logout success");
        }
        return "redirect:/";
    }
}
