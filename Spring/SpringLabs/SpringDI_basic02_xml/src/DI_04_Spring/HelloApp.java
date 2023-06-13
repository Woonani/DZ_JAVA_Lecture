package DI_04_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {

		// 순수한 java 코드로 작업한다면
//		 MessageBeanImple messagebean = new MessageBeanImple("hong");
//		 messagebean.setGreeting("helloooooo");
//		 messagebean.sayHello();
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_04_Spring/DI_04.xml");
		MessageBean messagebean = context.getBean("m2", MessageBean.class); // bean객체를 클래스로 받아서 넣는다고?
		messagebean.sayHello();
		
	}

}
