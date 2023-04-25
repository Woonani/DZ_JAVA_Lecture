import kr.or.kosa.Emp;

class Test2{
	int x = 100;
	void print() {
		System.out.println("부모함수 Test2");
	}
}
class Test3 extends Test2{
	int x= 300;	// C# 부모 무시하기 (쓰지 마세요)
	
	// 재정의 
	@Override
	void print() { // 이것은 오버라이딩
		// 이러고 끝해도 오류 안남! 함수명 같고, 리턴타입 같아서!
		System.out.println("자식이 부모의 함수를 재정의");
	}
	
	void print(String str) { // 이것은 Overloading!
		System.out.println("나 오버로딩이야 " + str);
	}
}
public class Ex05_Inheritance_Override {

	public static void main(String[] args) {
		Test3 test3 = new Test3();
		System.out.println(test3.x);
		test3.print();
//		test3.print("Overloadign");//
		
		Emp emp = new Emp(1000, "홍길동");
		System.out.println(emp); //emp.toString() 생략
		//kr.or.kosa.Emp@1c4af82c 
		//kr.or.kosa.Emp + "@"  + 1c4af82c  조합된 값
		System.out.println(emp.toString()); //kr.or.kosa.Emp@1c4af82c
		
		/*
		  class Object {
		  	public String toString(){
		  		return 패키지명 + "@" + 주소값 
		  	}
		  } 
		  
		  class Emp extends Object {
		  
		  } 
		  
		 */
	}

	
	

}
