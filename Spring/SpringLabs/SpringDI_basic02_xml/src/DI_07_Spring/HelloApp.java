package DI_07_Spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		/*
		ProtocolHandler handler = new ProtocolHandler();
		
		List<MyFilter> list = new ArrayList<MyFilter>(); // arrayList도 Bean으로 만들어야 함
		list.add(new EncFilter());
		list.add(new ZipFilter());
		list.add(new HeaderFilter());
		
		handler.setFilters(list);
		
		
		System.out.println(handler.filter_Length());
		*/
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_07_Spring/DI_07.xml");
		ProtocolHandler handler = context.getBean("protocolHandler", ProtocolHandler.class); // 캐스팅?
		System.out.println(handler.filter_Length());
		
	}

}
