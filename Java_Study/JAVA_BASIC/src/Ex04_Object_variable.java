/*
 클래스 == 설계도 == 데이터 타입
 
 TIP) 
 하나의 물리적인 java 파일에 여러개의 클래스 생성가능 (연습할 때만 .. 실무에서는 X!! )
 원칙적인 방법은 : package > kr.or.kosa.utils.Apt 또는 kr.or.kosa.model.Apt 클래스를 만들어요
 (보통  // 하나의 파일에 대표적인 클래스 하나에만 public 부여)
 
 */

class Apt{	// 설계도 == 데이터 타입(사용자 정의 타입) (작은 타입을 여러개 가지고 있는 큰 타입을 클래스 라고 함)
				// 설계도는 구체화 되지 않으면 종이한장. 의미가 없다!
				// 목적 : Apt 설계도를 가지고 같은 아파트를 무한히 생성하겠다. (memory 에 !) >> new 연산자
				// 생성된 설계도는 필요시 재사용이 가능하다 ( 똑같은 아파트를 무한이 생성 가능)
	String doorColor;
}

public class Ex04_Object_variable { 
	public static void main(String[] args) {  // 하나의 파일에 대표적인 클래스 하나에만 public 부여
		Apt apt; // apt 변수는 Apt 객체의 주소를 담을 수 있는 변수 
		apt = new Apt(); // heap 메모리에 아파트가 한 채 생성되고 생성된 아파트의 주소가 apt변수에 할당
		// apt는 무엇을 가지고 있습니까
		// 참조값 (주소값)
		System.out.println("apt 주소값 : "+apt); // Apt@75a1cd57
		// Apt@75a1cd57
		// Apt(클래스 이름) + @(문자) + 주소값(16진수 값) 결합 된 것이 return
		
		Apt apt2 = new Apt();
		// apt 변수가 가지는 값(주소값)과 apt2가 가지는 주소값은 같을까요, 다를까요? => 다르당
		System.out.println(apt == apt2); // false
		System.out.println(apt + " : " + apt2);
		
		Apt apt3 = apt2;    //주소값 할당
		System.out.println(apt2 == apt3);    // true : apt2 와 apt3 동거를 시작
		System.out.println(apt2 + " : " + apt3); //
		
		int i = 10;
		int j = i ; //값할당
		j = 10000;
		// i 값은 별개다
		
		
	    apt2.doorColor = "red";
	    System.out.println(apt.doorColor); // null
	    System.out.println(apt3.doorColor); // red
	    apt3.doorColor = "blue";
	    System.out.println(apt2.doorColor); // blue
	    // 주소값 할당은 같은 곳을 바라보는 것
	    
		
	    // 동작원리
	    /*
	     * <이클립스  >> ctrl + F11 를 누르면 실행되는 내부 작업들>
	     Ex04_Object_Variable.java >> javac.exe > Ex04_Object_Variable.class (실행파일)
	     > java Ex04_Object_Variable + Enter
	     > JVM 동작  >>  OS  로부터  메모리 받아옴  >> 메모리 (용도에 맞게) 구획정리  >>  각각의 땅에 (자원할당) 메모리 >>  프로그램 종료
	     > 사용했던 메모리는  OS에게 반환 ... END 
	     
	     이클립스  >> ctrl + F11 
	     1. main 함수 실행 ... 반드시 local variable 초기화
	     2. main 시작점이다 ...
	     
	     */
		
	}

}
