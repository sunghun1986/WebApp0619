package com.study.commons.file;

public class FileManager {

	// 파일명 오늘 날짜로 변경하기!
	public static String getFileRename(String ori) {				
		long time = System.currentTimeMillis();		
		String rename = time + "." + getExt(ori);//파일명 제작!
		return rename;
	}

	// 파일 경로중 확장자만 추출하는 메서드!!
	public static String getExt(String filename) {
		// 가장 마지막 점을 구한다!! 왜? 확장자만 뽑아내기 위함~!
		int index = filename.lastIndexOf(".");
		String ext = filename.substring(index + 1, filename.length());
		return ext;
	}
	
//	public static void main(String[] args) {
//		System.out.println(getFileRename("agsdfg.jpg"));
//	}

}
