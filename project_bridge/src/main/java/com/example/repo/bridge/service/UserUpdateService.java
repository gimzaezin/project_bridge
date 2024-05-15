package com.example.repo.bridge.service;

import com.example.repo.bridge.domain.User;
import com.example.repo.bridge.repository.userrepository.DataJpaUserRepository;
import com.example.repo.bridge.request.UserUpdateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Transactional
public class UserUpdateService {

    private DataJpaUserRepository userRepository;
    @Autowired
    public UserUpdateService(DataJpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void updateUser(User user, UserUpdateRequest updateRequest) {
        user = userRepository.findById(user.getUserId()).orElseThrow(()
                -> new IllegalArgumentException("해당하는 아이디가 없습니다 id : "));

        updateRequest = UserUpdateRequest.builder()
                .password(updateRequest.getPassword() != null ? updateRequest.getPassword() : user.getPassword())
                .email(updateRequest.getEmail() != null ? updateRequest.getEmail() : user.getEmail())
                .genderCode(updateRequest.getGenderCode() != null ? updateRequest.getGenderCode() : user.getGenderCode())
                .nickname(updateRequest.getNickname() != null ? updateRequest.getNickname() : user.getNickname())
                .introduction(updateRequest.getIntroduction() != null ? updateRequest.getIntroduction() : user.getIntroduction())
                .build();
        user.setUpdateRequest(updateRequest);
    }
}



