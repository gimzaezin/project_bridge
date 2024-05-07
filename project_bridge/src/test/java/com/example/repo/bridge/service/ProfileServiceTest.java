package com.example.repo.bridge.service;

import com.example.repo.bridge.domain.Hashtag;
import com.example.repo.bridge.repository.hashtagrepository.DataJpaHashtagRepository;
import com.example.repo.bridge.repository.hashtagrepository.DataJpaUserHashRepository;
import com.example.repo.bridge.repository.userrepository.DataJpaUserRepository;
import com.example.repo.bridge.request.ProfileRequest;
import jakarta.persistence.Tuple;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.type.descriptor.java.StringJavaType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest
public class ProfileServiceTest {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private DataJpaUserRepository dataJpaUserRepository;
    @Autowired
    private DataJpaHashtagRepository dataJpaHashtagRepository;
    @Autowired
    private DataJpaUserHashRepository dataJpaUserHashRepository;

    @Test
    public void profileTest() {
        ProfileRequest p = profileService.getProfile("kim");
        log.info(p.getNickname());
        log.info(p.getEmail());
        log.info(p.getIntroduction());
        log.info("score={}", String.valueOf(p.getScore()));
        log.info("Hashtag Names:");
        for (String hashtagName : p.getHashNames()) {
            log.info(hashtagName);
        }

        Assertions.assertNotNull(p);
    }

// INSERT INTO hashtag (hashtag_id, hashtag_name) VALUES  (1 ,'#광주광역시')
// INSERT INTO hashtag (hashtag_id, hashtag_name) VALUES  (2 ,'#지원1동')
//INSERT INTO hashtag (hashtag_id, hashtag_name) VALUES  (3 ,'#소태역')
//INSERT INTO user_hash (user_id, hashtag_id) VALUES  (1 , 1);
//INSERT INTO user_hash (user_id, hashtag_id) VALUES  (1 , 2);
//INSERT INTO user_hash (user_id, hashtag_id) VALUES  (1 , 3);

}
