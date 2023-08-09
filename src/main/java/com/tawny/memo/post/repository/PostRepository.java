package com.tawny.memo.post.repository;

import org.springframework.stereotype.Repository;

@Repository
public class PostRepository {
	
	public int create(
			@@Param("userId") int userId
			, @Param("title") String title
			, @Param("contents") String contens
			, @Param(""));
	
}
