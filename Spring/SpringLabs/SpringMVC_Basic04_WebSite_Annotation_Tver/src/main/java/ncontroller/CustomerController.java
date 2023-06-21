package ncontroller;

import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dao.NoticeDao;
import vo.Notice;

@Controller
@RequestMapping("/customer/")  //부분 경로 ..... 긴 경우
public class CustomerController {
   
	//CustomerController 는 noticeDao 의존합니다 
	private NoticeDao noticedao;

	@Autowired
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}
   /*
	1. method안에서 return type  [String] 리턴값이 뷰의 주소
	2. public ModelAndView notices ...    >  ModelAndView 객체 생성  > 데이터 , 뷰 설정 > return 
	3. public String notices (Model model) { 함수가 실행시 내부적으로 Model객체의 주소가 들어온다  }
   */
	
	//DAO 단 전체 게시물 데이터 가져오기 함수
	//public List<Notice> getNotices(int page, String field, String query)
	//함수는 요청을 받아서 게시물 전체보기....
	
	@RequestMapping("notice.htm")   //   /customer/notice.htm
	public String notices(String pg , String f , String q , Model model) {
		
		// Model model  >> 데이터 저장 >> Model 구현하는 객체 자동 만들어서 줄게 >> 너 그냥 써
		//HttpServletRequest request   >> 생성된 request 객체의 주소 할당....
		
		
		//각 parameter 기본값 설정
		//default 값 설정
		int page = 1;
		String field="TITLE";
		String query = "%%";
		
		if(pg != null   && ! pg.equals("")) {
			page  = Integer.parseInt(pg);
		}
		
		if(f != null   && ! f.equals("")) {
			field = f;
		}
		
		if(q != null   && ! q.equals("")) {
			query  = q;
		}
		
		//DAO 작업
		//DAO 작업  예외 throws ClassNotFoundException, SQLException
		List<Notice> list = null;
		try {
				list = noticedao.getNotices(page, field, query);
		} catch (ClassNotFoundException e) {
					e.printStackTrace();
		} catch (SQLException e) {
					e.printStackTrace();
		}
		
		//list View 전달 (저장 >> 전달)
		//1. public ModelAndView .... 
		//   mv.addObject("list",list)
		//   mv.setViewName("notice.jsp")
		//   return mv
		
		model.addAttribute("list", list); // 자동으로 notice.jsp forward ....
		
		return "notice.jsp";
	}
	
	//DAO 단  상세보기 데이터 가져오기 함수
	//public Notice getNotice(String seq)
	@RequestMapping("noticeDetail.htm") 
	public String noticesDetail(String seq , Model model) {
		
		Notice  notice = null;
		
		try {
			notice = noticedao.getNotice(seq);
		} catch (ClassNotFoundException e ) {
				e.printStackTrace();
		} catch (SQLException e) {
				e.printStackTrace();
		}
				
		model.addAttribute("notice", notice); 		
		
		return "noticeDetail.jsp";
	}
	
	//@GetMapping (화면) : select
	//@PostMapping (처리) : insert
	// <a class="btn-write button" href="noticeReg.htm"
	@GetMapping(value="noticeReg.htm")
	public String noticeReg() {
		return "noticeReg.jsp";
	}
	
	// form method = "post" action="" 현재 주소창에 있는 주소
	// /customer/noticeReg.htm 전송 >> POST
	
	@PostMapping(value="noticeReg.htm") // 같은주소 다른 전송방식
	public String noticeReg(Notice n, HttpServletRequest request ) { // dto 멤버필드이름과 파라미터 이름 동일하면
		System.out.println(n.toString());
		
		// 추후 파일 처리
		
		/*
		 * CommonsMultipartFile imagefile = n.getFile(); System.out.println("imagefile"
		 * + imagefile.toString());
		 * 
		 * // POINT 파일명 추출 n.setFileSrc(imagefile.getOriginalFilename());
		String filename = imagefile.getOriginalFilename();
		 */
		String filename =n.getFile().getOriginalFilename();
		String path = request.getServletContext().getRealPath("/upload"); // 배포된 서버의 경로  
		String fpath = path  + "\\" + filename; // c:\\temp\\a.jpg로 저장해야지 의 의미
		System.out.println(fpath);
		
		FileOutputStream fs = null;
		
		try {
			fs = new FileOutputStream(fpath); // 파일 경로에 a.jpg 없으면 생성함 .
			// fs.write(imagefile.getBytes());
			fs.write(n.getFile().getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		// 글쓰기 완료 >> 목록 >> location.href="" or response.sendRedirect
		// Spring 에서의 방식은 >> redirect:notice.htm
		return "redirect:notice.htm";
	}
	
	// 글 수정하기 (화면이면서 데이터 처리 ) GET
	@GetMapping(value="noticeEdit.htm") 
	public String noticeEdit(String seq, Model model) {
		Notice notice = null;
		
		try {
			notice = noticedao.getNotice(seq);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("notice", notice);
		
		return "noticeEdit.jsp";
	}
	
	// form method = "post"
	@PostMapping("noticeEditProc.htm")
	public String noticeEdit(Notice n) {
		System.out.println(n.toString());

		// 추후 파일 처리
		
		// 글 수정후 상세보기로 가야하는데 다시 불러와야하니까 redirect로 한다
		
		//return "redirect:noticeDetail.htm?seq="+n.getSeq();
		return "redirect:noticeDetail.htm?seq=1";
	
	
	}
}
