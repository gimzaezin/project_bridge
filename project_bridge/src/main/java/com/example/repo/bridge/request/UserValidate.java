package com.example.repo.bridge.request;

import lombok.*;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Setter
public class UserValidate {
    private Long userId;

    private String templateName;
}
