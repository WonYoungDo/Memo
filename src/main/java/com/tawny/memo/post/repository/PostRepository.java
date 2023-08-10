package com.tawny.memo.post.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.tawny.memo.post.domain.Post;

@Repository
public interface PostRepository {
	
	// 메모 입력에서 사용자가 작성한 내용 추가
	public int insertPost(
			@Param("userId") int userId
			, @Param("title") String title
			, @Param("contents") String contens
			, @Param("imagePath") String imagePath);

	public List<Post> selectPostList(@Param("userId") int userId);
					  
	


}
