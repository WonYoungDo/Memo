package com.tawny.memo.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tawny.memo.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	// 로그인 화면에서 아이디와 비밀번호가 일치하는지 확일할 수 있는 메소드를 생성
	public List<User> findByLoginIdAndPassword(String loginId, String password);
}
