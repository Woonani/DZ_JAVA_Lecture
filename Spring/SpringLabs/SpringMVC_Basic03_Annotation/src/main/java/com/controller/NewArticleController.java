package com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
/*
 클라이언트 요청....
 1. 화면 주세요 (글쓰기, 로그인 화면) : write.do
 2. 처리해 주세요 (글쓰기 입력 처리, 로그인 완료 처리) : writeok.do
  
 요청주소가 : write.do 화면
 요청주소가 : writeok.do 처리
 
 spring 
 클라이언트 요청
 요청을 method 단위로 처리
   * 1개의 요청 주소로 화면, 처리 판단 > 근거는> 클라이언트가 보낸 요청의 "전송방식(GET, POST)"으로 
   http:...../article/newArticle.do
   요청방식이 
   GET : 화면을 보여다랄고 인지 > view 제공
   POST : 처리로 인지 : 서비스 처리 하기 > insert, update 작업 후 >> 화면 제공 
    
 */
import org.springframework.web.bind.annotation.RequestMapping;
import com.model.NewArticleCommand;
import com.service.ArticleService;


@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {
	
	//NewArticleController 업무수행을 위해서 ArticleService 필요해(주소)
	//has-a >> 연관
	private ArticleService articleService;
	// injection 하는 방법 중 생성자, setter
	
	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	
	
	// 어노테이션이 5.대가 되면서 개선됨
	//@RequestMapping(method= RequestMethod.GET)
	@GetMapping // 5.x.x
	public String form() { // 화면 주세요
		System.out.println("GET 화면 주세요");
		// public String form() 함수의 리턴 타입이 String 이면 ... 스프링은 이것을 뷰의 주소로 인지한다.
		// public ModelAndView form() >> return ... 
		return "article/newArticleForm";
		// /WEB-INF/views/ + article/newArticleForm + .jsp
	}
	
	
	//@RequestMapping(method= RequestMethod.POST)
	@PostMapping // 5.x.x
	//NewArticleCommand얘가 dto를 봄 
	// name값이 dto 클래스의 member-field와 같음
	public String submit(@ModelAttribute("Articledata") NewArticleCommand command) { // 처리
		// "Articledata"이 command의 키로 설정됨
		System.out.println("POST 처리 주세요");
		
		this.articleService.writeArticle(command);
		
		//ModelAndView mv = new ModelAndView();
		//mv.addObject("newArticleCommand", command); 
		// 위부분이 생략  >> 자동으로 생성되기때문에 가능함. 
		
		// 뷰 key : NewArticleCommand >> newArticleCommand 
		
		return "article/newArticleSubmitted"; 
	}
}
// 전통적인 방식
// request param
// path variable rest  쓰는 방식 


/*
 호랑이 담배피던 시절에 했던 코드 .... HttpServletRequest request >> spring 고민 고민 ..... 
 
  @PostMapping // 5.x.x
	public ModelAndView submit(HttpServletRequest request) { // 처리
		System.out.println("POST 처리 주세요");
		NewArticleCommand article = new NewArticleCommand();
		article.setParentId(request.getParameter("parentId"));
		article.setTitle(request.getParameter("title"));
		article.setContent(request.getParameter("content"));
		
		this.articleService.writeArticle(article);
		ModelAndView mv = new ModelAndView();
		mv.addObject("newArticleCommand", article); // article이라는 객체의 주소값
		mv.setViewName("article/newArticleSubmitted");
		
		return mv;
	}
 
*/

/*
 2. Spring 에서 parameter DTO 객체로 받기
 2.1 자동화 >> 선행조건 >> input 태그의 name 값이 DTO 객체의 member-field 명과 동일
 ((newArticleSubmitted.jsp파일의 input 태그))
 
 @PostMapping // 5.x.x
	//NewArticleCommand얘가 dto를 봄 
	// name값이 dto 클래스의 member-field와 같음
	public ModelAndView submit(NewArticleCommand command) { // 처리
		System.out.println("POST 처리 주세요");
		
		// parameter를 저렇게 DTO로 받으면
		// 1. 자동 DTO 객체 생성 : NewArticleCommand article = new NewArticleCommand();
			// ((위 생성자 함수가 자동으로 실행 ))
		// 2. 넘어온 parameter setter 함수를 통해서 자동 주입 => article.setParentId 자동
		// 3. NewArticleCommand command 객체 자동 IOC 컨테이너 안에 등록 : id=newArticleCommand
		// <bean id="newArticleCommand" class="... 이 부분들이 자동화 됨
		
		this.articleService.writeArticle(command);
		ModelAndView mv = new ModelAndView();
		mv.addObject("newArticleCommand", command); // article이라는 객체의 주소값
		mv.setViewName("article/newArticleSubmitted");
		
		return mv;
	}
 */
 
