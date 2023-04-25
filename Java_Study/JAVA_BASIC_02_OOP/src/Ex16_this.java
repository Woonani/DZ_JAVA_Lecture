/*
 원칙 : 객체를 생성할 때 생성자는 1개만 호출가능(new Zcar() , new Zcar(10))
 
 this >> 객체 자신
 
 Zcar() {}  >> this(){}  // 양쪽 동일
class Zcar{
	String color;
	String gearType;
	int door;
	
	Zcar(){ //기본 설정
		this.color = "red";
		this.gearType = "auto";
		this.door = 2;
	}
	Zcar(String color , String gearType , int door){
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	void ZcarPrint() {
		System.out.println(this.color + " , " + this.gearType + " , " + this.door);
	}
}

 */




class Zcar2{
	String color;
	String gearType;
	int door;
	
	Zcar2(){ //기본 설정
		this("red",2);
		System.out.println("default ....");
		//기본옵션(red,2,auto)
	}
	Zcar2(String color ,int door){ //기본설정 색상,문의 개수 변경
		this(color,"auto",door);
		System.out.println("overloading parameter 2개 call");
		//옵션 color , door 변경 (default auto)
	}
	
	Zcar2(String color , String gearType , int door){ //모든 옵션은 변경가능 합니다
		this.color = color;
		this.gearType = gearType;
		this.door = door;
		System.out.println("overloading parameter 3개 call");
		//옵션 : color , door , gearType
	}
}



class Zcar{
	String color;
	String gearType;
	int door;
	
	Zcar(){ //기본 설정
		this.color = "red";
		this.gearType = "auto";
		this.door = 2;
	}
	Zcar(String color , String gearType , int door){
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	void ZcarPrint() {
		System.out.println(this.color + " , " + this.gearType + " , " + this.door);
	}
}


public class Ex16_this {

	public static void main(String[] args) {
		Zcar zcar = new Zcar();
		zcar.ZcarPrint();

		Zcar zcar2 = new Zcar("yellow", "auto", 10);
		zcar2.ZcarPrint();
		//===========================================
		Zcar2 car = new Zcar2(); //기본옵션

		Zcar2 car2 = new Zcar2("gold",10); 
		
		Zcar2 car3 = new Zcar2("gold", "auto",20); 
		
	}

}
