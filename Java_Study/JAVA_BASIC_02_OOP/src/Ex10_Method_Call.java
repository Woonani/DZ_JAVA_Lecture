/*
 함수 사용시 parameter 값을 전달 or 주소값 (참조값) ref 전달
 void m(int x) { x라는 변수는 값을 받는다
 	x값 출력 : 100
 	x = 10000; 
 } 
 
 int y = 100;
 호출 m(y)
 
 call by value
 -----------------------------------------------------
 void m2 (Car c) {  // c라는 parameter는 Car 타입을 가지는 객체의 [주소값]을 받겠다
 	c.color 출력 : red
 }
 
 Car c2 = new Car(); //c2의 주소가 : 0xab..
 c2.color = "red";
 
 m2(c2) >> m2(0xab...)
 
 call by ref
 */
class Data {
	int i;
}

public class Ex10_Method_Call {

	static void scall(Data sdata) { // Data 타입을 갖는 주소값을 받겠다 (ref)
		System.out.println("함수 : " + sdata.i);
		sdata.i = 1111; //0xaaa번지에 있는 i 라는 변수값을 1111변경
	}
	
	static void vcall (int x) { // 정수값을 받겠다(value)
		System.out.println("before x : " + x);
		x = 8888;
		System.out.println("after x : " + x);
	}
	
	public static void main(String[] args) {
		
		Data d = new Data(); //d변수는 주소값 0xab 번지
		d.i = 100;
		System.out.println("d.i : " + d.i);

		scall(d); //0xab ; 주소값전달
		System.out.println("d.i : " + d.i);
		//////////////////////////////////////////////////////
		
		vcall(d.i); //1111 ; 값전달
		System.out.println("d.i : " + d.i);
		
	}

}
