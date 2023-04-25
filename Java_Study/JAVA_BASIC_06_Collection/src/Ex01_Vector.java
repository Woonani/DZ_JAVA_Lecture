import java.util.Vector;

/*
 Collection FrameWork
 [다수의 데이터]를 다루는 [표준화된 인터페이스]를 구현하고 있는 [클래스의 집합]을 공부!
 
 Collection 인터페이스 >> 상속 List >> 구현 ArrayList
 Collection 인터페이스 >> 상속 Set >> 구현 HashSet
 
 * ArrayList의 부모타입은 List 이다 (o)>> 다형성
 * Collection 인터페이스는 ArrayList의 부모타입이다 (o)
 * instanceof 검증
 
 * Map 인터페이스 (key, value) 쌍의 배열 >> 구현 HashMap
  
 1. List (줄을서시오)
 순서가 있는 데이터 집합(번호표) ... 중복허용 >> 순서(0), 중복(0) 데이터 집합
 >> Tip) Array 관리 O >> [홍길동][홍길동][홍길동][][] >> [0] 번째 방 ...
 array 단점 : 한번 정해진 배열의 크기를 변경 할 수 없다
 
 1.1 Vector    (구버전) -> 동기화 보장 (o) >> Lock default
 				Vector (화장실) -> 멀티 스레드 환경(Lock) -> 성능(x), 보안(o)
 1.2 ArrayList (신버전) -> 동기화 보장 (x) >> Lock option
 				ArrayList (비빔밥) -> 멀티 스레드 환경(Lock) -> 성능(o), 보안(o)
 Vector 유지보수,  학습용
 ArrayList 활용
 
 ------------------------------------------------------------------------
 다수의 데이터를 다루는 방법 (Array >> 정적, 고정 
 ****** Point 방의 개수가 한번 정해지면 (방의 크기는 변경불가)
  1. int[] arr = new int[3];
  2. int[] arr = new int[]{1,2,3};
  3. int[] arr = {10,20,30};
  arr3 놀고 있는데 데이터가 100건이 추가
  int[] arr4 = new int[100];
  *******새로운 배열 생성하고 데이터 이동 (코드로 직접 개발자 구현)
  
  Array
  1. 배열의 크기가 고정 : Car[] cars = {new Car(), new Car()} 2개
  2. 접근방법 (index) >> cars[0] ,,, n(length-1)
  
   List 인터페이스를 구현하고 있는 ArrayList, Vector는 
   1. 배열의 크기가 동적으로 확장 or 축소 가능 >> 진실은 ***컴파일러가 새로운 배열을 만들고 데이터 이동 ,,,
   2. 순서를 유지(내부적으로 Array) 사용, 중복값 허용
   3. 중복값 허용 (index 를 통해서 제어)
   
 
 */
public class Ex01_Vector {

	public static void main(String[] args) {
		Vector v = new Vector();
		System.out.println("초기용량 : "+v.capacity()); //공간이 10칸 : 10개짜리 정적배열 생성
		System.out.println("size(값의 크기(개수)) :  "+ v.size()); // 값이 0개 들어있음
		
		v.add("AA"); // 순서 [0]
		v.add("BB"); // 순서 [1]
		v.add("CC"); // 순서 [2]
		v.add(10);
		System.out.println("size(값의 크기(개수)) :  "+ v.size()); // 값이 4개
		System.out.println(v.toString()); //[AA, BB, CC, 10] 재정의 함 
		// Array >> 배열의 개수 >> length() >> 방의 개수
		// Collection >> size() >> 값의 개수 >> 객체라서 함수 적용 >> get(0)함수 써야함
		for(int i =0; i<v.size(); i++) {
			System.out.println(v.get(i)); // get(indext) return 배열 값이
		}
		//개선된 for문 출력 
		for(Object obj : v) {
			System.out.println(obj);
		}
		
		// 단점 : 작은 데이터 (같은 타입의 데이커) >>> 가장 큰 타입을 사용해서 얻는 것이 불합리
		// 제너릭 >> 타입을 강제 >> POINT
		Vector<String> v2 = new Vector<String>();
		v2.add("hello");
		v2.add("world");
		for(String a: v2) {
			System.out.println(a);
		}
		
		Vector v3 = new Vector<>();
		System.out.println(v3.capacity()); // 방 10개 생성 :  Object[] obj = new Object[10]; 동작
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A"); // 11번째 
		System.out.println(v3.toString()); 
		System.out.println(v3.capacity()); // 방 20개 생성됨
		
		// 그냥 편하게 쓰세요 (동적 늘어나고 줄어요) >> 새로운 배열을 만들고 이사 시키는 작업이 자동으로 됨
		
		
		
		
	}

}
