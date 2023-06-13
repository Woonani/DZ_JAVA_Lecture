package DI_06_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import DI_05_Spring.MyBean;

public class HelloApp {
	public static void main(String[] args) {
		
		// 순수한 java 코드로 짜본다.
		//ArticleService service = new ArticleService(new OracleDao());
		//ArticleService service = new ArticleService(new MySqlDao());
		//Article article = new Article();
		//service.write(article);
		
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_06_Spring/DI_06.xml");
		//OracleDao oracledao =  context.getBean("oracleDao", OracleDao.class);
		ArticleService service =  context.getBean("service", ArticleService.class);
		Article article =  context.getBean("article", Article.class);
		
		service.write(article);
	}

}
