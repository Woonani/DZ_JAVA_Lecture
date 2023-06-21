package com.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/*
 DB에 테이블 (게시판 자료실)
 create table photo (
 	name
 	age
 	image >> db테이블은 업로드한 파일 이름 (예 1.jpg  2.jpg)만 가짐 >> 실제 파일은 회사마다의 파일 서버에 저장
 	기타 : 
 )
 
 실제 파일은 I/O 작업을 서버의 특정 폴더에 >> AWS >> s3 서버 > 파일서버
 ((성현이네 조 발표때 이미지 경로를 url로 잡아서 한것처럼!!))
 
 클라이언트 전송 서버 > public String form (Photo photo) 
 (이름, 나이, 파일)
 
 
 */

public class Photo {
	private String name;
	private int age;
	private String image;
	
	// 스프링은 파일을 담을 수 있는 객체를 제공
	// POINT
	private CommonsMultipartFile file; // 업로드한 파일을 담아요

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public CommonsMultipartFile getFile() {
		return file;
	}

	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Photo [name=" + name + ", age=" + age + ", image=" + image + ", file=" + file + "]";
	}
	
	
	
}
