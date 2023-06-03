package kr.or.kosa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.dao.RegisterDao;
import kr.or.kosa.dto.RegisterDto;

/*
Url 방식 (command 방식 상관 없다)
http://192.168.0.46:8090/WebSite/list.do >> *.do 매핑
http://192.168.0.46:8090/WebSite/write.do >> *.do 매핑

Command방식(parameter 업무 파악)
@WebServlet("site.do")
http://192.168.0.46:8090/WebSite/site.do?cmd=list
http://192.168.0.46:8090/WebSite/site.do?cmd=write

*/
@WebServlet("*.do")
public class FrontRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontRegisterController() {
		super();

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.한글
		request.setCharacterEncoding("UTF-8");
		// 2.데이터 받기
		String cmd = request.getParameter("cmd");

		// 3.요청 판단하기 ... 판단에 따른 서비스 실행
		String viewPage = "";

		// 16:30분까지 조별 1명 접속 회원가입 할게요 ^^
		// register 라면 회원가입 주세요
		// registerok 라면 회원데이터 받아서 DB insert 하세요 그리고 webcome 페이지 forward
		// request 에 회원 id 하고 환영인사 담아서 view 에서 출력
		if (cmd.equals("register")) {
			// 회원가입 페이지(VIEW)
			// VIEW 만 전달
			viewPage = "/WEB-INF/views/register/register.jsp";

			// 필요에 따라서 request 데이터 저장
		} else if (cmd.equals("registerok")) {
			// registerok 라면 회원데이터 받아서 DB insert 하세요 그리고 webcome 페이지 forward
			
			int id = Integer.parseInt(request.getParameter("id"));
			String pwd = request.getParameter("pwd");
			String email = request.getParameter("email");
			
			RegisterDto dto = new RegisterDto();
			dto.setId(id);
			dto.setPwd(pwd);
			dto.setEmail(email);
			
			RegisterDao dao = new RegisterDao();
			dao.writeOk(dto);
			
			viewPage = "/WEB-INF/views/register/register_welcome.jsp";
			// request 에 회원 id 하고 환영인사 담아서 view 에서 출력
			// request.getRequestDispatcher("/register_welcome.jsp");
			request.setAttribute("welcomeId", id);
		}
		
		/*
		 * int id = Integer.parseInt(request.getParameter("id")); String email =
		 * request.getParameter("pwd"); String memo = request.getParameter("email");
		 */



		// request.setAttribute("result", resultobj);
		
		// 5.뷰지정
		RequestDispatcher dis = request.getRequestDispatcher(viewPage);
		// 6.뷰 forward
		dis.forward(request, response); // 현재 내가 가지고 있는 request 객체의 주소값을 forward 시킴. parameter로 .

		// request.getContextPath();

		// 4.데이터 담기

		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
