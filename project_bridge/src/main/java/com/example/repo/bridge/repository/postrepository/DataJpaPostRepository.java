package com.example.repo.bridge.repository.postrepository;

import com.example.repo.bridge.domain.Post;
import com.example.repo.bridge.domain.StateCode;
import com.example.repo.bridge.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataJpaPostRepository extends JpaRepository<Post, Long> {
}
