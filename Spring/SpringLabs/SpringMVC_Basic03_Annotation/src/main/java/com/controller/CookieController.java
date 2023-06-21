package com.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	
	@RequestMapping("/cookie/make.do")    // WAS에서 생성된  http req 또는 httpRes 객체 얻어와야함.
	public String make(HttpServletResponse response) { // 이HttpServletResponse인터페이스 객체도 자동으로 들어옴 
		
		response.addCookie(new Cookie("auth", "1004")); // servlet과 동일
		
		return "cookie/CookieMake";
	}
	
	//public String view(HttpServletRequest request) { // 이렇게 쓰는 건 전통적인 방법
	@RequestMapping("/cookie/view.do")
	public String view(@CookieValue(value="auth", defaultValue="1007") String auth) { // 스프링에서는 어노테이션을 씀 :어노테이션으로 얻어온 "auth"의 값은 String auth에 저장됨
		System.out.println("클라이언트에서 read한 쿠키 값 : " + auth);
		return "cookie/CookieView";
	}
}
