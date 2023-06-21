package ncontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.CustomerService;
import vo.Emp;

@Controller
public class IndexController {

	@Autowired
	private CustomerService customerservice;

	@Autowired
	public void setCustomerservice(CustomerService customerservice) {
		this.customerservice = customerservice;
	}



	@RequestMapping("index.htm")
	public String index(Model model) {
		
		List<Emp> emp = customerservice.getEmp();
		model.addAttribute("emp",emp);
		return "index";
		
		//   /WEB-INF/views/  +  index   + .jsp
	}
}


