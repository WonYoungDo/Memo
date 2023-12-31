package com.tawny.memo.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
		
		User user = userService.addUser(loginId, password, name, email);
		
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
			, @RequestParam("password") String password) {
		
		User user = userService.getUser(loginId, password);
		
		Map<String, String> resultMap = new HashMap<>();
		if(user != null) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
}
