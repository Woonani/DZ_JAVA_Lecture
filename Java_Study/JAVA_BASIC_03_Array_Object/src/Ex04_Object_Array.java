

class Person{
	String name;
	int age;
	
	//만약 사람을 만들 때 이름, 나이 강제 하고 싶으면
	//Person(){}
//	Person(String name, int age){this.name = name; 	this.age = age;	}
	void print() {
		System.out.println(this.name + " : "+ this.age);
	}
}

public class Ex04_Object_Array {

	public static void main(String[] args) {
		int[] intarr = new int[10];
		boolean[] boolarr = new boolean[5];// false (default)
//		int[] arr9= {};
		Person p = new Person(); // local 참조 변수 p >> p라는 변수는 주소값을 가진다
		p.name = "홍길동";
		p.age = 100;
		
		// Person 타입의 사람 세 명을 만드세요
		// heap 객체를 3개 
		Person p2 = new Person();
		Person p3 = new Person();
		Person p4 = new Person();
		
		// int i , int j , int k
		Person[] persons = new Person[3]; // 방만 만들고 방에 아무도 살지 않아요. Person타입이 오는 방
		System.out.println(persons);
		System.out.println(persons[0]);
		System.out.println(persons[1]);
		System.out.println(persons[2]);
		
		//방이 비워져 있어요
		persons[0] = new Person(); // 방은 주소값을 갖는다.
		
		Person p5 = new Person();
		persons[1] = p5;
		
		persons[2] = new Person();
		
		persons[2].name="김유신";
		persons[2].age = 100;
		
		System.out.println(persons[2].name);
		System.out.println(persons[2].age);
		
		//초급자
		// 객체 배열은 방을 만드는 것과 방을 채우는 작업은 별개다.*********************************
		
		// 객체배열은 ... [ 1) 방을 만드는 것과 2) 방 주소 채우는 것 ] 두 가지 작업이 필요하다. 
		
		// 객체 배열 3가지 방법 ...
		//1. int[] arr = new int[10]
		Person[] parray = new Person[10]; // 방만 만들었어요
//		for(Person i : parray) {
		for(int i = 0; i < parray.length; i++) {
			parray[i] = new Person();
			System.out.println("주소값 : " +  parray[i]);
		}
		/*
		 주소값 : Person@5e91993f
		 주소값 : Person@1c4af82c
		 주소값 : Person@379619aa
		 주소값 : Person@cac736f
		 주소값 : Person@5e265ba4
		 주소값 : Person@156643d4
		 주소값 : Person@123a439b
		 주소값 : Person@7de26db8
		 주소값 : Person@1175e2db
		 주소값 : Person@36aa7bc2
		 */
		
		// 2. int[] arr = new int[]{10,20,30} 
		Person[] parray2 = new Person[] {new Person(), new Person(), new Person()};
		
		// 3. int[] arr = {10,20,30} 
		Person[] parray3 = {new Person(), new Person(), new Person()};
	}

}
