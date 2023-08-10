package com.tawny.memo.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
}
