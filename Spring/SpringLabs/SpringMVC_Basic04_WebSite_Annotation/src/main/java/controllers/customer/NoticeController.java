package controllers.customer;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import dao.NoticeDao;
import vo.Notice;

/*
게시판 목록 조회 

controller  -> Model의존  (DAO , DTO) 가 필요

NoticeController 는   NoticeDao에 의존한다
필요하면 값을 받아야 해요 ... (DI , injection (생성자 , 함수(setter) 통해서 주입 받는다
*/

@EnableWebMvc
@Controller
public class NoticeController {
	//CustomerController는 noticeDao에 의존합니다.
	private NoticeDao noticsdao;
	
	@Autowired
	public void setNoticsdao(NoticeDao noticsdao) {
		this.noticsdao = noticsdao;
	}

    // param 받을 땐 request param
	@RequestMapping("/customer/notice.do")
	public ModelAndView searchExternal(@RequestParam(value="pg", defaultValue ="1") int page,
									   @RequestParam(value="f", defaultValue="TITLE") String field, 
									   @RequestParam(value="p", defaultValue="%%") String query) throws ClassNotFoundException, SQLException 
	{
		
		//public List<Notice> getNotices(int page, String field, String query)
		System.out.println("param page : " +  page );
		System.out.println("param field : " +  field );
		System.out.println("param query : " +  query );
		
		
		//DAO 작업
		List<Notice>  list = noticsdao.getNotices(page, field, query);
		
		
		//Spring  적용
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("notice");
		
		
		for(Notice n : list) {
			System.out.println("list확인 : " + n.toString());
		}
		
		return mv;
//		return new ModelAndView("notice");
	}
	
	@RequestMapping("/customer/noticeDetail.do")
	public ModelAndView showNoticeDetail(String seq) throws ClassNotFoundException, SQLException {
		
		//public Notice getNotice(String seq)
		
		//String seq = request.getParameter("seq");
		Notice  notice = noticsdao.getNotice(seq);
		
		ModelAndView  mv = new ModelAndView();
		System.out.println("여기를 탔니?");
		mv.addObject("notice", notice);
		mv.setViewName("noticeDetail");
		
		return mv;
	}
	
	/*
	 @Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	     //DAO 객체 사용
		//public List<Notice> getNotices(int page, String field, String query)
		
		String _page = request.getParameter("pg");
		String _field = request.getParameter("f");
		String _query = request.getParameter("p");
		  
		//default 값 설정
		int page = 1;
		String field="TITLE";
		String query = "%%";
		if(_page != null   && ! _page.equals("")) {
			page  = Integer.parseInt(_page);
		}
		
		if(_field != null   && ! _field.equals("")) {
			field = _field;
		}
		
		if(_page != null   && ! _page.equals("")) {
			page  = Integer.parseInt(_page);
		}
		
		if(_query != null   && ! _query.equals("")) {
			query = _query;
		}
		
		//DAO 작업
		List<Notice>  list = noticsdao.getNotices(page, field, query);
		
		
		//Spring  적용
		ModelAndView   mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("notice.jsp");
		
		
		
		return mv;
	} 
	 */

}
