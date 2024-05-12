package com.example.repo.bridge.repository.hashtagrepository;

import com.example.repo.bridge.domain.Hashtag;
import com.example.repo.bridge.domain.UserHash;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
public interface DataJpaUserHashRepository extends JpaRepository<UserHash, Long> {
    List<UserHash> findHashtagsByUser_UserId(Long userId);
}