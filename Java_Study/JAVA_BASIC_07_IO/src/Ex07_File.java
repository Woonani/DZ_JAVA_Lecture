//import java.io.File;
import java.io.*;

/*
 파일, 폴더를 다루는 클래스 학습
 C# : 파일(File), 폴더(Directory)
 
 JAVA : File (파일생성, 삭제..... 폴더생성, 삭제) 하나의 클래스로
 >> a.txt 생성, 수정, 삭제, 정보 read
 >> Temp 생성, 수정, 삭제, 정보 read
 
 경로
 절대경로 : C:\\ , D:\\ >> D:\\Temp\\a.txt 
 상대경로 : 현재 파일을 중심으로 >> ../ >> /
 
 */
public class Ex07_File {

	public static void main(String[] args) {
		String path = "D:\\Temp\\file.txt";
		
		File f = new File(path); // File객체에 경로를 param으로 넣어 생성
		// File 클래스는 파일과 폴더 다 다루는 객체이다!
		
		// File 클래스는 다양한 정보 취득
		System.out.println("파일 존재 여부 (파일, 폴더) : " + f.exists()); // 파일 존재 여부 (파일, 폴더) : true //  false >> 생성후 true
		System.out.println("너 폴더니 : " + f.isDirectory()); // 너 폴더니 : false
		System.out.println("너 파일이니 : " + f.isFile()); // 너 파일이니 : true

		System.out.println("파일명 : " + f.getName()); // 파일명 : file.txt
		
		System.out.println("절대경로 : " + f.getAbsolutePath()); // 절대경로 : D:\Temp\file.txt
		
		System.out.println("파일크기 : " + f.length() + "byte"); // 파일크기 : 0byte
		System.out.println("부모경로 : " + f.getParent() ); // 부모경로 : D:\Temp
		
		
		
		
	}

}
