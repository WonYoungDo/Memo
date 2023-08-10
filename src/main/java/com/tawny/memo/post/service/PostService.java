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
	
	
	
	public List<Post> getPostList(int userId) {
		return postRepository.selectPostList(userId);
	}
	
	
}
