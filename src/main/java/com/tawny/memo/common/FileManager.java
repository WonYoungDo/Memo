package com.tawny.memo.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManager {
	
	// final 고정된 값의 변수는 대문자로 구성 
	public static final String FILE_UPLOAD_PATH = "C:\\Users\\tawny\\Desktop\\JAVA-HELLOWORLD\\SpringProject\\upload\\memo";
	
	// 파일 저장 -> 경로 리턴 // static을 사용해서 객체 생성 없이 사용 가능하도록 
	public static String saveFile(int userId, MultipartFile file) {
		
		
		if(file == null) {
			return null;
		}
		

		// 같은 이름의 파일이 구분되어 저장되도록 구성
		// 폴더를 만들어서 파일을 저장
		// user id값을 폴더 이름에 포함
		// 시간 정보를 폴더 이름에 포함
		// UNIX TIME : 1970년 1월 1일 부터 흐른 시간을 milli second로 표현한 방식
		// 폴더이름 예시 : /10_23234234/
		
		// 폴더 이름을 먼저 문자열로 만들기 parameter에 userId 전달 받기
		String directoryName = "/" + userId + "-" + System.currentTimeMillis() + "/";
		
		// 폴더 생성(디렉토리 생성) (새 폴더 만든기를 코드로 구현)
		String directoryPath = FILE_UPLOAD_PATH + directoryName;
		
		File directory = new File(directoryPath); // -사용법
		
		if(!directory.mkdir()) { // 디렉토리가 생성되지 않았을 떄
			return null;
		}
		
		// 파일에 저장 - 사용법
		try {
			byte[] byytes = file.getBytes();
			
			String filePath = directoryPath + file.getOriginalFilename();
			
			Path path = Paths.get(filePath);
			
			Files.write(path, byytes);
			
		} catch (IOException e) {
			e.printStackTrace();
			
			// 파일 저장 실패
			return null;
		}
		
		// 클라이언트에서 접근하는 경로 문자열
		// 경로 규칙 : /image/10_23234234/test.png
		//localhost:8090/image/10_23234234/test.png
		
		return "/images" + directoryName + file.getOriginalFilename();
		
		
	}
}
