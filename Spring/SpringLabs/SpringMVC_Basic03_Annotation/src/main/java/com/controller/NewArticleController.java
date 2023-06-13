package com.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
/*
 클라이언트 요청....
 1. 화면 주세요 (글쓰기, 로그인 화면) : write.do
 2. 처리해 주세요 (글쓰기 입력 처리, 로그인 완료 처리) : writeok.do
  
 요청주소가 : write.do 화면
 요청주소가 : writeok.do 처리
 
 spring 
 클라이언트 요청
 요청을 method 단위로 처리
   * 1개의 요청 주소로 화면, 처리 판단 > 근거는> 클라이언트가 보낸 요청의 "전송방식(GET, POST)"으로 
   http:...../article/newArticle.do
   요청방식이 
   GET : 화면을 보여다랄고 인지 > view 제공
   POST : 처리로 인지 : 서비스 처리 하기 > insert, update 작업 후 >> 화면 제공 
    
 */
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {
	// 어노테이션이 5.대가 되면서 개선됨
	//@RequestMapping(method= RequestMethod.GET)
	@GetMapping // 5.x.x
	public String form() { // 화면 주세요
		System.out.println("GET 화면 주세요");
		return null;
	}
	
	//@RequestMapping(method= RequestMethod.POST)
	@PostMapping // 5.x.x
	public String submit() { // 처리
		System.out.println("POST 처리 주세요");
		return null;
	}
}
