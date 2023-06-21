package com.controller;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.model.Photo;

@Controller
@RequestMapping("/image/upload.do") 
public class ImageController {
	
	@GetMapping
	public String form() {
		return "image/image";  // 파일 첨부 할 수 있는 view 페이지 제공
	}
	
	@PostMapping
	public String submit(Photo photo, HttpServletRequest request ) {
		
		/*
		 1. Photo DTO 타입으로 데이터 받기
		1.1 자동화 : name 속성값이 Photo 타입클래스의 member field 명과 동일
		2. public String submit(Photo photo) 내부적으로 ...  
		   >> Photo photo = new Photo();
		   >> photo.setName("홍길동");
		   >> photo.setAge(20);
		   >> photo.setImage() >> 자동 주입 안되요 >> 수동으로 >> 가공 CommonsMultipartFile 추출(이름)
		   >> photo.setFile(CommonsMultipartFile file) 파일 자동으로 들어와요
		   
		 */
		
		System.out.println(photo.toString());
		CommonsMultipartFile imagefile = photo.getFile();
		System.out.println("imagefile.getName()" + imagefile.getName());
		System.out.println("imagefile.getContentType()" + imagefile.getContentType());
		System.out.println("imagefile.getOriginalFilename()" + imagefile.getOriginalFilename()); // 왜 필요하냐면 파일 정책 상 : 같은 파일 업로드 시 
		System.out.println("imagefile.getBytes().length" + imagefile.getBytes().length);
		
		// POINT 파일명 추출
		photo.setImage(imagefile.getOriginalFilename());
		
		// upload
		// 자동화 : cos.jar(무료) , 상용 업로드 (텍스트 업로드)
		
		String filename = imagefile.getOriginalFilename();
		String path = request.getServletContext().getRealPath("/upload"); // 배포된 서버의 경로  
		String fpath = path  + "\\" + filename; // c:\\temp\\a.jpg로 저장해야지 의 의미
		System.out.println(fpath);
		
		FileOutputStream fs = null;
		
		try {
			fs = new FileOutputStream(fpath); // 파일 경로에 a.jpg 없으면 생성함 .
			fs.write(imagefile.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		// -------- 여기까지 작업 시 >> 서버의 특정 폴더에 : 파일 생성
		
		// Next DB 작업
		// DAO >> 게시판에 insert 작업 했다치고~
		
		return "image/image";
	}

}
