package com.tawny.memo.common;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class FileManager {
	
//	// final 고정된 값의 변수는 대문자로 구성 
//	private static final String FILE_UPLOAD_PATH = null;
//	
//	// 파일 저장 -> 경로 리턴 // static을 사용해서 객체 생성 없이 사용 가능하도록 
//	public static String saveFile(int userId, MultipartFile file) {
//		
//		// 같은 이름의 파일이 구분되어 저장되도록 구성
//		// 폴더를 만들어서 파일을 저장
//		// user id값을 폴더 이름에 포함
//		// 시간 정보를 폴더 이름에 포함
//		// UNIX TIME : 1970년 1월 1일 부터 흐른 시간을 milli second로 표현한 방식
//		// 폴더이름 예시 : /10_23234234/
//		
//		// 폴더 이름을 먼저 문자열로 만들기 parameter에 userId 전달 받기
//		String directoryName = "/" + userId + "-" + System.currentTimeMillis() + "/";
//		
//		// 폴더 생성 (새 폴더 만든기를 코드로 구현)
//		String directoryPath = FILE_UPLOAD_PATH + directoryName;
//		
//		File direcctory = new File(directoryPath); // -사용법
//		
//		if(!directory.mkdir()) { // 디렉토리가 생성되지 않았을 떄
//			return null;
//		}
//		
//		// 파일에 저장 - 사용법
//		byte[] byytes = file.getBytes();
//		
//	}
}
