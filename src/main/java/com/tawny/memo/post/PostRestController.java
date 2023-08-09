package com.tawny.memo.post;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tawny.memo.post.service.PostService;

@RestController
public class PostRestController {
	
	@Autowired
	private PostService postService;
	
	public Map<String, String> create(
			@RequestParam("title") String title
			, @RequestParam("contents") String contents) {
		
	}
}
