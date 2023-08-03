package com.tawny.memo.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawny.memo.common.EncryptUtils;
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
		
		// password를 전달 받고 암호화 과정을 거처서 user에 저장
		String ecryptUtils =  EncryptUtils.md5(password);
		
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

	
	// 로그인 
	// 전달 받은 아이디와 비밀번호가 존재하는지 
	public User getUser(String loginId, String password) {
		
		List<User> userList = userRepository.findByLoginIdAndPassword(loginId, password);
		
		
		if(userList.isEmpty()) { // 비워진 경우(조회가 안 될 경우)
			return null;
		} else { // 조회된 경우 
			return userList.get(0);
		}
	}


}
