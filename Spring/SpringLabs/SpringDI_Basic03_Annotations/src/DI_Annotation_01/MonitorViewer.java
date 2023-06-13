package DI_Annotation_01;

import org.springframework.beans.factory.annotation.Autowired;

public class MonitorViewer {
	private Recorder recorder; 
	// 모니터 뷰어가 레코더에 의존: 엄마가 나에게 의존 : 엄마가 나를 사용 : 모니터 뷰어가 레코더를 사용할 수 있어야함
	
	public Recorder getRecorder( ) {
		return recorder;
	}
	//MonitorViewer는 recorder에 의존합니다. 필요합니다 .. 주소가 필요
	
	/*
	xml 설정에서 
	<property name="recorder">
		<ref bean="recorder" />
	</property>
	Annotation으로 
	@Autowired (by type)
	컨테이너 안에 빈객체들이 생성되고 .... 주입 .... @Autowired 만나면 ....
	컨테이너 안에 Recorder 타입 빈 객체를 찾고, (만약) 있으면 자동 주입을 함
	
	@Autowired(required = true) >> default >. 무조건 injection
	@Autowired(required = false) >> 컨테이너 안에 원하는 타입의 객체가 없으면 주입 안하면 되지 ...  
	
	*/
	
	@Autowired // autowired는 같은 타입이 컨테이너 안에 있으면 됨.
	public void setRecorder(Recorder recorder) {
		this.recorder= recorder;
	}
}

