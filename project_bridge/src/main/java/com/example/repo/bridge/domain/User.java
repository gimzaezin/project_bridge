package com.example.repo.bridge.domain;

import com.example.repo.bridge.request.RegisterUserRequest;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table
@Generated
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String loginId;

    private String password;

    private String name;

    private String email;

    private LocalDate birth;

    private String introduction;

    private String nickname;

    private int state;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "GENDER_ID")
//    private Gender genderName;
//
//    @OneToMany(mappedBy = "User")
//    private List<Post> posts = new ArrayList<>();
//
    @OneToMany(mappedBy = "user")
    private List<PostUser> postUsers;

    @OneToMany(mappedBy = "user")
    private List<UserHash> userHashes;
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @OneToMany(mappedBy = "fromUser")
    private List<Validate> fromValidates;
    @OneToMany(mappedBy = "toUser")
    private List<Validate> toValidates;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @Enumerated(EnumType.STRING)
    private GenderCode genderCode;
//
//    public User() {}
    public User(RegisterUserRequest register){
        this.loginId = register.getLoginId();
        this.password = register.getPassword();
        this.email = register.getEmail();
        this.birth =  register.getBirth();
        this.nickname = register.getNickname();
        this.name = register.getName();
        this.genderCode = register.getGenderCode();
    }
}
