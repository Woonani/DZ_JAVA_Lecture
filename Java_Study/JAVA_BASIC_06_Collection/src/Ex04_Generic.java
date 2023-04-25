import java.util.ArrayList;
import java.util.List;

// 교재 13장
/*
 Today Point
 jdk 1.5버전
 
 C#, JAVA(필수기능)
 
 1. 타입을 처음 부터 강제
 2. 타입 안정성 (타입 강제)
 3. 강제 형변환 필요 없다. ex) (Car) Object 필요없다
 
 */
// 설계도를 만들때
class MyGeneric<T>{ // Type parameter
	T obj;
	
	void add(T obj) {
		this.obj = obj;
	}
	T get() {
		return this.obj;
	}
} // 타입을 잡아줄 수 있다

class Person{
	int age = 100;
}

public class Ex04_Generic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyGeneric<String> mygen=new MyGeneric<String>();
		/*
		 class MyGeneric<String>{ 
			String obj;
			
			void add(String obj) {
				this.obj = obj;
			}
			String get() {
				return this.obj;
			}
		 }

		 */
		mygen.add("문자열");
		String str = mygen.get();
		System.out.println(str);
		
		ArrayList<String> list = new ArrayList<>();
		list.add("문자열");
		
		//--------------------------------------------
		// 불편함을 느껴보자
		ArrayList list2 = new ArrayList();
		list2.add(10); //int
		list2.add("홍길동"); // String
		list2.add(new Person()); // 객체
		//개선된 for문 사용해서 Person 객체는 age 값을 출력하고 나머지는 값을 출력
		
		for(Object p : list2) {
//			System.out.println(p); //10 , 홍길동 , Person@1c4af82c age가 안나옴
			if(p instanceof Person) {
				Person j = (Person) p;
				System.out.println(j.age); //Person age : 100
			}else {
				System.out.println(p); //10 , 홍길동 
			}
		}
		
		//제너릭 사용시--------------------------------------------
		List<Person> plist = new ArrayList<>();
		plist.add(new Person());
		plist.add(new Person());
		for(Person p : plist) {
			System.out.println(p.age);
		}
		
		
	}

}
