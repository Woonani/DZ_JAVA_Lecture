/*
문제 풀어 보세요 ^^
요구사항
 >> 매장카트 구현하기 입니다 <<
카트 (Cart) >> member field
카트 매장에 있는 [모든 전자제품]을 담을 수 있다 
카트의 크기는 고정되어 있다 (10개) : 1개  , 2개 담을 수 있고 최대 10개까지 담을 수 있다
고객이 물건을 구매 하면 ... [카트에 담는다] // !!!!! buy 할때 카트에 담는다
---------------------------------------
계산대에 가면 전체 계산
계산기능이 필요
summary() 기능 추가해 주세요
당신이 구매한 물건이름 과 가격정보 나열
총 누적금액 계산 출력

hint) 카트 물건을 담는 행위 (Buy() 함수안에서 cart  담는 것을 구현 )
hint) Buyer ..>> summary()  main 함수에서 계산할때  사용합니다

Buyer >> buy(), summary() >> 카트에 물건계산 (어떤물거나, 각 가격 >> 당신은 총 얼마 지급) //!!!!! 매소드 추가

구매자는 default 금액을 가지고 있고 초기금액을 설정할 수 도 있다

*/
// 카트는 1차원 배열, 프로덕트를 담는다. 
class Product2{  //extends Object
	int price;
	int bonuspoint;
	//Product() {	}
	Product2(int price) {
		this.price = price;
		this.bonuspoint = (int)(this.price/10.0);
	}
	
}

class KtTv2 extends Product2{
	KtTv2(){
		super(500);
	}
	
	//Object 재정의 
	@Override
	public String toString() {
		return "KtTv2";
	}
}

class Audio2 extends Product2{
	Audio2(){
		super(100);
	}
	
	@Override
	public String toString() {
		return "Audio2";
	}
}

class NoteBook2 extends Product2{
	NoteBook2(){
		super(150);
	}
	
	@Override
	public String toString() {
		return "NoteBook2";
	}
}

//구매자
class Buyer2{
	Product2[] cart; // 다형성 ... 카트 모든 제품을 담는다(부모타입) ; 단 모든 제품은 Product2를 상속해야한다는 것이 전제조건
	int count; // 초기화는 생성자함수 안에서
	int money;
	int bonuspoint;
//	int buyMoney = 0; // 구매금액 >> summary에서만 필요하므로 삭제
//	String buyList=""; // 구매 리스트 >> summary에서만 필요하므로 삭제

	Buyer2(){
		this(5000); //this(1000,0);// 보너스 포인트도 설정시
	}
	
	Buyer2(int money){//Buyer2(int money , int bonuspoint){ // 보너스 포인트도 설정시
		cart= new Product2[10];
		this.count = 0;
		this.money = money;
		this.bonuspoint = 0;// this.bonuspoint = bonuspoint; // 보너스 포인트도 설정시
	}
	
	void Buy(Product2 n) { 

		if(this.money < n.price ) {
			System.out.println("고객님 잔액이 부족합니다^^ " + this.money);
			return; //함수의 종료(강제)
		}

		//방어적인 코드//////////////////////////////////////////////
		if(count>9) { // count 로
			System.out.println("고객님 장바구니를 초과하셨습니다.");
			return;
		}
//		cart[count]=n;
//		count++;
		cart[count++]=n; // 후치증가로 코드 두줄을 한줄로!
		System.out.printf(" %d 개 담음 / ", count);
		////////////////////////////////////////////////////////
		
		//실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.printf("구매한 물건은 : %s  / " , n.toString());
		System.out.printf("현재 잔액은 : %d  \n" , this.money );
//		this.buyMoney += n.price;
//		this.buyList += (n.toString() + ", ");
	}
	// void summary() 추가
	/*
	계산대(장바구니)
	물건을 계산
	1. 구매한 물건의 총액
	2. 포인트 총액
	3. 구매한 물건 리스트 
	의 내용을 출력
	*/
	void summary() { // summary 에서 계산 해보기
		int buyMoney=0;
		String buyList="";
		int totalbonuspoint=0;// 적립한 포인트는 누적 포인트와 별개로 계산 시점마다 새로 필요하므로 여기다가 초기화 해야한다.
		if(count == 0 ) {
			System.out.println("현재 장바구니에 들어있는 물건이 없습니다.");
		}else {
			
			/*
			for(int i = 0 ; i < cart.length ;i++) {  //물건이 없으면 null 연산 예외
				//다행이도 10개 샀으면 ...
				if(cart[i] == null) break; //랜덤 continue
				totalprice += cart[i].price;
				totalbonuspoint += cart[i].bonuspoint;
				productlist+= cart[i].toString()+ " ";
			}
			*/
			
			for(int i=0; i<count; i++) {
				buyMoney += cart[i].price;
				buyList += ( cart[i].toString() + " " );
				totalbonuspoint += cart[i].bonuspoint;
			}
			System.out.println("구매한 물건은 : " + buyList);
			System.out.println("현재 구매한 물건의 총액은 : " + buyMoney );
			System.out.println("적립된 포인트는 : " + totalbonuspoint );
			System.out.println("누적 포인트는 : " + this.bonuspoint );
			System.out.println("현재 잔액은 : " + this.money );
		}
		
	}
}


public class Ex13_Inheritance_KeyPoint {
//	Product2[] cart= new Product2[10];
	
	public static void main(String[] args) {
//		Product2[] cart= new Product2[10];
		
		KtTv2 ktTv = new KtTv2();
		Audio2 audio = new Audio2();
		NoteBook2 noteBook = new NoteBook2();

		Buyer2 buyer = new Buyer2();
		buyer.Buy(ktTv);
		buyer.Buy(audio);
		buyer.Buy(noteBook);
		buyer.Buy(ktTv);
		buyer.Buy(ktTv);
		buyer.Buy(ktTv);
		buyer.Buy(ktTv);
		buyer.Buy(ktTv);
		buyer.Buy(ktTv);
		buyer.Buy(ktTv);
		buyer.Buy(ktTv); 
		buyer.summary();
		
		
	}

}
