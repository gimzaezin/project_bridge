package com.example.repo.bridge.request;

import com.example.repo.bridge.domain.GenderCode;
import com.example.repo.bridge.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Generated;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
@Generated
public class RegisterUserRequest {
    private String name;
    private String loginId;
    private String password;
    private String email;
    private GenderCode genderCode;
    private LocalDate birth;
    private String nickname;

}
