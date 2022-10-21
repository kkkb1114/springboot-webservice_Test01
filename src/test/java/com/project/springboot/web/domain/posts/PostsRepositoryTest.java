package com.project.springboot.web.domain.posts;

import com.project.springboot.domain.posts.Posts;
import com.project.springboot.domain.posts.PostsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void postSave_Call(){
        //given
        String title = "테스트 제목";
        String content = "테스트 내용";

        postsRepository.save(Posts.builder()
        .title(title)
        .content(content)
        .author("kikkb1114@naver.com")
        .build()
        );

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        Assertions.assertThat(posts.getTitle()).isEqualTo(title);
        Assertions.assertThat(posts.getContent()).isEqualTo(content);
    }
    /*@Test
    public void BaseTimeEntity_play(){
        //given
        LocalDateTime now = LocalDateTime.of(2022, 10, 21, 15, 44, 0);
        //postsRepository
        //when

        //then
    }*/
}
