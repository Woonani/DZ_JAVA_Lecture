class Unit2{
	int hitpoint; //기본에너지
	final int MAX_HP; // 최대에너지
	Unit2(int hp){
		this.MAX_HP = hp;
	}
}
//인터페이스
//~ 할 수 있는 (수리할 수 있는)
interface Irepairable{}

//지상유닛
class GroundUnit extends Unit2 {
	GroundUnit(int hp) {
		super(hp);
	}
}
//공중유닛
class AirUnit extends Unit2 {
	AirUnit(int hp){
		super(hp);
	}
}
// 건물
class CommandCener  implements Irepairable{}

// 유닛
class Tank2 extends GroundUnit implements Irepairable {
	Tank2() {
		super(50);
		this.hitpoint = this.MAX_HP;
	}

	@Override
	public String toString() {
		return "Tank2";
	}	
	
}
class Marine2 extends GroundUnit {

	Marine2() {
		super(50);
		this.hitpoint = this.MAX_HP;
	}
	@Override
	public String toString() {
		return "Marine2";
	}
}
// Scv 광물캐기, 수리(탱크)
class Scv extends GroundUnit  implements Irepairable{

	Scv() {
		super(50);
		this.hitpoint = this.MAX_HP;
	}
	@Override
	public String toString() {
		return "Marine2";
	}
	/*
	Scv 구체화, 특수화된 고유한 기능 구현
	 수리하다 (repair)
	 Tank2, Scv, CommandCenter
	
	 전자재품 매장 제품 1000개 >>  buy() >> 100개 buy함수 (X)
	 다형성 buy(Product n) ... 
	 */
	 // GroundUnit에 부모니까 (Tank2, Marine2, Scv)
	// void repair(Unit2 unit) >> class AirUnit extends Unit2(x), Marine2(x)
	// void repair(GroundUnit unit) >> Tank2, Marine(x), Scv 
	
	// CommandCenter repair 서로의 공통점 (연결고리 >> 부모가 같지 않아요)
	// -> 걸리는 게 너무 많음 공통점 찾기가;;
	// 제가 한번 해볼게요
	// interface Irepairable{}
	
	// class CommandCenter implements Irepairable {}
	// class Tank2 extends GroundUnit implements Irepairable {}
	// class Scv extends GroundUnit implements Irepairable {}
	
	// 부모로서 Irepairable을 갖고 있다.
	// 서로 연관성이 없는 자원에 대해서 ... 같은 부모를 ... 제공!
	
	// 다형성
	
	void repair( Irepairable repairunit ) {
		// Tank2, Scv, CommandCenter
		// 수리하는 방법이 달라요
		// Tank2, Scv >> HP 가지고 올려주면 되요
		// 다른 방법으로 repair
		
		// repairunit 일반 Unit2 아니냐 판단해서 적용
		if(repairunit instanceof Unit2) {
			//Tank2, Scv
//			((Unit2) repairunit).hitpoint
			Unit2 unit2 = (Unit2) repairunit; // 인터페이스가 가장 최상위 타입이므로 다운캐스팅 해준다.
			// Irepairable repairunit >> 한단계 낮은 Unit으로 내림
			if(unit2.hitpoint != unit2.MAX_HP) {
				unit2.hitpoint = unit2.MAX_HP; // 완충
			}
		}else {
			// 건물
			System.out.println("다른 충전 방식을 통해서 repair 합니다");
		}
	}
	
}
public class Ex04_Interface_Poly {

	public static void main(String[] args) {
		Tank2 tank = new Tank2();
		Marine2 marine2 = new Marine2();
		Scv scv = new Scv();
		
		CommandCener center = new CommandCener();
		
		// 전투
		tank.hitpoint -= 20;
		System.out.println("탱크 : "+ tank.hitpoint);
		System.out.println("Scv 수리 요청");
		scv.repair(tank);
		System.out.println("탱크 수리 완료 : "+ tank.hitpoint);

	}

}
