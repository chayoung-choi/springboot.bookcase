package com.cyoung90.bookcase.web.posts;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cyoung90.bookcase.service.posts.PostService;
import com.cyoung90.bookcase.web.posts.dto.PostsResponseDto;
import com.cyoung90.bookcase.web.posts.dto.PostsSaveRequestDto;
import com.cyoung90.bookcase.web.posts.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

	private final PostService postService;

	@PostMapping("/api/v1/posts")
	public Long save(@RequestBody PostsSaveRequestDto requestDto) {

		return postService.save(requestDto);
	}

	@PutMapping("/api/v1/posts/{id}")
	public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {

		return postService.update(id, requestDto);
	}

	@GetMapping("/api/v1/posts/{id}")
	public PostsResponseDto findById(@PathVariable Long id) {

		return postService.findById(id);
	}
}