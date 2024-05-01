package com.example.repo.bridge.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table
public class PostUser {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "userId")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "postId")
    private Post post;

}
