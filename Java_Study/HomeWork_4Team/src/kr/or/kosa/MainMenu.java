package kr.or.kosa;

import java.util.Scanner;

public class MainMenu {
	Scanner sc = new Scanner(System.in);
//	 Payment payment = new Payment();
	// 함수) 상품구매 기능
	public void buyFlower (Flower flower1, Flower flower2, Flower flower3, Flower flower4, int selectedFlower) {
		int price;
		int payment;
		switch(selectedFlower) {
		case 1 : 
			System.out.printf("선택하신 1.%s는 %d원 입니다. 금액을 투입하여 주십시오. : ",flower1.getFlowerName(), flower1.getFlowerPrice());
			price = flower1.getFlowerPrice();
			payment = Integer.parseInt(sc.nextLine());
			Payment.payMoney(price, payment);
			break;
		case 2 :
			System.out.printf("선택하신 2.%s는 %d원 입니다. 금액을 투입하여 주십시오. : ",flower2.getFlowerName(), flower2.getFlowerPrice());
			price = flower2.getFlowerPrice();
			price = flower1.getFlowerPrice();
			payment = Integer.parseInt(sc.nextLine());
			Payment.payMoney(price, payment);
			break;
		case 3 :
			System.out.printf("선택하신 3.%s는 %d원 입니다. 금액을 투입하여 주십시오. : ",flower3.getFlowerName(), flower3.getFlowerPrice());
			price = flower3.getFlowerPrice();
			price = flower1.getFlowerPrice();
			payment = Integer.parseInt(sc.nextLine());
			Payment.payMoney(price, payment);
			break;
		case 4 :
			System.out.printf("선택하신 4.%s는 %d원 입니다. 금액을 투입하여 주십시오. : ",flower4.getFlowerName(), flower4.getFlowerPrice());
			price = flower4.getFlowerPrice();
			price = flower1.getFlowerPrice();
			payment = Integer.parseInt(sc.nextLine());
			Payment.payMoney(price, payment);
			break;
		default : 
			System.out.println("에러");
			
		}
//		int payment = Integer.parseInt(sc.nextLine());
//		Payment.payMoney(price, payment);
	}
	// 함수) 꽃말보기 기능
	public void flowerMeaning () {
		
	}
	// 함수) 관리자 기능
	public void administer () {
		
		
	}
	
	public int displayMenu(Flower flower1, Flower flower2, Flower flower3, Flower flower4) {
		System.out.println("*******************");
		System.out.println("*******꽃자판기*******");
		System.out.println("*******************");
		System.out.println("**  @   **   #   **");
		System.out.println("**  |   **   |   **");
		System.out.println("**1."+flower1.getFlowerName()+" **2."+flower2.getFlowerName()+"**");
		System.out.println("*******************");
		System.out.println("**  &   **   ^   **");
		System.out.println("**  |   **   |   **");
		System.out.println("**3."+flower3.getFlowerName()+"**4."+flower4.getFlowerName()+"  **");
		System.out.println("*******************");
		System.out.println("**************   **");
		System.out.println("*******************");
		System.out.println("1.상품구매");
		System.out.println("2.꽃말보기");
		System.out.println("3.관리자 메뉴");
		System.out.printf(">번호를 눌러 메뉴를 선택해주세요. \n : ");
//		System.out.println("4.프로그램 종료"); // 나중에 관리자 메뉴에 넣기
//		System.out.println();
		
		int menuNum = Integer.parseInt(sc.nextLine());
		
		return menuNum;
		
		

	}
	
	


}