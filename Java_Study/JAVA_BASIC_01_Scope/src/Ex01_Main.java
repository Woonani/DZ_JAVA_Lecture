import kr.or.kosa.common.Car;

/*
 클래스 == 설계도 == 타입(사용자 정의)
 
  클래스의 구성요소 (설계도라고 판단하려면 최소한의 무엇을 가지고 있어야 한다)
  [필드 + 메서드]
  (속성 + 함수(기능))
  
  필드 (member field) >> 데이터, 자료 정보를 담고있다 >> [고유정보], [상태정보], [부품정보] >> field >> variable
  																								변하는거  다시 설계도를 그릴수 있는거
  함수 (method) >> 기능(행위) >> 자동차 >> 달린다, 멈춘다, 소리가 난다, 문을 연다 ...
  + 추가적으로 생성자(함수) >> 특수한 목적의 함수 >> 객체 생성시 member field를 초기화 목적으로 생성되는 함수, getter, setter를 사용해서 캡슐화 된 자원을 (read, write)
  class 설계도 {
      	고유정보  커피회사, 기계 디자인
      	상태정보  ex) 커피가루, 종이컵, 등등
      	부품정보 
      	
      	기능(행위)
  }
  
  클래스, 필드, 생성자함수, 메서드 : 영역 (범위) >> 생성되는 장소(위치) or 접근자(한정자, 수정자) 
  
  장소(위치) : 폴더(package)를 기반으로 ...클래스 내부/ 함수 내부/ 제어문 내부
  접근자 : public, private, default, protected
  
  
  
  kr.or.kosa.common 안에 생성한 Car 클래스는 > public class Car( ) >> 나 다 오픈할거야
  kr.or.kosa.common 안에 생성한 AirPlane 클래스는 > class AirPlane { } >> 같은 폴더 안에서만 사용
  
  >> default 같은 폴더에서만 공유 (같은 package 에서만 사용)
  >> 연습용으로 .... 또는 특정클래스의 도움을 주는 클래스 생성시
  
  연습용으로 빠르게 작업시 가장 편한 방법?
  하나의 물리적 Java 파일은 여러개의 클래스를 가질 수 있다.
  >> Ex01_Main.java 파일은 그 안에 public class Ex01_Main 클래스를 가지고 있다. 
  1. 개발에서는 필요한 클래스는 package 생성하고 그 안에 만들어서 사용합니다. 
  2. 그냥 연습 해볼때= 폴더 많이 안만들고 싶을 때= 물리적 파일 여러개 만들 필요가 없을 때
  3. 하나의 물리적 파일에 여러개의 클래스를 만들어 쓸수있게 해줄까 (연습..)
  3.1 대신에 public 접근자는 하나만 갖는다. 
  
 
 */

class Emp{  // 연습할때나 공부할때.....
	
}

class Dept{  // 컴파일러가 default class Dept 로 해석함.
	int deptNo; // 멤버필드! (부서번호) // 컴파일러가 default int deptNo 로 해석
	public String dname; // 에러는 아니지만 다른 폴더사용 불가 (클래스 default) public 의미 없다
	private int count;     // private 캡슐화(은닉) 감추다, 숨기다, 
								// 설계자의 의도 : 클래스 내부에서만 사용 목적
								// 설계자의 의도 : 이 자원에 대해 직접할당을 막고 간접 할당을 제어하겠다.
	
	// 특수한 함수
	// getter (읽기 전용), setter (쓰기 전용)
	public int getCount() { //캡슐화된 멤버 필드에 대한 읽기지원
		return this.count; 
	}
	public void setCount(int count) { // 간접할당
		if(count <0) {
			this.count = 0;
		}else {
			
			this.count = count;
		}
		
			
	}
	
}

//class Apt { 같은 패키지 안에 같은 클래스명 X!!
//	
//}

/*
 폴더 
 kr.or.kosa.dto.Test
 
 public class Test {
 	private int i;
 	
 	public void setI(int i) {
 		this.i = i;
 	}
 	public int getI() {
 		return this.i;
 		}
 	
 	public void print() {
 	
 	}
 }
 */

// 연습용
class Test{	//default
	int data;	//default 클래스가 가지는 변수 (member field) >> instance variable 객체변수
	
	void print() {	//default
		int num=0;  // local variable 지역변수
		
		for(int i = 0; i<=100; i++) { // int i = 0 제어문 안에서  block variable
			
		}
		for(int i = 0; i<=100; i++) { // int i = 0 제어문 안에서 
			
		}
		int k = 0;
		for(k = 0; k<=100; k++) { // 블록 안에서 생성, 소멸 은 상관 없지만 상위 스코프에서 선언된 변수는 중복으로 쓸 수 없다. 
			
		}
	    System.out.println(k); // k는 101 (후치증가)
	}
	
}

// data 변수는 : Test test = new Test(); 일 때 생성
// print()함수가 호출 되었을때  num 변수 생성
// int i 변수는 for문이 실행 될 때 생성

public class Ex01_Main {

	public static void main(String[] args) {
		// 같은 폴더 안에 있는 클래스...
		Apt apt = new Apt();
 		//kr.or.kosa.common.Car car = new  kr.or.kosa.common.Car();  // public class Car { } 폴더의 구분없이 어디서나 사용가능하다
		Car car = new Car();  // public class Car { } 폴더의 구분없이 어디서나 사용가능하다
	
		Dept dept = new Dept();
 		//dept.count    (캡슐화)
	    dept.deptNo = 100;
	    System.out.println(dept.deptNo);
	    
	    dept.dname = "IT";
	    System.out.println(dept.dname);
	
	    Test test = new Test();
	
	}

}
