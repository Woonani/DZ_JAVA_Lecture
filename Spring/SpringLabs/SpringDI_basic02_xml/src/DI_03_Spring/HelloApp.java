package DI_03_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
	//영문
	// MessageBean_en en = new MessageBean_en();
	// en.sayHello("hello");

	// MessageBean_kr kr = new MessageBean_kr();
	// kr.sayHello("hello");
	
		//인터페이스 (다형성) 느슨한 구조 .....
		//MessageBean messagebean = new MessageBean_kr();
		//messagebean.sayHello("hong");
	// 위처럼 생성 안하고 container안에 만들어진 객체 꺼낼 것임.
		
		// spring  통해서 컨테이너를 만들고 (메모리) 안에 객체 생성, 조립하는 작업 할 것임.
		///class path 는 루트라고 생각하면 됨. 그 뒤는 패키지를 적음 xml은 점인데 아래 경로는 슬래쉬/로 적음
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_03_Spring/DI_03.xml");
		MessageBean messagebean = context.getBean("messagebean", MessageBean.class); // bean객체를 클래스로 받아서 넣는다고?
		messagebean.sayHello("hong");
		
		// 스프링은 스프링 만에 컨테이너가 있다.
		// xml을 읽어서 빈객체를 생성하고
		// 개발자는 필요한 객체를 꺼내 사용할 수 있다.
		// 정도만 이해!
	}

}
/*
요구사항
1. 한글버전 (hong) >> 안녕 hong
2. 영문버전 (hong) >> hello hong

MessageBean_kr 
MessageBean_en

interface 다형성 설계
*/