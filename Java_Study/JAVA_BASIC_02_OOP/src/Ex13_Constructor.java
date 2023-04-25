/*
 생성자 함수(constructor)
 1. 특수한 목적의 함수
 2. 목적 ( menber field 초기화) >> static {} , { 초기자 블럭 }
 
 3. 일반 함수와 다른점
 3.1 함수 이름이 고정 (class 이름 동일)
 3.2 return type이 없어요. (객체 생성과 동시에 호출) (return 을 받을 대상이 없다.)
 3.3 실행시점 > new를 통해 객체 생성 > heap에서 객체 생성 > member field들이 자리 > 자동으로 생성자 함수가 호출 됨
 3.4 return type(x) >> void >> public void(생략) 클래스 이름 >> public 클래스이름(){}
 
  4. 왜 만들까 : [생성되는 객체]마다 [강제적]으로 member field를 초기화 하고 싶다.
  
  Class Car { String color; }
  >> 설계도를 만든이는 자동차 색상은 니가 알아서 해 (안해도 어쩔 수 없어)
  
  class Car {String color = "blue"}
  >> 객체를 생성하면 무조건 자동차의 blue
  
  문제) 자동차의 색상을 정하지 않고 출고
  설계도를 사용하는 사람이 자동차를 만들때 색상을 넣지 않으면 출고 안되게 하고 싶어요
  >> 생성자 설계 강제하지 않으면 객체 안 만들어 져요
  멤버필드를 원하는 대로 강제할 수 있다!!
  
  5. 생성자 함수는 1개만 만들까 ...?
   	 no
   	 
  6. 생성 함수는 overloading 가능 (강제 구현) ** Today Point
  **** 생성자 함수를 쓰는 가장 중요한 목적은 member field[강제적] 초기화
 
 */

class Car {
	String carname = "포니";
	int ccd=333;
	
	// 생성자 (default constructor) >> 기본 생성자 
	public Car() {
//		int ccc = 222;
//		System.out.println("기본 생성자"+ccc);
		System.out.println("기본 생성자");
		carname = "내마음";
//		System.out.println(carname);
	}
}

class School {
	String schoolName = "강남";
	
	//public School() {}
	//컴파일러가 만약 School 객체 생성할 때 생성자 함수가 없다면
	// 자동으로 생성자 (default) 만들어서 실행
}	
///////////////////////////////////////////////////////////////////
class Car2{
	   String carname;
	   //생성자가 생략되어있음 public Car2(){}
	   
	}

	class Car3{
	   String carname; // default : null
	   public Car3() {
	      this.carname = "포니포니";
	   }
	}

	//이 설계도 Car4는 자동차를 만드는데 있어서 2가지 선택지를 줍니다
	//그냥 만들면 carname이 "기본이름"이지만 문자열을 주면서 만들면 문자열이 carname이 됩니다.

class Car4 {
	String carname;
	public Car4() {
		carname = "기본이름";
	}
	//overloading(함수) >> 생성자 함수 (특수한) >> 생성자 >> overloading 가능
	public Car4(String name) {
		carname = name;
	}
}

//설계의도 : 차 이름 무조건 넣어라 안넣으면 차 없다
class Car5 {
	String carname;
	public Car5(String name) {
		carname = name;
	}
}

class Car6 { // 상품주문서와 비슷한 느낌(overloading 기본 상품 or 옵션추가 기능 구현가능)
	String carcolor;
	int door;
	public Car6() {
		carcolor = "blue";
		door=4;
	}
	public Car6(int num) {
		carcolor = "blue";
		door=num;
	}
	public Car6(String color) {
		carcolor = color;
		door = 4;
	}
	public Car6(int num, String color) {
		carcolor = color;
		door = num;
	}
}

///////////////////////////////////////////////////////////////////

public class Ex13_Constructor { // 상품 옵션과 연관지어서 생각!! 

	public static void main(String[] args) {
		Car car = new Car(); // 이것도 default 생성자 호출한 것임
		System.out.println(car.carname);
//		System.out.println(car.ccc); // 생성자 안에 만든 변수는 호출 x
		System.out.println(car.ccd); // 생성자 밖에 만든 변수는 호출 o

		School school = new School(); // 이것도 (default) 생성자 호출한 것임
		
		
		Car4 car4 = new Car4(); // 기본으로 만들기
		Car4 car41 = new Car4("더존카"); // 이름 설정해서 만들기 
		// this 를 배우기 전까지는 생성자는 무조건 하나만 호출 할 수 있다!!고 알아두기

		

	}

}
