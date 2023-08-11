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
	
	// 사용자가 작성한 메모 내용을 모두 가져오기 
	// (로그인한 사용자 아이디를 얻어서 일치하는 사용자만 메모를 볼 수 있게 한다.)
	public List<Post> selectPostList(@Param("userId") int userId);
	
	// id 기반으로 값을 조회해서 가져오면 무조건 엔티티클래스로 리턴하는 게 좋다.
	// (id값이 일치하는 한 행의 정보만 가져온다.)
	public Post selectPost(@Param("id") int id);

}
