import kr.or.kosa.Bird;

class Bi extends Bird {
	@Override
	protected void moveFast() {
		super.moveFast();
	}
}

class Ostrich extends Bird {
	// Ostrich
	// 특수화, 구체화
	void run() {
		System.out.println("run .....");
	}
	@Override
	protected void moveFast() { // 함수명을 같이 쓰면서 기능은 재정의 가능하다!
		run();
	}
}

public class Ex09_Inherit_Protected {

	public static void main(String[] args) {
		Bi bi= new Bi();
		bi.fly();
		bi.moveFast();
		
		Ostrich o = new Ostrich();
		o.fly();
		o.moveFast();

	}

}
