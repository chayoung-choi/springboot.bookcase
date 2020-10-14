package com.cyoung90.bookcase.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cyoung90.bookcase.service.posts.PostService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private final PostService postService;

	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("posts", postService.findAllDesc());
		return "index";
	}

	@GetMapping("/posts/save")
	public String postsSave() {
		return "posts-save";
	}
}