package com.example.repo.bridge.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table
@NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String loginId;

    private String password;

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
}
