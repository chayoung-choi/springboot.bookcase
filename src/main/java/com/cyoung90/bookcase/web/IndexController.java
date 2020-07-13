package com.cyoung90.bookcase.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cyoung90.bookcase.config.auth.LoginUser;
import com.cyoung90.bookcase.config.auth.dto.SessionUser;
import com.cyoung90.bookcase.service.posts.PostService;
import com.cyoung90.bookcase.web.dto.PostsResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	private final PostService postService;

	@GetMapping("/")
	public String index(Model model, @LoginUser SessionUser user) {
		model.addAttribute("user", user);
		return "index";
	}
	
	
	@GetMapping("/sample/blog")
	public String blog(Model model) {
		return "sample/blog";
	}

	@GetMapping("/posts/save")
	public String postsSave() {
		return "posts/posts-save";
	}

	@GetMapping("/posts/update/{id}")
	public String postsUpdate(@PathVariable Long id, Model model) {

		PostsResponseDto dto = postService.findById(id);
		model.addAttribute("post", dto);

		return "posts/posts-update";
	}
	
	@GetMapping("/home")
	public String main(Model model) {
		
		return "home";
	}
	

}