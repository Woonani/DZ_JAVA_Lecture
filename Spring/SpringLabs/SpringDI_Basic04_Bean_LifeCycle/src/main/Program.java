package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.Client;

public class Program {

	public static void main(String[] args) {
		
		//Client client = new Client("192.168.0.115");
		//client.setHost("192.168.1.1");
		
		
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("classpath:ApplicationContext.xml");
		// xml path new 할때 xml에 있는 bean 객체 생성하면서 등록된 생성자 함수 전부 동작.
		System.out.println("----------------1---------------");
		Client client = context.getBean("client", Client.class);
		System.out.println("----------------2---------------");
		client.send();
		context.close(); //컨테이너 종료
		
		
	} 

}
