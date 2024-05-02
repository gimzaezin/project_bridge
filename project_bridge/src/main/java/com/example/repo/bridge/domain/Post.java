package com.example.repo.bridge.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table
@NoArgsConstructor
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String title;

    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private StateCode stateCode;

    private  BigInteger viewCount;

    @OneToMany(mappedBy = "post")
    private List<PostHash> postHashes;

    @OneToMany(mappedBy = "post")
    private List<PostUser> postUsers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
    @OneToMany(mappedBy = "post")
    private List<Image> images;

    @OneToMany(mappedBy = "post")
    private List<Validate> validates;

}
