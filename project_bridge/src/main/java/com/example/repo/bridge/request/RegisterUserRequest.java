package com.example.repo.bridge.request;

import com.example.repo.bridge.domain.GenderCode;
import com.example.repo.bridge.domain.User;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private String name;
    @NotNull
    private String loginId;
    @NotNull
    private String password;
    @NotNull
    private String email;
    @NotNull
    private GenderCode genderCode;
    @NotNull
    private LocalDate birth;
    @NotNull
    private String nickname;

}
