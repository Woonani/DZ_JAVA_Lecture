package kr.or.kosa;
/*
	 노트북 클래스 == 설계도 (고유/상태/부품 정보(데이터))
	 노트북은 마우스를 가지고 있다 (부품정보) >> 설계도 1장 주가 >> class Mouse {} >> 데이터 타입
	 마우스는 휠 한개, 버튼 두개, 좌표값 가지고 있다
	
	 class Mouse {
	 	int x;
	 	int y;
	 }
	 
	 노트북은 색상을 가지고 있다
	 노트북은 생산일자를 가지고 있다
 
 */
public class NoteBook {
	//public Mouse mouse = new Mouse(); // 만들면 통합 제품 (라이프 싸이클이 같아요)
	
	// 노트북은 "필요에 따라" 마우스를 가질 수 있다. 
	// 가진다 : 생성된 마우스의 주소값을 가질 수 있다. (heap)
	
	public void handleMouse(Mouse mouse) { // 이 함수를 동작시키면 노트북에 마우스 넣는 것!
		mouse.setX(100);
		mouse.setY(200);
		mouse.getReadMouseData();
	}
	
	
	
	private String color; // "black"
	private int year;
	
	public String getColor() {
		return color + "색상";
	}
	public void setColor(String data) {
		color = data;
	}
	
	//함수 생성 (특수한 목적의 함수 : private member field 간접적으로 read, write)
	public int getYear() { //읽기 전용
		return year;
	}
	public void setYear(int data) { // 쓰기 전용
		if(data<0) {
			year = 1999;
		}else {
			year = data;			
		}
	}
//	public void setYear(int year) { // 쓰기 전용 // this 배우고 나서!
//		this.year = year;
//	}
	
	public void noteBookInfo() {
		System.out.printf("\n 노트북 색상 : %s, 노트북 출시 년도 : %d \n", color, year);
	}
	
	/*
	 객체지향언어 : 캡슐화(은닉화) >> 직접할당을 막고 간접할당을 제어 (정보보호)
	 방법 > 자원을 private이라는 modifier를 통해 막는 방법 뿐! 
	 					(참조변수 입장에서 객체 접근했을 때 자원이 보이지 않으면 ... )
	 					
	  1. 모든 member field 캡슐화
	  2. 직접할당을 막고 간접할당을 통해서 원하는 값으로 제어
	  3. 간접 : 개발자가 직접 논리를 제어하겠다.
	  4. 간접 접근 함수 생성 (write 함수 , read 함수 ) >> read(o), write(o) / read(x), write(o) / read(o), write(x) 다됨
	  
	 */
	
	
	
	
}
