package kr.or.kosa;
/*
 class == 설계도 == 데이터 타입(사용자 정의 타입)
 
 설계도(종이) >> 구체화 (메모리) 올리는 행위  >> 구체화된 자원  >  객체 (Object), instance
 
 설계도 : field(고유, 상태, 부품(더 나누어질 수 있다)) + method(기능, 행위) + constructor(생성자 함수)
 
 
 
 */
public class Person { // public  : "다른 패키지(폴더) 에서도 사용할 수 있게 하겠다!"
	// 객체 변수들은 생성되는 객체마다 다른 값을 가질 수 있다.
	// default 값 (자동)으로 가짐
	public String name; // default 값 : null
	public int age;	// default 값 : 0
	public boolean power; // default 값 : false
	
	// method
	public void personPrint() {
		System.out.printf("이름은 %s 나이는 %d 파워는 %s 입니다. \n", name, age, power);
	}
	
	// member field, instance variable >> 객체변수 >> 주소값을 갖고있는 변수(메모리를 찾아갈 수 있는 변수)
	
	/*
	 1. instance variable 초기화 하지 않아도 된다 >> why >> default 값
	 변수가 처음으로 값을 할당 받는 것 >> 초기화 
	 
	 2. age member field 초기화 하고 싶어요 : public int age = 1;
	 필요하다면 당근 초기화 가능 : public int age = 1; 모든 객체는 age가 1
	 
	 Today Point : why 초기화 잘 하지 않을까 (만약 초기화 하고 싶으면 static이나 final을 사용)
	 생성되는 객체마다 (사람마다) 다른 나이를 가지고 있지 않을까~라는 관점때문에
	 
	 
	 
	 
	 
	 */

}
