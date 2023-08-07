package com.tawny.memo.user;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	// 회원가입 화면
	@GetMapping("/join-view")
	public String join() {
		return "user/join";
	}
	
	// 로그인 화면
	@GetMapping("/login-view")
	public String login() {
		return "user/login";
	}
	
	// 로그아웃 (리다이렉트)
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		// 세션에 저장한 사용자 정보를 제거한다.
		// userId userName 
		HttpSession session =  request.getSession();
		
		session.removeAttribute("userId");
		session.removeAttribute("userName");
		
		return "redirect:/user/login-view";
	
	}

}
