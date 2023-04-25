package kr.or.kosa;
/*
 기능 (행위) 만드는 방법
 method 만드는 방법(문법)
 
 method : 행위 또는 기능의 최소단위 구현 : [하나의 함수]는 [하나의 기능]만 구현
 ex) 먹는기능, 자는기능
 
 ex) 롯데월드 : 게임방 : 동전(농구), 동전뽑기 (포켓몬)
 
 ** 모든 함수는 호출에 의해서만 동작한다 **
 누군가 이름을 부르지 않으면 동작하지 않는다
 
 JAVA) 함수 만드는 문법 4가지
 1. void, parameter(o) : public void print (String str) { 실행구문 } : str이라는 동전을 넣으면 실행되는 게임 
 2. void, parameter(x) : public void print () { 실행구문 } : 인수를 넣지 않아도 실행되는 공짜 게임
 3. return type, parameter(o) : public int print (int data) { 실행구문 return 100;} 
		: data라는 동전을 넣으면 100이 나오는 게임  
 4. return type, parameter(x) : public int print ( ) { 실행구문 return 100;} 
		: 인수 넣지 않아도 실행되고 100이 나오는 게임
		
  void  > 돌려주는 것이 없어요 > return type 없어요
  return type >> 8가지 기본 + 1(String), Array, class, interface, Collection(일종의 배열..?)
  일단 이 중에서 8가지 + String + class  학습할 예정
  
  예1) public boolean print() { return true; }
  예2) Car print() { return Car주소값 } 
   		Car print() { return new Car(); }
  		Car print() { Car car =  new Car();  return car; }
  예3) String print() {return "AAA"; }
  
  parameter type >> void print(String 변수)
  parameter type >> 8가지 기본 +1(String), Array, class, interface, Collection
  
  예4) void print(int i){  } >> 호출 print(100);
  예5) void print(String str) {} >> 호출 print("이예진");
  예6) void print(Car c) {} >> 호출 > Car c1 = new Car() print(c1); .... print(new Car());
  
  void print2(int a, int b, int c) { } // 나는 무조건 실행할 때 3개 parameter 받겠다 강제
 
  print2(10); (X)
  print2(10, 20); (X)
  print2(10, 20, "30"); (X) // 인수 개수와 타입 모두 맞춰줘야 함
  print2(10, 20, 30); (O)
  
  함수의 이름 :  관용적		
  class Car, class Person
  
  메서드 : getNumber();
  
  사원테이블에서 사원의 모든 정보를 가지고 오는 함수를 만들어라
  void getEmpAllList()
  
  사원테이블에서 사원의 번호를 사지고 사원의 모든 정보를 가지고 오는 함수를 만들어라
  void getEmpListByEmpno() // 길게 써도 되니까 함수 용도파악이 쉽도록 함수명 작성!!
 */
public class Fclass {
	public int data;
	// int data; // default 로 지정되어서 다른 package에서 사용 못함!
	
	// void m() >> 컴파일러가 자동으로 >> default void m() >> 같은 폴더(package)내에서만 사용
	
	// 함수의 접근자 (수정자) : 70% public
	// 함수의 30%는 private   : class 내부에서는 public, private 의미없음. 다 같은 식구일 뿐
	
	// 클래스 내부에서 사용해라 >> 이런함수 >> 다른 함수를 도와주는 함수 (공통함수)
	
	public void m() { // void, parameter(x)
		// 기능 구현
		System.out.println("일반함수 : void, parameter(x)");
	}
	
	public void m2(int i) { // void, parameter(o)
		// 기능 구현
		System.out.println("일반함수 : void, parameter(x)");
		System.out.println("parameter 값을 활용 : "+ i);
	}
	
	public int m3() { // return, parameter(x)
		// 강제로 리턴 구현
		return 10000;
	}
	
	public int m4(int data) {// return, parameter(o)
		return 100+data;
	}
	// 요기까지 가장 기본적인 함수 4가지
	// 확장
	
	//return type(0), parameter (0) 개수 .....
	public int sum(int i, int j, int k) {
		return i + j + k;
	}
	
	// 함수의 접근자(수정자) 한정자
	// int sum();    >>    컴파일러가     >>    default int sum();
	// private int sum() >> 객체입장에서 접근 불가 >> 같은 클래스 안에서 접근 가능
	// 클래스 내부에서 다른 함수를 도와주는 공통함수 
	
	private int subSum(int i ) {
		return i+ 100;
	}
	//Fclass fclass = new Fclass();
	//fclass 보이지 않아요
	
	public void callSubSum() {
		int result = subSum(100);  // private함수의 용도!!!!!!!!!!!!!!!!!!아하~!!!!!!!!!!!!!!!!!!!!!
		System.out.println("call resut : " + result);
	}
	
	public int opSum(int data) {
		// 다양한 로직 (제어문)
		int result = subSum(data);
		// 제어
		if(result > 0) {
			return 1;
		} else {
			return -1;
		}
	}
	
	// Quiz
	/*
	 함수를 생성하는데
	 정수타입의 parameter 2개를 받아서 둘 중에 큰값을 리턴하는 함수를 만드세요
	 ex) max(10, 5) return 10이 반환되면 됩니다.
	 */
	
	// 90점!! 60점 아니야??? >>> 무의미하게변수에 담지 말자!
	//	public int max (int data1, int data2) {
	//		int result;
	//		if(data1 >= data2) {
	//			result = data1;
	//		}else {
	//			result = data2;
	//		}
	//		return result;
	//	}
	
	// 100점 짜리 답 (리턴 최소화, 짧게, 불필요한 변수 할당 X) 이거시 바로 좋은 코드 좋코!
	public int max(int a, int b) {
		return (a>b) ? a:b;
	}

	
}
