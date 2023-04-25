class Human2{
	String name;
	int age;
}
class Test3{
	Human2 add(Human2 h) {
		// return h;
		 
		Human2 man = h;
		man.name = "아무개";
		man.age = 100;
		return man;
		/*
		return null; // 주소를 가지고 있지 않아
		 */
	}
	Human2 add(Human2 h, Human2 h2) {
//		return null;
		h2.name = h.name;
		h2.age = h.age;
		return h2;
	}
}
public class Ex12_Method_Overloading {

	public static void main(String[] args) {
		Test3 t3 = new Test3();
		
		Human2 man = new Human2(); // man 0x123번지
		Human2 man2 = t3.add(man);  // 0x123번지
		System.out.println(man == man2);

	}

}
