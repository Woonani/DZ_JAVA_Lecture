package DI_Annotation_04_javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 얘가 xml 파일을 대체 할 것임 
@Configuration // DI.xml 같은 역할을 합니다 (빈객체 생성과 조립) 자바파일로 ....
public class ConfigContext {
	// xml <bean id="user" class="DI_Annotation04_javaconfig.User"
	
	// 자바코드에서는 함수 객체를 생성하고 리턴
	@Bean
	public User user() {
		return new User();
	}
	
	// xml <bean id="user2" class="DI_Annotation04_javaconfig.User2"
	@Bean
	public User2 user2() {
		return new User2();
	}
	
}
