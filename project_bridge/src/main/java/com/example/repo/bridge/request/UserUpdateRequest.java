package com.example.repo.bridge.request;

import com.example.repo.bridge.domain.GenderCode;
import lombok.*;
import org.springframework.stereotype.Repository;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Generated
@Repository
@ToString
public class UserUpdateRequest {
    private String password;
    private String email;
    private GenderCode genderCode;
    private String nickname;
    private String introduction;

    @Builder
    public UserUpdateRequest(String password, String email, String nickname, String introduction, GenderCode genderCode) {
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.introduction = introduction;
        this.genderCode = genderCode;
    }
}
