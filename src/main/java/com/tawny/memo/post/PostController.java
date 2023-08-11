package com.tawny.memo.post;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		// 다운캐스팅으로 오브젝트 클래스를 인트로 바꿔준다.
		int userId =(Integer)session.getAttribute("userId");
		
		List<Post> postList = postService.getPostList(userId);
		model.addAttribute("postList", postList);
		
		return "post/list";
	}
	
	// 메모 입력 화면
	@GetMapping("/create-view")
	public String create() {
		return "post/create";
	}
	
	// 메모 세부사항 보기 화면
	@GetMapping("/detail-view")
	public String detail(@RequestParam("id") int id, Model model) {
		
		Post post = postService.getPost(id);
		
		model.addAttribute("post", post);
		
		return "post/detail";
	}
	
}
