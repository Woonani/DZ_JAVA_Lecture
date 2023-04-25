import kr.or.kosa.Emp;

public class Ex02_Variable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//변수선언
		int value;  // 선언
		 value = 100; // 할당
		 
		 int age = 99; // 선언과 할당을 동시에
		 
		 // 초기값 정의(초기화) : 변수의 초기화 : 변수가 최초로 값을 갖는것
		 
		 // 함수안에 들어있는 변수를 지역변수 (local variable)
		 // 지역변수는 함수와 라이프 사이클이 같다
		 // 프로그램 종료 : 스택에서 메인영역이 사라지는것
		 
		 int num = 0;
		 System.out.println(num); // 컴파일 되지 않음(=실행파일이 만들어지지 않는다)
		 // local variable(지역변수)은 사용시 반드시 초기화를 해야 한다. 
		 // 지역변수는 무조건 초기화하고 사용한다
		 
		 // Emp emp; // 이렇게 선언하면 에러남
		 // Stack영역에 메모리 할당 시 : int 4byte, long 8byte, 클래스 객체 Emp는? 주소값을 담는 공간에 4byte를 줌 
		 // System.out.println(emp); //컴파일 에러남  
		 Emp emp = new Emp(); // new 연산자를 사용해서 메모리에 올리는 작업 >> 초기화작업
		 // >> 메모리 heap에 생성된 객체의 주소값(x번지)
		 // 설계도와 똑같은 집을 짓는다. (메모리에)
		 System.out.println(emp); //kr.or.kosa.Emp@626b2d4a (사실은 주소값아님 나중에,,)
		 
		 // . 주소를 찾아가는 연산자
		 System.out.println(emp.empno); // default 값 0이 출력
		 // empno는 instance variable > 생성할 때마다 새로 생성되는 변수
		 
		 int a, b, c; //같은 타입의 변수를 나열 : 선호되지 않음.>> 개발자의 생각 int 타입의 배열(Array) int[] a
		 // 사용하려면 초기화
		 a = 100;
		 b = 200;
		 c = 300;
		 
		 int data = 100;
		 // int data; // 같은 지역 내에서 같은 변수명 사용 불가
		 
		 int result = a + b; // 이것도 초기화다!
		 System.out.println("result 값은" + result); // 단축키 : Syso + ctrl + space
	
		 int k = 100;
		 int y = k;
		 y = 200;
		 
	}

}

/*
블럭주석

클래스 == 설계도 == 데이터 타입 !!

클래스의 종류
1. class Car {} > main 함수를 가지고 있지 않은 클래스 > 독자적인 실행이 불가능 > 다른 클래스에 도움을 주는 클래스(lib) - 라이브러리 클래스라고도 부름
2. class Car { public static void main (String[] args){} } > main 함수를 가지고 있는 클래스 > 독자적 실행이 가능
3. 현재는 main 함수를 가지고 있는 클래스가 있어야 결과를 확인 할 수 있다.
4. public static void main (String[] args) >> static (new 없이도 메모리에 생성됨) >> 함수의 이름 (main) : 시작점, 진입점 >> 약속

tip)
C#코드 >> class Car { public static void Main (String[] args) {} } > 자바와 같은데 main이 대문자로 시작하는 것만 다름!

변수 : variable 
데이터(자료)를 담을 수 있는 공간 (메모리)의 이름
공간(크기를 가져야 함) >> 데이터 타입(자료형) >> 
# 데이터 타입 왜 배우냐- 메모리가 한정되어있어서 - 최소한의 공간으로 데이터를 표현하기 위해!! 
int data = 100;

변수가 선언되는 위치(scope : 변수의 유효 범위)
1. instance variable : 객체변수(클래스안에)  >> class Car { public int door; } - class가 가지는 변수 
2. local variable : 지역변수(함수안에) >> class Car { public void run(){ int data = 0; } }  - 함수안에 선언되는 변수 지역 변수는 사용할 때 초기화! 
~스코프는 객체변수가 지역변수보다 큼!~
3. static variable : 공유자원 (객체간)  >> class Car {public static int num; } - 변수앞에 static이 붙으면 모든 객체가 사용할 수 있음!
4. 함수안에 있는 제어블럭 안에 있는 변수 (if, for) 블럭 변수  
	>> class Car { void run(){ for(int i=0... };  for(int i=0... }; } - i를 또 쓸 수 있는 이유


*/
