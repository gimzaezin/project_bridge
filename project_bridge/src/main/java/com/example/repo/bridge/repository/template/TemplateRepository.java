package com.example.repo.bridge.repository.template;

import com.example.repo.bridge.domain.Template;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TemplateRepository extends JpaRepository<Template, Long> {
    Optional<Template> findTemplateByContent(String content);
}
