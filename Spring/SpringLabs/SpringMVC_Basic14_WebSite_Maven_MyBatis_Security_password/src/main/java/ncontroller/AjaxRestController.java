package ncontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vo.Emp;
import vo.Member;

@RestController
public class AjaxRestController {
	
	@RequestMapping(value="/joinus/searchByno.htm" )
	public Emp ajaxResponseBody(){
		Emp emp = new Emp();
	
		
		emp.setEmpno(7788);
		emp.setEname("홍길동");
		System.out.println(emp);
		return emp;
	}
}