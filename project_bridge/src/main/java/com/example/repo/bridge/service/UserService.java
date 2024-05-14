package com.example.repo.bridge.service;

import com.example.repo.bridge.domain.User;
import com.example.repo.bridge.request.RegisterUserRequest;
import com.example.repo.bridge.repository.userrepository.DataJpaUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final DataJpaUserRepository dataJpaUserRepository;

    public User save(RegisterUserRequest registerUserRequest) {
        User user = new User(registerUserRequest);
        return dataJpaUserRepository.save(user);

    }
}
