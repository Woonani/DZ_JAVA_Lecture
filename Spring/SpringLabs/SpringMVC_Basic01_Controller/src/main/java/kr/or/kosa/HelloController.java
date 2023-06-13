package kr.or.kosa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class HelloController implements Controller { //java를 웹 전용 파일로 ... Spring

	//doGet, doPost 처럼 생각
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("HelloController 요청 실행 : handleRequest 자동 실행 ^^");
		
		// 업무수행
		// DB연결 ... 로직 .....
		// 데이터 담기 , 뷰 지정하기 
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "kosauser"); // request.setAttribute
		mav.setViewName("Hello"); // forward 객체를 만들고 path를 설정하는 것과 비슷 >> Hello.jsp  // 경로잡을 때 /WEB-INF	/views/Hello.jsp
		//  /WEB-INF/views/+ Hello + .jsp  // resolver가 해주는 역할임. 
		//  /WEB-INF/views/Hello.jsp
		return mav;
	}

}
