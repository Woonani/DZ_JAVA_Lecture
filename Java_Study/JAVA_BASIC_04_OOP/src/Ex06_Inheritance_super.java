import java.lang.reflect.Method;

/*
객체 한개만 가지고 놀때는
this : 객체 자신을 가르키는 this (this.emno , this.ename)
this : 생성자를 호출하는 this ( this(100,"red"))

상속관계
부모 , 자식 

super(상속관계에서 자식이 부모의 자원 접근 하는 주소제공) : 상속관계에서 부모에 접근 (super)

1. super : 상속관계에서 부모자원에 접근
2. super : 상속관계에서 부모의 생성자를 호출

Tip)
C# : base()
JAVA : super()

 */
class Base{
	String basename;
	Base(){
		System.out.println("부모 클래스 기본 생성자");
	}
	Base(String basename){
		this.basename = basename;
		System.out.println("basename : " + this.basename);
	}
	void method() {
		System.out.println("부모 method");
	}
}

class Derived extends Base {
	String dname;
	Derived() { // 생성자
		System.out.println("자식 클래스 기본 생성자");
	}
	Derived(String dname){
		
		// 부모 생성자 호출 (super)
		super(dname); //부모도 생성자 호출 > super 없으면 기본 생성자만 호출됨!!!!!!!!!!!!!!!!!!
		
		this.dname= dname;
		System.out.println("dname : " + dname);
		
		}
	
	
//@Override 생성법 : 
	//1. 마우스로 source > override
	//2. me(부모 메소드명 일부)+ctrl+space로도 가능

		@Override
	void method() {
		System.out.println("부모함수 재정의");
//		super.method(); // 부모 자원을 사용하고 싶다면 1
	}

	void pMethod() { // 부모 자원을 사용하고 싶다면 2 
		// 자식객체의 함수안에서 super 사용
		super.method(); // super는 부모 객체로 찾아가는 주소
//		String pname = super.basename;
//		System.out.println("부모 변수가 basename1 : "+basename);
//		System.out.println("부모 변수가 basename2 : "+super.basename);
	}

}



// 상속관계에서는 부모번저 생성
public class Ex06_Inheritance_super {

	public static void main(String[] args) {
		//Derived d = new Derived(); // 상속관계에서는 부모번저 생성 :  부모 출력 찍힌 후 자식 출력 찍힘
		
		Derived d = new Derived ("홍길동"); // 오버로딩 생성자를 부름 > 부모쪽에도 "홍길동"이 전달될까? > x
		// 만약 부모의 생성자도 호출하고 싶다면? (super)
		d.method(); //재정의가 되면 부모 자원 접근 불가
		
		// 부모가 그리워서
		d.pMethod();

//		Q 왜 인스턴스 변수, 로컬변수
//		d.basename; //Syntax error, insert "VariableDeclarators" to complete LocalVariableDeclaration
		//지역변수 선언 되고, 출력하면 나옴! 멤버 필드에서도 선언 안됨... 뭐지? 
		System.out.println(d.basename);
		String a = d.basename;
		System.out.println(a);

	}

}
