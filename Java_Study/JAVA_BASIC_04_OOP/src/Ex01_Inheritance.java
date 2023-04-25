/*
 OOP 특징 (여러개의 조각(작은)(클래스) 들을 조립해서 하나의 큰 그림(제품)을 만드는 행위)
 설계도 : 메인 설계도의 부분 설계도, 메인 설계도의 하위 설계도, 별도 독립적인 설계도...
 
 1. 상속
 2. 캡슐화(은닉화) >> private 
 3. 다형성 (상속관계에서 부모 타입이 자식 타입의 주소를 가질 수 있다.)
 
 상속
 JAVA : child extends Base // Base(부모)에서 확장함
 C#   : child : Base
 
 특징
 1. 다중 상속 불가 (단일 상속 원칙 >> 계층적 상속)
 2. 계층적 상속(여러개의 클래스를 상속)
 3. 다중 상속 지원은 interface 만 [표준, 약속, 규칙, 규약]을 정의하고 있는 클래스 // 신발만들때 5mm 단위로 만든다~ 뭐 이런 규칙이 interface 같은거래
 
 상속
 1. 진정한 의미 : 재사용성
 2. 단점 : 비용 (초기 설계 비용)			... 부모 자식 관계 (커플링) (종속성이 너무크다?)>> 요즘 트렌드는 느슨한 관계를 좋아함
 3. 재사용성 >> 설계 >> 시간 >> ....재사용성 높아져서 ...
 
 
 모든 클래스는 메모리에 올라가야 사용가능하다
 
 Child child = new Child();

 Child > Father > GrandFather // X
 실제 메모리에 올라가는 순서 
 Object >> GrandFather >> Father >> Child
 
 사용자가 만드는 모든 클래스는 default (명시하지 않아도) : Object 상속한다
 class Car extends Object 생략
 Object  >> Root >> 최상위 >> 모든클래스의 부모 클래스 >> 단군?
 
 */
class Car{ // Car extends Object
	
}

class GrandFather {
	public int gmoney = 5000;
	private int pmoney = 10000; // 상속관계에서 접근 불가... 무덤까지 가져가는 돈
								// public 함수 생성 (간접적으로 접근 하면 ...)
	// 객체생성과 동시에 호출되는 함수 (생성자)
	public GrandFather(){
		System.out.println("GrandFather 생성자");
	}
	public int getPmoney() {
		return pmoney;
	}
	
}

class Father extends GrandFather {
	public int fmoney = 3000;
	public Father(){
		System.out.println("Father 생성자");
	}
	
}

class Child extends Father {
	public int cmoney = 100;
	public Child(){
		System.out.println("Child 생성자");
	}
	
}

public class Ex01_Inheritance {

	public static void main(String[] args) {
		Child child = new Child();
		System.out.println(child.gmoney);
		System.out.println(child.fmoney);
		System.out.println(child.cmoney);
		
		//child.pmoney; // 상속관계라도 접근 불가 The field GrandFather.pmoney is not visible
		child.getPmoney();

	}

}
