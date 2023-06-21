package kr.or.kosa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import kr.or.kosa.service.SampleService;
import kr.or.kosa.service.SampleServiceImpl;

public class Main {

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring/root-context.xml");
        SampleService sampleService = (SampleService) context.getBean("sampleServiceImpl");

       sampleService.dodivide(1, 0);
        ((FileSystemXmlApplicationContext) context).close();
	}

}
                                                                                                                                                                                                                                                                                   