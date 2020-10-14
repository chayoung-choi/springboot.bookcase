package com.cyoung90.bookcase.service.posts;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyoung90.bookcase.domain.posts.Posts;
import com.cyoung90.bookcase.domain.posts.PostsRepository;
import com.cyoung90.bookcase.web.posts.dto.PostsListResponseDto;
import com.cyoung90.bookcase.web.posts.dto.PostsResponseDto;
import com.cyoung90.bookcase.web.posts.dto.PostsSaveRequestDto;
import com.cyoung90.bookcase.web.posts.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {
	private final PostsRepository postsRepository;

	@Transactional
	public Long save(PostsSaveRequestDto requestDto) {
		return postsRepository.save(requestDto.toEntity()).getId();
	}

	@Transactional
	public Long update(Long id, PostsUpdateRequestDto requestDto) {
		Posts posts = postsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

		posts.update(requestDto.getTitle(), requestDto.getContent());
		return id;
	}

	public PostsResponseDto findById(Long id) {
		Posts entity = postsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

		return new PostsResponseDto(entity);
	}

	@Transactional(readOnly = true) // 조회 기능일 때 조회속도 개선
	public List<PostsListResponseDto> findAllDesc() {
		return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
	}

	@Transactional
	public void delete(Long id) {
		Posts posts = postsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 id=" + id));

		postsRepository.delete(posts);
	}
}