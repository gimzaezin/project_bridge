package com.example.repo.bridge.repository.hashtagrepository;

import com.example.repo.bridge.domain.Hashtag;
import com.example.repo.bridge.domain.UserHash;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DataJpaHashtagRepository extends JpaRepository<Hashtag, Long> {
    List<Hashtag> findByHashtagIdIn(List<Long> hashtagIds);
}
