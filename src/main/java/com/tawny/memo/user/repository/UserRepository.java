package com.tawny.memo.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tawny.memo.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
}
