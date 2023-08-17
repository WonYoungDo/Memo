package com.tawny.memo.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tawny.memo.post.service.PostService;

@RestController
@RequestMapping("/post")
public class PostRestController {
	
	@Autowired
	private PostService postService;
	
	
	// 메모 입력란에 입력한 정보를 저장하는 기능
	@PostMapping("/create")
	public Map<String, String> create(
			@RequestParam("title") String title
			, @RequestParam("contents") String contents
			
			// required가 true면 파일을 필수로 첨부해야 한다.
			, @RequestParam(value="file", required=false) MultipartFile file
			, HttpSession Session) {

		// 로그인된 사용자의 user id
		int userId = (Integer)Session.getAttribute("userId");
		
		int count = postService.addPost(userId, title, contents, file);
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	
	// 수정 기능
	@PutMapping("/update")
	public Map<String, String> updateMemo(
			@RequestParam("postId") int postId
			, @RequestParam("title") String title
			, @RequestParam("contents") String contents) {
		int count = postService.updatePost(postId, title, contents);
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	
	// 삭제 기능
	@DeleteMapping("/delete")
	public Map<String, String> deleteMemo(@RequestParam("postId") int postId, HttpSession session) {
		
		// service에서 userId를 전달 받는다
		int userId = (Integer)session.getAttribute("userId");
		
		// 로그인한 사용자의 userId와 해당 글의 userId가 일치하는 경우에만 삭제
		int count = postService.deletePost(postId, userId);
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
		
	}
}
