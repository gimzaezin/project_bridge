package com.example.repo.bridge.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Setter
public class ValidateRequest {
    @NotNull
    private List<UserValidate> userValidate;



}
