package ncontroller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.CustomerService;
import validation.ValidatorImpl;
import vo.Emp;
import vo.Notice;

@Controller
@RequestMapping("/customer/")  //부분 경로 ..... 긴 경우
public class CustomerController {
	
	@Autowired
	private CustomerService customerservice;
	
	
	
	@Autowired
	public void setCustomerservice(CustomerService customerservice) {
		this.customerservice = customerservice;
	}

	@GetMapping(value="getEmpByEmpno.htm")
	public String getEmpByEmpno(int empno, Model model ) { //@ModelAttribute("user") User user 파라미터에 이렇게 쓰면User객체 user를 모델에 추가.
		Emp emp = customerservice.getEmpByEmpno(empno);  // view에서 접근할때도
		model.addAttribute("empbyname",emp);
		return "index2";
	// views/   return / .jsp
	}
	
	@GetMapping(value="insertEmp1.htm")
	public String insertEmpPage() {
		return "index3";
	}
	
	@PostMapping(value="insertEmp1.htm")
	public String insertEmp(@ModelAttribute("emp") Emp emp, BindingResult bindingresult) {
		customerservice.empinsert(emp);
		String result = null;
		
		ValidatorImpl validator = new ValidatorImpl();
		validator.validate(emp, bindingresult); //bindingresult는 errors자리
		
		boolean tf = bindingresult.hasErrors();// 오류 존재시 true or false
		
		if (tf == true) {
			result = "index3"; // 오류 존재시 index3.jsp로(삽입화면) 
			 List<FieldError> fieldErrors = bindingresult.getFieldErrors();
			 System.out.println("당신이 범한 오류는 이것입니다 : " + fieldErrors);
		}
		else  {
			result = "redirect:/index.htm"; // 오류 존재하지 않을 경우 (첫화면)
		}
		
		return result;
	}
	
	
	@GetMapping(value="detail.htm") 
	public String empDetail( int empno, Model model) {
		Emp emp = customerservice.getEmpByEmpno(empno);
		model.addAttribute("emp",emp);
		return "index4";
	}
	
	
	
	
	
	
	
	
//	@RequestMapping("notice.htm") 
//	public String notices(String pg , String f , String q , Model model) {
//		List<Notice> list = customerservice.notices(pg, f, q);
//		model.addAttribute("list", list); 
//		return "customer/notice";
//    	
//	}
//	
//	@RequestMapping("noticeDetail.htm") 
//	public String noticesDetail(String seq , Model model) {
//		Notice notice = customerservice.noticesDetail(seq);				
//		model.addAttribute("notice", notice); 		
//		return "customer/noticeDetail";
//	}
//	
//	@GetMapping(value="noticeReg.htm")  
//	public String noticeReg() {
//		return "customer/noticeReg";
//	}
//	
//
//	@PostMapping(value="noticeReg.htm")  
//	public String noticeReg(Notice n , HttpServletRequest request) {
//		 String url= null;
//		 try {
//			   url = customerservice.noticeReg(n, request);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return url;
//	}
//	
//	@GetMapping(value="noticeEdit.htm") 
//	public String noticeEdit(String seq,Model model) {
//		Notice notice=null;
//		try {
//				notice = customerservice.noticeEdit(seq);
//		} catch (Exception e) {
//			 e.printStackTrace();
//		}
//		
//		model.addAttribute("notice", notice); 		
//		return "customer/noticeEdit";
//	
//	}
//	
//	//form method="post"
//	@PostMapping("noticeEdit.htm")
//	public String noticeEdit(Notice n , HttpServletRequest request) {
//		return customerservice.noticeEdit(n, request);
//	}
//	
//	@GetMapping("noticeDel.htm")
//	public String noticeDel(String seq) {
//		return customerservice.noticeDel(seq);
//	}
//	
//	//파일 다운로드
//	@RequestMapping("download.htm")
//	public void download(String p , String f , HttpServletRequest request , HttpServletResponse response) throws IOException {
//		  customerservice.download(p, f, request, response);
//	}
	
}
