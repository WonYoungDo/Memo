package com.tawny.memo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawny.memo.user.domain.User;
import com.tawny.memo.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	
	// 회원 가입
	public User addUser( // 실행될 행의 개수
			String loginId
			, String password
			, String name
			, String email) {
		
		
		User user =  User.builder()
		.loginId(loginId)
		.password(password)
		.name(name)
		.email(email)
		.build();
		
		// builder를 통해서 생성된 객체를 변수로 전달해준다
		user = userRepository.save(user);
		
		return user;
	}



}
