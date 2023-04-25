import java.util.Properties;

/*
 Map 인터페이스를 구현한 클래스
 특수한 목적 : <String, String> : key와 value의 타입이 String으로 고정되어있음
 
 사용목족
 1. App 전체에 사용되는 자원관리
 2. 환경변수 (전역의 의미)
 3. 프로그램의 버전
 4. 로그인ID, 비번    ex) yml파일
 5. 공통변수 
 
 
 */
public class Ex14_Properties {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("admin", "kosa@ot.kr");
		prop.setProperty("version", "1.x.x.x");
		prop.setProperty("downpath", "C:\\Temp\\images");
		//프로퍼티 파일은 설정파일. 주로 어플리케이션의 자원과 관련
		// 각가긔 개발 페이지에서 본다고 가정
		System.out.println(prop.getProperty("admin")); //kosa@ot.kr
		System.out.println(prop.getProperty("version")); //1.x.x.x
		System.out.println(prop.getProperty("downpath")); //C:\Temp\images

	}

}
