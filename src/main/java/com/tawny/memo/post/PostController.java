package com.tawny.memo.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {
	
	
	// 메모 리스트 화면
	@GetMapping("/list-view")
	public String list() {
		return "post/list";
	}
	
	// 메모 입력 화면
	@GetMapping("/create-view")
	public String create() {
		return "post/create";
	}
	
}
