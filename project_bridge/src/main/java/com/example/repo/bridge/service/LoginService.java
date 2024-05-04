package com.example.repo.bridge.service;

import com.example.repo.bridge.domain.User;
import com.example.repo.bridge.repository.userrepository.DataJpaUserRepository;
import com.example.repo.bridge.request.LoginRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    DataJpaUserRepository dataJpaUserRepository;

    public LoginService(DataJpaUserRepository dataJpaUserRepository) {
        this.dataJpaUserRepository = dataJpaUserRepository;
    }

    public User login(LoginRequest request) {
        User user = dataJpaUserRepository.findByLoginId(request.getLoginId());
        if (user != null && user.getPassword().equals(request.getPassword())) {return user;}
        return null;
    }

}