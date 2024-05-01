package com.example.repo.bridge.domain;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class UserTest {

    @Autowired
    EntityManager em;


    @Test
    void asd() {
        User user = new User();
        user.setNickname("asd");


        em.persist(user);

        User fU = em.find(User.class, user.getUserId());
//
        Post post = new Post();
        post.setUser(user);

        em.persist(post);

        Post getPost = em.find(Post.class, post.getPostId());

        User FBPIU = getPost.getUser();


        assertThat(user).isEqualTo(FBPIU);
    }
}