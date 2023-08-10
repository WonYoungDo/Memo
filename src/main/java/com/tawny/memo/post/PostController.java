package com.tawny.memo.post;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tawny.memo.post.domain.Post;
import com.tawny.memo.post.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
	// 메모 리스트 화면
	@GetMapping("/list-view")
	public String list(Model model, HttpSession session) {
		
		int userId =(Integer)session.getAttribute("userId");
		
		List<Post> postList = postService.getPostList(userId);
		
		
		return "post/list";
	}
	
	// 메모 입력 화면
	@GetMapping("/create-view")
	public String create() {
		return "post/create";
	}
	
}
