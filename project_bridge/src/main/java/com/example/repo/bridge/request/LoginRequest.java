package com.example.repo.bridge.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class LoginRequest {
    @NotEmpty
    private String loginId;

    @NotEmpty
    private String password;
}
