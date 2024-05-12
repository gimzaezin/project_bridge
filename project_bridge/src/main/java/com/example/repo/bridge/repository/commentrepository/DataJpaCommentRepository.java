package com.example.repo.bridge.repository.commentrepository;

import com.example.repo.bridge.domain.Comment;
import com.example.repo.bridge.domain.Post;
import com.example.repo.bridge.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataJpaCommentRepository extends JpaRepository<Comment, Long> {
    public List<Comment> findByPost(Post post);
    public List<Comment> findByUser(User user);
}
