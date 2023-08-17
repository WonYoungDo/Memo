package com.tawny.memo.post.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tawny.memo.common.FileManager;
import com.tawny.memo.post.domain.Post;
import com.tawny.memo.post.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	// 메모 입력 기능
	public int addPost(
			int userId
			, String title
			, String contents
			, MultipartFile file) {
		
		// 파일을 특정 경로에 저장
		// 저장된 파일을 클라이언트에서 접근할 수 있는 경로를 얻어낸다.
		String imagePath = FileManager.saveFile(userId, file);
		
		// 접근 경로를 table에 저장
		return postRepository.insertPost(userId, title, contents, imagePath);
	}
	
	
	// 메모 리스트 (저장된 메모를 모두 가져오는 기능)
	public List<Post> getPostList(int userId) {
		return postRepository.selectPostList(userId);
	}
	
	// 메보 보기 (아이디 값이 일치하는 특정 한 행의 정보를 가져온다.)
	public Post getPost(int id) { // 아이디 기반으로 조회는 한 행을 리턴한다.
		return postRepository.selectPost(id);
	}
	
	// 사용자가 내용을 수정하는 기능
	public int updatePost(int postId, String title, String contents) {
		return postRepository.updatePost(postId, title, contents);
	}
	
	// 게시물 id를 기반으로 삭제하는 기능 
	public int deletePost(int postId, int userId) {
		
		// 테이블에서 정보를 삭제해도 사진은 폴더에 저장되어 있으므로 추가적으로 처리해줘야 한다.
		// 삭제 대상의 imagePath 경로를 얻어 온다
		// 저장되어 있는 파일까지 같이 삭제
		Post post = postRepository.selectPost(postId);
		
		// 게시물을 작성한 사용자와 로그인된 사용자의 아이디가 같을 때만 삭제
		if(userId == post.getUserId()) { 
			FileManager.removeFile(post.getImagePath());
			return postRepository.deletePost(postId);			
		} else { 
			return 0;
			
		}
	}
	
	
}
