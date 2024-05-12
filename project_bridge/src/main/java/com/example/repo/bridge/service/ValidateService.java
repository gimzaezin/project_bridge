package com.example.repo.bridge.service;

import com.example.repo.bridge.domain.Post;
import com.example.repo.bridge.domain.Template;
import com.example.repo.bridge.domain.User;
import com.example.repo.bridge.domain.Validate;
import com.example.repo.bridge.exception.ObjectNotFound;
import com.example.repo.bridge.repository.postrepository.DataJpaPostRepository;
import com.example.repo.bridge.repository.template.TemplateRepository;
import com.example.repo.bridge.repository.userrepository.DataJpaUserRepository;
import com.example.repo.bridge.repository.validaterepository.ValidateRepository;
import com.example.repo.bridge.request.UserValidate;
import com.example.repo.bridge.request.ValidateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ValidateService {
    private final ValidateRepository validateRepository;
    private final DataJpaUserRepository dataJpaUserRepository;
    private final DataJpaPostRepository dataJpaPostRepository;
    private final TemplateRepository templateRepository;

    // 평가하기 했을 때 저장되는 경우
    @Transactional
    public void saveValidate(Long postId, Long fromUserId, ValidateRequest validateRequest) {
        Post post = dataJpaPostRepository.findById(postId).get();
        User fromUser = dataJpaUserRepository.findById(fromUserId).get();

        for (UserValidate userValidate: validateRequest.getUserValidate()) {
            if (fromUserId != userValidate.getUserId()) {
                User toUser = dataJpaUserRepository.findById(userValidate.getUserId()).orElseThrow(() -> new ObjectNotFound("아이디에 해당하는 유저 없음"));
                Template template = templateRepository.findTemplateByContent(userValidate.getTemplateName()).orElseThrow(() -> new ObjectNotFound("아이디에 해당하는 유저 없음"));
                validateRepository.save(Validate.builder()
                        .post(post)
                        .fromUser(fromUser)
                        .toUser(toUser)
                        .template(template)
                        .build());
            }
        }
    }

    // 모임 시작됐을 때 저장되는 경우
    public void saveValidate2(Long postId, Long fromUserId) {
        Post post = dataJpaPostRepository.findById(postId).get();
        User fromUser = dataJpaUserRepository.findById(fromUserId).get();

        validateRepository.save(Validate.builder()
                        .post(post)
                        .fromUser(fromUser)
                        .build());

    }

}
