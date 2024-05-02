package com.example.repo.bridge.repository.userrepository;

import com.example.repo.bridge.domain.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
public interface DataJpaUserRepository extends JpaRepository<User,Long> {
    User findByLoginIdAndPassword(String loginId, String password);
}
