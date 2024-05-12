package com.example.repo.bridge.response;

import com.example.repo.bridge.domain.Post;
import com.example.repo.bridge.domain.StateCode;
import com.example.repo.bridge.domain.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
public class PostResponse {
    private Long postId;

    private String title;

    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private StateCode stateCode;

    private BigInteger viewCount;
    private UserDTO userDTO;

    public PostResponse(Post post){
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.createdAt = post.getCreatedAt();
        this.startTime = post.getStartTime();
        this.endTime = post.getEndTime();
        this.stateCode = post.getStateCode();
        this.viewCount = post.getViewCount();
        this.userDTO = new UserDTO(post.getUser());
    }

    @Data
    public static class UserDTO{
        private Long userId;
        private String nickname;

        public UserDTO(User user){
            this.userId = user.getUserId();
            this.nickname = user.getNickname();
        }
    }
}
