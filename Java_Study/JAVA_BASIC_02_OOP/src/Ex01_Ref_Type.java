import kr.or.kosa.Person;

// 연습용으로 TEST 
class Test{ //default class Test(자동으로 default 지정)
	int i; // default int i
	int j; 
	void print() { // default void print()
		System.out.println(i);
	}
	
	
}

public class Ex01_Ref_Type {

	public static void main(String[] args) {
		
		Person person = new Person();
		person.personPrint();
		
		Person person1 = new Person(); // 사람 1명
		person1.name = "김유신";
		person1.age = 100;
		person1.power = true;
		person1.personPrint();
		
		System.out.println(person); // 주소값 출력 (참조값) 참조타입 kr.or.kosa.Person@6e8dacdf
		System.out.println(person1); // kr.or.kosa.Person@7a79be86
		

	}

}
