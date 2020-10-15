package com.cyoung90.bookcase.domain.posts;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;

	@After
	public void cleanup() {
		postsRepository.deleteAll();
	}

	@Test
	public void 게시글저장_블러오기() {
		// given
		String title = "�׽�Ʈ �Խñ�";
		String content = "�׽�Ʈ ����";

		postsRepository.save(Posts.builder().title(title).content(content).author("b088081@gmail.com").build());

		// when
		List<Posts> postsList = postsRepository.findAll();

		// then
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle()).isEqualTo(title);
		assertThat(posts.getContent()).isEqualTo(content);
	}
}