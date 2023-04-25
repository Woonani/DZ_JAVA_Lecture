package kr.or.kosa;
/*
 
public class Airplane {
	private int airNum; // 캡슐화
	private String airName; 
	private static int airTotalCount;  // 모든 객체가 공유하는 자원 but private하므로 "airplane."으로 접근 못함!
	
	// 클래스 내에서는 접근자가 무의미 하기 떄문에 
	public void makeAirplane(int num, String name) { // 생정자 배우기 전..
		airNum = num;  // this 배우기전..
		airName = name;
		airTotalCount++; // airtotalcount 누적대수 // 메모리 : class area 쪽
		airDisplay();
	};
	
	private void airDisplay() { // 클래스 내부에서 사용되느 함수 처럼 (private 함수)
		System.out.printf("번호 : [%d] , 이름 : [%s] \n", airNum, airName);
	};
	public void airTotal() { // 클래스 내부에서 사용되느 함수 처럼 (private 함수)
		System.out.printf("총 비행기 제작 대수 : %d 대 \n", airTotalCount);
	};

// 내 코드
//	private String airName;
//	private int airNo;
//	static int airCount;
//	
//	public void count() { // 뱅기 대수 추가
//		airCount ++;
//		System.out.println("뱅기생성");
//	};
//	
//	public int getAirNo() {
//		return airNo;
//	}
//	public void setAirNo(int airNo) { // 뱅기 이름 부여
//		this.airNo = airNo;
//	}
//	public String getAirName() {
//		return airName;
//	}
//	public void setAirName(String airName) { // 뱅기 번호 부여
//		this.airName = airName;
//	}
//	
//	public void airInfo() {
//		System.out.printf("뱅기이름 : %s 뱅기번호 : %d \n", airName, airNo); // 뱅기이름번호 출력
//	}
//	
//	public void totalAirInfo() {
//		System.out.println("누적 뱅기 "+ airCount +" 대"); // 뱅기 누적대수 확인
//	}
	
	
}
 */

//-----------------------------------------------------------------------------------//

/*
우리 회사는 비행기를 주문 제작 판매 하는 회사입니다
우리 회사는 비행기를 생산하는 설계도를 만들려고 합니다

요구사항
1. 비행기를 생산하고 비행기의 이름과 번호를 부여해야 한다
2. 비행기가 생산되면 비행기의 이름과 번호가 맞게 부여되었는지 확인 하는 작업이 필요하다(출력) -> 기능
3. 공장장은 현재까지 만들어진 비행기의 총 누적대수를 확인 할 수 있다  -> 기능 

 AirPlane air101 = new AirPlane();
 air101.자원 = 대한항공
 air101.자원 = 707
  
 비행기 이름, 번호 출력
  
 생성자 사용금지 >> 배운 다음에 사용  >> 생성자를 써야 코드가 이뻐져요 
 */

//현재까지 배운 것만 가지고 만들어요
public class Airplane {
	private int airnum; //캡슐화
	private String airname;
	private static int airtotalcount; //모든 객체가 공유하는 자원
	
	/*
	public Airplane(int num , String name) { //this 안배워서 변수면 안이뻐요 
		airnum = num;  
		airname = name;
		airtotalcount++;  //airtotalcount 누적대수
//		AirDisplay();	 생성자는 함수 호출 못함
	}
	 */
	// 위에꺼 고침
	public Airplane(int airnum, String airname) {
		this.airnum = airnum;
		this.airname = airname;
		airtotalcount++;
	}
	
	public void airDisplay() {  //클래스 내부에서 사용되는 함수 처럼 (private 함수)
		System.out.printf("번호[%d] , 이름[%s] \n",airnum, airname);
	}
	
	public void airPlaneTotalCount() {
		System.out.printf("총 비행기 제작 대수 : [%d] \n",airtotalcount );
	}
}

