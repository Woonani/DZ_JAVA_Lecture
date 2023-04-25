// 두개의 설계도

class Tv{
	boolean power;
	int ch;
	
	void power() { // 두개의 기능을 하나의 함수 처리
		// boolean 
		this.power = !this.power; // 토글링!? : 전원 스위치
		
	}
	void chUp() {
		this.ch++;
	}
	void chDown() {
		this.ch--;
	}
}

class Vcr{	//비디오 플레이어
	boolean power;
	void power() {
		this.power = !this.power;
	}
	void play() {
		System.out.println("재생하기");
		
	}
	void stop() {
		System.out.println("정지하기");
	}
	void rew() {}
	void ff() {}
}

//설계도 2개
	/*
	 class Tv
	 class Vcr
	 
	 제품
	 Tv 와 Vcr 기능이 합쳐진 제품 TvVcr 출시
	 
	 class TvVcr extends Tv, Vcr (x) 다중상속 금지
	 >> 계층적 상속 ( 할아버지, 아버지 계층 구조,,, 자원이름 같아요 ,,, 사용불가 )
	 
	 한놈은 상속하고 한놈은 포함
	 둘다 포함 
	 1) class TvVcr (){ Tv tv; 	Vcr vcr; }
	 2) class TvVcr extends Tv (){ Vcr vcr;	 } // 일반적으로 많이씀 
	 TvVcr 메인 기능 .... (비중)
	 
	 */
class TvVcr{
	Tv tv;
	Vcr vcr;
	
	TvVcr(){
		this.tv = new Tv(); // 초기화 (주소값 할당)
		this.vcr = new Vcr();
	}
}	
class TvVcr2 extends Tv{ // 일반적으로 많이씀 
	// 부모 객치 먼저 생성 (생성자 함수로 생성시) 변수2개[] [] 매서드3개()()()
	// 자신 객체 생성
	Vcr vcr; // 변수 생성
	TvVcr2(){ 
		this.vcr = new Vcr(); // Vcr 생성
	}
}	

public class Ex03_Inheritance {

	public static void main(String[] args) {
		TvVcr my = new TvVcr();
		my.tv.power();
		my.vcr.power();
		System.out.println(my.tv.power);
		System.out.println(my.vcr.power);
		//----------------------------------
		
		TvVcr2 tv2 = new TvVcr2();
		tv2.power();
		System.out.println("Tv전원 : " + tv2.power);
		
		tv2.vcr.power();
		System.out.println("VCR전원 : " + tv2.vcr.power);
		
		
	}

}
