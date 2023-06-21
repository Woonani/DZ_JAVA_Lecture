package ncontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import service.EmpService;
import vo.Emp;

@Controller
@RequestMapping("/emp/")  //부분 경로 ..... 긴 경우
public class EmpController {
   
	private EmpService empservice;
	
	@Autowired
	public void setEmpservice(EmpService empservice) {
		this.empservice = empservice;
	}

	//전체 조회
	@GetMapping("list.do") 
	public String emplists( Model model) {
		List<Emp> list = empservice.getLists();
		model.addAttribute("list", list); 
		return "emp/emplist";    	
	}
	// 검색 조회
	@PostMapping("list.do")
	public String emplistByname(String qname, Model model) {
		System.out.println("controller qname : "+qname);
		List<Emp> list = null;

		 try {
			   list = empservice.getListByEname(qname);
			   // 아래 코드의 위치가 return 바로위인지 여기인지...
			   model.addAttribute("list", list); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		return "emp/emplist";
	}
	// emp 추가 페이지 이동
	@GetMapping("empReg.do") 
	public String empReg() {
		return "emp/empReg";    	
	}
	// emp 추가
	@PostMapping("empReg.do")
	public String addEmp (Emp emp) {
		String url = null;
		int result = 0;
		try {
			result = empservice.addEmp(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result > 0 ) {
			System.out.println("등록성공");
			// url = "emp/emplist";
		}else {
			System.out.println("등록실패");
			// url = "emp/empReg";
		}
		return "emp/emplist";
	}
	
	// emp 수정
	// - 상세 페이지 들어가기
	@GetMapping(value="empDetail.do") 
	public String empDetail(String empno, Model model) {
		Emp emp = null;
		try {
				emp = empservice.empEdit(empno);
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		model.addAttribute("emp", emp); 		
		return "emp/empDetail";
	
	}	
	// - 수정 페이지 들어가기
	@GetMapping(value="empEdit.do") 
	public String empEdit(String empno, Model model) {
		Emp emp = null;
		try {
			emp = empservice.empEdit(empno);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		// System.out.println("controller emp : "+ emp);
		model.addAttribute("emp", emp); 		
		return "emp/empEdit";		
	}	
	
	// - 수정 요청
	@PostMapping("empEdit.do") 
	public String empEditDo(Emp emp, Model model) {
		System.out.println("controller 진입 ---------------------");
		System.out.println("controller 수정된 emp : "+ emp);

		try {
			empservice.setEmp(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		model.addAttribute("emp", emp); 		
		return "emp/empDetail";		
	}	
	
	
	// 삭제
	@GetMapping("empDel.do")
	public String empDel(String empno) {
		empservice.empDelete(Integer.parseInt(empno));
		return "emp/emplist";
		// 리다이렉트로 바꾸기 등로도 전부 
	}
	
	/*
	 * //form method="post"
	 * 
	 * @PostMapping("empEdit.do") public String noticeEdit(Notice n ,
	 * HttpServletRequest request) { return customerservice.noticeEdit(n, request);
	 * }
	 * 
	 * @GetMapping("noticeDel.htm") public String noticeDel(String seq) { return
	 * customerservice.noticeDel(seq); }
	 */
	
	
	//---------------------------------------------------------------------
	// 조건 조회 / 삽입  /수정 / 삭제
	/*
	@RequestMapping("noticeDetail.htm") 
	public String noticesDetail(String seq , Model model) {
		Notice notice = customerservice.noticesDetail(seq);				
		model.addAttribute("notice", notice); 		
		return "customer/noticeDetail";
	}
	
	@GetMapping(value="noticeReg.htm")  
	public String noticeReg() {
		return "customer/noticeReg";
	}
	

	@PostMapping(value="noticeReg.htm")  
	public String noticeReg(Notice n , HttpServletRequest request) {
		 String url= null;
		 try {
			   url = customerservice.noticeReg(n, request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}
	
	@GetMapping(value="noticeEdit.htm") 
	public String noticeEdit(String seq,Model model) {
		Notice notice=null;
		try {
				notice = customerservice.noticeEdit(seq);
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		model.addAttribute("notice", notice); 		
		return "customer/noticeEdit";
	
	}
	
	//form method="post"
	@PostMapping("noticeEdit.htm")
	public String noticeEdit(Notice n , HttpServletRequest request) {
		return customerservice.noticeEdit(n, request);
	}
	
	@GetMapping("noticeDel.htm")
	public String noticeDel(String seq) {
		return customerservice.noticeDel(seq);
	}
	//파일 다운로드
	@RequestMapping("download.htm")
	public void download(String p , String f , HttpServletRequest request , HttpServletResponse response) throws IOException {
		  customerservice.download(p, f, request, response);
	}
	*/
}
