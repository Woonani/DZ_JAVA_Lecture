package controllers.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.NoticeDao;
import vo.Notice;

@Controller
@RequestMapping("/customer/noticeDetail.do")
public class NoticeDetailController {

	public NoticeDetailController() {
		System.out.println("[NoticeDetailController]");
	}
	
	private NoticeDao noticsdao;
	@Autowired
	public void setNoticsdao(NoticeDao noticsdao) {
		this.noticsdao = noticsdao;
	}
	
	@GetMapping
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//public Notice getNotice(String seq)
		
		String seq = request.getParameter("seq");
		Notice  notice = noticsdao.getNotice(seq);
		
		ModelAndView  mv = new ModelAndView();
		
		mv.addObject("notice", notice);
		mv.setViewName("noticeDetail");
		
		return mv;
	}

}
