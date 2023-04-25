import java.lang.reflect.Method;

public class Ex09_Static_Method {

	void method() {
		System.out.println("나 일반함수야");
	}
	
	
	static void smethod() {
		System.out.println("나 static 함수야");
	}
	
	public static void main(String[] args) {

		smethod();
		
		// 같은 클래스에 있더라도 일반자원은 new 생성 후 사용할 수 있다!!
		Ex09_Static_Method ex09 = new Ex09_Static_Method();
		ex09.method();
		
		// 아래 처럼 쓸 수도 있다. 
		// Ex09_Static_Method.smethod();
		// ex09.smethod();
	}

}
