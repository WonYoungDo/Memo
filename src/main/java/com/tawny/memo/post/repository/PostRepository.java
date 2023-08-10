package com.tawny.memo.post.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository {
	
	// 메모 입력에서 사용자가 작성한 내용 추가
	public int insertPost(
			@Param("userId") int userId
			, @Param("title") String title
			, @Param("contents") String contens
			, @Param("imagePath") String imagePath);




}
