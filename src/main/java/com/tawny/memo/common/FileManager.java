package com.tawny.memo.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManager {
	
	// final 고정된 값의 변수는 대문자로 구성 // 저장할 파일 위치 지정
	public static final String FILE_UPLOAD_PATH = "D:\\원영도\\SpringProject\\upload\\memo";
	
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
		//localhost:8090/images/10_23234234/test.png
		
		return "/images" + directoryName + file.getOriginalFilename();
	}
	
	public static boolean removeFile(String filePath) { //localhost:8090/image/10_23234234/test.png
		
		// 파일 정보가 없는 경우
		if(filePath == null) {
			return false;
		}
		
		// 실제 파일이 저장된 파일 경로 만들기
		// //localhost:8090/image/10_23234234/test.png
		// D:\\원영도\\SpringProject\\upload\\memo/10_23234234/test.png
		// /images를 제거하고, 전체 경로에 이어 붙인다.
		String fullFilePath = FILE_UPLOAD_PATH + filePath.replace("/images", "");
		
		// 경로를 관리하기 위한 객체 
		Path path = Paths.get(fullFilePath);
		
		// 파일이 존재하는지 확인하는 조건문 필요
		if(Files.exists(path)) {
			
			// 예외 처리가 필요
			try { 
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		Path dirPath = path.getParent();
		if(Files.exists(dirPath)) {
			
			try {
				Files.delete(dirPath);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
}
