import kr.or.kosa.Pclass;

/*
 private
 default : 같은 폴더(패키지)
 public 
 상속관계에서 protected : 상속이 있어야만 의미가 있는 접근자
 
 protected 양면성 >> default, public 
 >> 상속이 없는 클래스 안에서 protected >> default 동일
 >> 결국 상속관계에서만 의미 >> public 
 
 */

class Dclass {
	public int j;
	private int p;
	int s; //default 
	protected int k;
}

class Child2 extends Pclass{ // 상속
	void method() {
		this.k = 100; // 노란색 protected
		// 상속관계에서 >> 자식은 부모의 protected 자원을 사용가능(public)// protected 사용의도 : 재정의를 했으면 좋겠어..
		System.out.println(this.k);
		// m(); 접근 자식 안에서 가능
		
	}
	// protected 진정한 의미 : 재정의를 했으면 좋겠는데.. 재정의해거 써 그럼
	@Override // 상속관계에서는 쓸 수 있지만 참조변수 관계에서는 못 씀 //그래서 아래 main함수 안에서 m();이 안보이는 것임
	protected void m() { // protected는 함수 재정의에 관해 약간의 강제성을 띤다고 볼수있다.
		// TODO Auto-generated method stub
		super.m();
	}
}

public class Ex08_Inheritance_Protected {

	public static void main(String[] args) {
		Pclass pclass = new Pclass();
//		pclass.i public만 접근

		Dclass dclass = new Dclass();
		
		Child2 child = new Child2();
//		child.

	}

}
