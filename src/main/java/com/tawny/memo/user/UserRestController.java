package com.tawny.memo.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tawny.memo.user.domain.User;
import com.tawny.memo.user.service.UserService;

@RequestMapping("/user")
@RestController // @ResponseBody + @Controller
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	
	// 회원가입 기능
	@PostMapping("/join")
	public Map<String, String> join(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, @RequestParam("email") String email
			, @RequestParam("name") String name) {
		
		User user = userService.addUser(loginId, password, name, email, name);
		
		Map<String, String>	resultMap = new HashMap<>();
		if(user != null) {
			// 성공
			resultMap.put("result", "success");
		} else {
			// 싫패
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	
	// 로그인 기능
	@PostMapping("/login")
	public Map<String, String> login(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, HttpServletRequest request) { // request 추가
		
		User user = userService.getUser(loginId, password);
		
		Map<String, String> resultMap = new HashMap<>();
		if(user != null) {
			resultMap.put("result", "success");
			
			// 세션에 로그인 된 상태를 저장
			// 세션 객체 
			HttpSession session = request.getSession();
			
			// 세션에 로그인 된 사용자의 정보를 저장
			// 세션에 userId라는 키로 값이 저장되어 있으면 로그인 된 상태
			session.setAttribute("userId", user.getId()); // userId라는 키로 user에 id를 가져온다 
			session.setAttribute("userName", user.getName());
			
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	
	// 중복확인 기능
	@GetMapping("/duplicate-id")
	public Map<String, Boolean> isDuplication(@RequestParam("loginId") String loginId) {
		
		boolean isDuplicate = userService.isDuplicateId(loginId);
	
		Map<String, Boolean> resultMap = new HashMap<>();
		
		if(isDuplicate) {
			resultMap.put("isDuplicate", true);
		} else {
			resultMap.put("isDuplicate", false);
		}
		return resultMap;
	}
	
}
