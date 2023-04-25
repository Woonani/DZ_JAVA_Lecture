
/*
 static 초기화
 1. static variable : 공유자원(객체간 공유자원) : 객체마다 "같은 값을 공유"할 거야
 2. instance variable : 생성되는 "객체마다 다른 값"을 가지게 하겠다
 
 두 자원은 default 값
 초기화는 필요에 따라 할 수 도 있고 안 할 수도 있음.
 
 */

class Test2 {
	static int cv = 10; // 초기화
	static int cv2; // default 0
	int iv = 9;
	// 위 세 변수는 default 값이 있어서 초기화를 하지 않아도 사용가능

	// for(int i) : 제어문은 함수안에있는것, class에는 member field와 method

	// 1. static 자원 초기화 블럭 static { }
	static { // 생성자보다 먼저 돈다
		// 실행되는 시점 : static int cv = 10, static int cv2 메모리에 올라간 직후 실행(자동호출)
		cv = 1111;
		// 조작된 표현이 가능 **(제어문도 가능 )
		cv2 = cv + 2222;
	}

	// 2. 일반 자원 (member field) 초기화 블럭 { } >> 생성자 함수와 기능이 동일 (인기가 ...)
	{
		// int iv = 9; >> 메모리 >> 선행 >> Test2 test2 = new Test2();
		// { } 초기화 블럭은 언제 ...? member field 가 memory에 올라간 직후 블럭 (실행)
		// 조작된 값을 사용하지 못해요
		// if(iv > 10) iv = 100;
		System.out.println("초기화 블럭 실행");
		if (iv > 10){iv = 10000;}
	}

}

public class Ex07_Static_init {

	public static void main(String[] args) {
		System.out.println(Test2.cv);
		System.out.println(Test2.cv2);

		Test2 test = new Test2();
		System.out.println(test.iv);

	}

}
