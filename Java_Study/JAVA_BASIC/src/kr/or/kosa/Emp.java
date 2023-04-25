package kr.or.kosa;

public class Emp {
	public int empno; //속성 >> member field >> instance variable >> 객체변수
   					// 변수는 초기화를 하지 않아도 된다. > default값이 있기 때문에!! (int의 default는 0)
					// 생성되는 생성되는 사원(객체) 마다 다른 사번을 갖는다
	
	// 클래스는 멤버 필드와 메서드밖에 못가짐!
    // 아래와 같은 제어문은 클래스자원이 아니라 함수의 자원임!!
	//for(int i ) //에러 ) 함수안에서 써야 함
	
	public void infoPrint( ) {
		int data; // local variable >> 지역변수
	}
}
