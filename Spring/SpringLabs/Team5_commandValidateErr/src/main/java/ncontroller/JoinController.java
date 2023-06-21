package ncontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.MemberDao;
import service.MemberService;
import vo.Member;

@Controller
@RequestMapping("/joinus/")
public class JoinController {

	private MemberService memberservice;

	@Autowired
	public void MemberService(MemberService memberservice) {
		this.memberservice = memberservice;
	}
	
	//GET 요청
	//join.jsp 화면
	@GetMapping("join.htm")  //  /joinus/join.htm
	public String join() {
		return "joinus/join";
		//   /WEB-INF/views/  +  joinus/join   + .jsp
	}
	
	
	//POST 요청
		@PostMapping("join.htm")
		public String join(Member member) {
			String url = null;
			System.out.println(member.toString());
			memberservice.join(member);
			return url;
			//http://localhost:8090/SpringMvc/joinus/join.htm
			// "redirect:/index.htm";
			//http://localhost:8090/SpringMvc/index.htm
		}
}
