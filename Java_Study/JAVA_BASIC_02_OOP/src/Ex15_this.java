/*
 	this (이것)
 	1. 객체 자신을 가리키는 this (앞으로 생성될 객체의 주소를 담을 곳)
 		>> 인스턴스 자신을 가르키는 참조변수 , 인스턴스의 주소가 저장되어있다.
 	2. this 객체 자신 (주소) : 생섯자 호출 (원칙적으로 생성자 객체 생성시 한 개 호출)
 		그런데 this 활용하면 예외적으로 this 통해서 여러개의 생성자를 호출 할 수 있다.
 	
 
 
 */

class Test5{  //  class Test5 extends Object { 생략
	int i;
	int j; // instance
	
	// default constructor
	Test5(){ 
		
	}
	
	// overloading constructor
	Test5(int i, int j){ 
		this.i = i;  // this. 붙여서 나오는 자원은 Test5의 자원
		this.j = j;
//		i = i;
//		j = j;
		
	}
}

class Book2{
	String bookName;
	/*
	Book2(String name){
		bookName = name; // 코드좀 이쁘게 >> 가독성
	}
	 */
	Book2(String bookName){
		this.bookName = bookName;  // 가독성
	}
}

// Today Point
// 생성자를 호출하는 this (중복코드 감소 ...)

class Socar{
	String color; 
	String gearType;
	int door;
	
	Socar(){ // 기본 설정
		this.color = "red";
		this.gearType = "auto";
		this.door = 2;
	}
	Socar(String color, String gearType, int door){ // 기본 설정
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	void socarPrint() {
		System.out.println(this.color + " , " + this.gearType + " , " +this.door );
	}
	
}



public class Ex15_this {

	public static void main(String[] args) {
		Test5 test5 = new Test5(10,20);
		
		Socar socar = new Socar(); // 매장가서 기본차량 주세요
		socar.socarPrint();
		
		Socar socar2 = new Socar("gold", "auto", 6); 
		socar2.socarPrint();
	}

}
