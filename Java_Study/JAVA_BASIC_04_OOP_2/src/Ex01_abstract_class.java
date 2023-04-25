/*
 추상 클래스
 >> 미완성 클래스 (설계도)
 1. 완성된 코드 + 미완성 코드
 2. 미완성(함수) >> 실행블럭이 없는 함수 >> public void run()  (X){}  : 추상함수
 3. 미완성된 클래스 (스스로 객체 생성이 불가능)
 
 설계도를 만드는 입장에서 
 >> 미완성 설계도 제작(미완성 함수) >> 의도 >> 믿지 못하니까 >> 강제적 구현을 목적으로 
 
 상속을 기반으로 ...
 */

// 추상클래스 미완성 함수 1개있어야한다. 미완성함수 실행블럭이없는 함수다. 반드시 상속을 통해 재정의할때 의미를 갖는다.


/*  ver1 강제성 없는 코드  */
class Car{
	void run() {} // {블럭만 있으면 객체 생성하고 사용하는 데 문제 없다.}
	// 재정의 했으면 좋겠어... 강제성이 없다
}

class Hcar extends Car{
	// 믿음
	@Override
	void run() {
		System.out.println("재정의 했어요");
	}
}


/*  ver2 의무 반드시 설계도   */
abstract class Abclass{ // 클래스 안에는 최소 1개 이상의 추상함수를 가지고 있겠다.
	int pos; // position
	void run() {
		pos++;
	}
	// 재정의가 필요한 함수를 추상함수로 설계
	abstract void stop(); //실행블럭이 없어요 >> 반드시 상속을 통해서 구현 >> 재정의 
}
// 상속을 통해서 구현
class Child extends Abclass{
	@Override
	void stop() {
		// 구현하는 사람 마음대로....
		this.pos = 0;
		System.out.println("stop : " + this.pos);
	}
}

class Child2 extends Abclass{
	@Override
	void stop() {
		this.pos = -1;
		System.out.println("stop : " + this.pos);
	}
}




public class Ex01_abstract_class {

	public static void main(String[] args) {
		Hcar hc = new Hcar();
		hc.run();
		
//		Abclass ab = new Abclass();// 추상클래스는 생성할 수 없다
		
		Child child = new Child();
		child.run();
		child.run();
		child.stop();
		
		Child2 child2 = new Child2();
		child2.run();
		child2.stop();
		//////////////////////////////////////////
		// 다형성
		Abclass ab = child;
		// 상속관계에서 부모타입의 참조변수가 자식타입 객체 들의 주소를 받을 수 있다. : 다형성
		// 단 부모은 자신의 것만 볼 수 있다. (자식의 프라이버시 중요행)
		// 단 재정의 시 ... 자식의 자원을 본다
		ab.run();
		ab.stop(); // 재정의 된 자식 함수 호출  >> 당연: 부모는 부모꺼만 보지만 자식이 부모물건 빌려가서 쓰면 그것도 볼 수 있는 것!
		
		
	}

}
