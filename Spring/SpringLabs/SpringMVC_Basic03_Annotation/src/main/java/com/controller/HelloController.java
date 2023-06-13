package com.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

/*
  기존 방식
  1. 요청하나당 Controller 한개 필요 ...
  2. 게시판 (전제, 조건, 입력, 수정, 삭제 ) >> implements Controller 최소 5개  
  public class HelloController implements Controller { //java를 웹 전용 파일로 ... Spring
		@Override
		public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			return null;
		}
	}
   3. 하나의 클래스가 여러개의 요청 (글쓰기 , 목록보기, 수정하기)을 처리하면 ,..... 요청단위 함수단위로 .....
  	@Controller >> method 단위로 맵핑이 가능합니다. >> 하나의 클래스 안에서 기능 단위의 함수 작성
  	예를 들어 게시판을 만든다면 ...
  	목록보기 : public void list()
  	글쓰기 : public void write()
  	수정하기 :  public void edit()
  	
  	@RestController
 */
@Controller
public class HelloController {
	public HelloController() {
		System.out.println("HelloController 생성자 호출");		
	}
	
	//<a href="hello.do">hello.do 요청하기 </a>
	@RequestMapping("/hello.do")
	public ModelAndView hello() { // ModelAndView 라는 타입의 객체의 주소를 리턴하는 함수를 만듦
		System.out.println("hello.do.method call");
		ModelAndView mav = new ModelAndView();
		mav.addObject("greeting", getGreeting());
		mav.setViewName("Hello"); // /WEB-INF/views/Hello.jsp
		return mav;
	
	}
	private String getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		String data="";
		if(hour >= 6 && hour <= 10) {
			data="학습시간";
		}else if(hour >= 11 && hour <= 13) {
			data="배고픈시간";
		}else if(hour >= 14 && hour <= 18) {
			data="졸려운시간";
		}else {
			data="go home";
		}
		return data;
		
	}
}
