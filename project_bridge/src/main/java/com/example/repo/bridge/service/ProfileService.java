package com.example.repo.bridge.service;

import com.example.repo.bridge.domain.Hashtag;
import com.example.repo.bridge.domain.User;
import com.example.repo.bridge.domain.UserHash;
import com.example.repo.bridge.repository.hashtagrepository.DataJpaHashtagRepository;
import com.example.repo.bridge.repository.hashtagrepository.DataJpaUserHashRepository;
import com.example.repo.bridge.repository.userrepository.DataJpaUserRepository;
import com.example.repo.bridge.request.ProfileRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final DataJpaUserRepository userRepository;
    private final DataJpaHashtagRepository hashtagRepository;
    private final DataJpaUserHashRepository userHashRepository;

    public ProfileRequest getProfile(String nickname) {

        User profileUser = userRepository.findByNickname(nickname);
        Long userId = profileUser.getUserId();
        List<UserHash> userHashes = userHashRepository.findHashtagsByUser_UserId(userId);
        List<Long> hashtagIds = userHashes.stream().map(UserHash::getHashtag)
                                            .map(Hashtag::getHashtagId).collect(Collectors.toList());
        List<Hashtag> hashtags = hashtagRepository.findByHashtagIdIn(hashtagIds);
        List<String> hashtagNames = hashtags.stream().map(Hashtag::getHashtagName).toList();

//닉네임으로 유저아이디 찾고 유저아이디 저장
        return ProfileRequest.builder()
                .nickname(nickname)
                .introduction(profileUser.getIntroduction())
                .email(profileUser.getEmail())
                .score(profileUser.getScore())
                .hashNames(hashtagNames)
                .build();
    }
}