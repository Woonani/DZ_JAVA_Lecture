/*
시나리오(요구사항)
저희는 가전제품 매장 솔루션을 개발하는 사업팀입니다
A라 전자제품 매장이 오픈되면

[클라이언트 요구사항]
가전제품은 제품의 가격 , 제품의 포인트 정보를 모든 제품이 가지고 있습니다
각각의 가전제품은 제품별 고유한 이름정보를 가지고 있다
ex)
각각의 전자제품은 이름을 가지고 있다 (ex) Tv , Audio , Computer
각각의 전자제품은 다른 가격정보를 가지고 있다( Tv:5000 , Audio : 6000)
제품의 포인트는 가격의 10%적용한다

시뮬레이션 시나리오
구매자: 제품을 구매하기 위한 금액정보 , 포인트 정보를 가지고 있다
ex) 10만원 , 포인트 0
구매자는 제품을 구매할 수 있다 , 구매행위를 하게 되면 가지고 있는 돈은 감소하고 (가격) 포인트는 증가한다
구매자는 처음 초기 금액을 가질 수 있다
*/

class Product {
	int price;
	int bonuspoint;
//	public Product() {
//		// TODO Auto-generated constructor stub
//	}
	Product(int price){
		this.price = price;
		this.bonuspoint= (int)(this.price/10.0);
	}
}


class KtTv extends Product{
//	class KtTv extends Product{ // 부모가 생성자 오버로딩을 해서 에러 > 부모 디폴트 생성자 만들면 사라지긴 하지만..인수를 넣어야 한다.. 다른방법
	KtTv(){
		super(500); // 그래서 대신 super를 써주면 에러 사라짐
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "KtTv";
	}
}

class Audio extends Product{
	Audio(){
		super(100); 
	}
	@Override
	public String toString() {
		return "Audio";
	}
}

class NoteBook extends Product{
	NoteBook(){
		super(150); 
	}
	@Override
	public String toString() {
		return "NoteBook";
	}
}

//구매자
class Buyer{
	int money = 5000;
	int bonuspoint;
	
	// 기능 구매기능
	// 제품을 구매 할 수 있는 기능 (3개 구매기능)
	// 내 잔액 - 제품가격 , 포인트 갱신 +)
	
	// 다형성 이용 
	void productBuy(Product n) {
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다.^^ 잔액 :" + this.money);
			return; // 함수의 종료(강제)
		}
		// 실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("현재잔액은 : "+ this.money +" 입니다.");
		System.out.println("당신이 구매하신 물건은 "+n.toString()+" 입니다.");
	}
	
	// 아래 함수명(ktTvBuy,audio,noteBook)을 전부 Buy로 바꿔도 되긴 함 > but, 코드량을 감소시키지는 않음
	/*
	void ktTvBuy(KtTv n) { // 함수의 parameter로 제품 객체를 받아서 (가격, 포인트)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다.^^ 잔액 :" + this.money);
			return; // 함수의 종료(강제)
		}
		// 실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("현재잔액은 : "+ this.money +"입니다.");
		System.out.println("당신이 구매하신 물건은"+n.toString()+"입니다.");
	}
	void audio(Audio n) { // 함수의 parameter로 제품 객체를 받아서 (가격, 포인트)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다.^^ 잔액 : " + this.money);
			return; // 함수의 종료(강제)
		}
		// 실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("현재잔액은 : "+ this.money +"입니다.");
		System.out.println("당신이 구매하신 물건은"+n.toString()+"입니다.");
	}
	void noteBook(NoteBook n) { // 함수의 parameter로 제품 객체를 받아서 (가격, 포인트)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다.^^ 잔액 :" + this.money);
			return; // 함수의 종료(강제)
		}
		// 실 구매행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		
		System.out.println("현재잔액은 : "+ this.money +"입니다.");
		System.out.println("당신이 구매하신 물건은"+n.toString()+"입니다.");
	}
	 */
	
}

/*
 1차 오픈 ...
 팀장 >> 하와이 휴가 ....
 
  매장에 제품 더 구매 1000개 제품 추가 (마우스, 토스트기, 청소기) .. POS (자동등록 : 제품)
  매장에 1000개의 제품 전시 ....
  업체 전단지 주말 오픈세일 ....
  1. 오픈 3개 구매 >> 997 제품 구매가 안되요.
  >> 팀장 >> 하와이 >> PC방 >> 국내 전산망 >> 개발 서버 접속 >> 이틀 밤샘 >> 구매함수 997개 추가
  
 
 */

public class Ex12_Inheritance_KeyPoint {

	public static void main(String[] args) {

		// 가오픈 생각하고 매장..시뮬레이션
		KtTv kt = new KtTv();
		Audio audio = new Audio();
		NoteBook notebook = new NoteBook();
		Product p = kt; // 자식을 > 부모에게 할당은 O 
//		Audio d = p; : Ex11에서 맨 마지막줄에 한거. 부모를 > 자식에게 할당은 X 
//		Audio d = (Audio) p;// : 강제로는 가능 : DownCasting 
		Buyer buyer = new Buyer();
		buyer.productBuy(p);
		buyer.productBuy(kt);
		buyer.productBuy(kt);
		buyer.productBuy(audio);
		buyer.productBuy(audio);
		buyer.productBuy(notebook);
		buyer.productBuy(notebook);

		/*
//		buyer.ktTvBuy(kt);
//		buyer.ktTvBuy(kt);
//		buyer.ktTvBuy(kt);
//		buyer.ktTvBuy(kt);
//		buyer.ktTvBuy(kt);
//		buyer.ktTvBuy(kt);
//		buyer.ktTvBuy(kt);
//		buyer.audio(audio);
//		buyer.audio(audio);
//		buyer.noteBook(notebook);
//		buyer.noteBook(notebook);
//		buyer.noteBook(notebook);
//		buyer.noteBook(notebook);
//		buyer.noteBook(notebook);
		 */
		 
	}

}
