class Product3{  //extends Object
	int price;
	int bonuspoint;
	//Product() {	}
	Product3(int price) {
		this.price = price;
		this.bonuspoint = (int)(this.price/10.0);
	}
	
}

class KtTv3 extends Product3{
	KtTv3(){
		super(500);
	}
	
	//Object 재정의 
	@Override
	public String toString() {
		return "KtTv3";
	}
}

class Audio3 extends Product3{
	Audio3(){
		super(100);
	}
	
	@Override
	public String toString() {
		return "Audio3";
	}
}

class NoteBook3 extends Product3{
	NoteBook3(){
		super(150);
	}
	
	@Override
	public String toString() {
		return "NoteBook3";
	}
}

//구매자
class Buyer3{
	int money;
	int bonuspoint;
	Product3[] cart;
	int top; // 물건을 둘 위치
	
	public Buyer3() {
		this(10000);
	}
	
	public Buyer3(int money){ 
		this.money = money;
		this.cart = new Product3[10]; 
		this.top = 0;
	}
	
	void Buy(Product3 n) { 
		cart[top++] = n;
	}
	
	/*
	 * 계산대(장바구니)
	 * 물건을 계산
	 * 1. 구매한 물건의 총액
	 * 2. 포인트 총액
	 * 3. 구매한 물건 리스트
	 * 의 내용을 출력
	 */
	void summery() {
		int priceSum = 0;
		int bonusSum = 0;
		StringBuilder stringBuilder = new StringBuilder();
		
		for(int i=0; i<top; i++) {
			priceSum += cart[i].price;
			bonusSum += cart[i].bonuspoint;
			stringBuilder.append(cart[i].toString()+" ");
		}
		System.out.println("구매 내역 : " + stringBuilder.toString());
		System.out.println("가격 : " + priceSum);
		System.out.println("보너스 : " + bonusSum);
	}
}

public class Ex13_Inheritance_KeyPoint2 {
	
	public static void main(String[] args) {
		Buyer3 buyer = new Buyer3();
		buyer.Buy(new NoteBook3());
		buyer.Buy(new Audio3());
		buyer.Buy(new KtTv3());
		buyer.summery();
	}

}