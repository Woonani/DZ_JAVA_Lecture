package kr.or.kosa;
//import kr.or.kosa.FakeFlowerVendingMachine;

import java.util.Scanner;

public class FakeFlowerVendingMachine {
	
	public static void main(String[] args) {
		// 꽃생성
		Flower flower1 = new Flower("장미", 9550, "");
		Flower flower2 = new Flower("카네이션", 9550, "");
		Flower flower3 = new Flower("무궁화", 9550, "");
		Flower flower4 = new Flower("국화", 9550, "");
		// 메뉴생성
		MainMenu mainMenu = new MainMenu();
		Payment payment = new Payment();

		Scanner sc = new Scanner(System.in);
		
		// 메뉴프로그램동작
		while(true) {
			switch(mainMenu.displayMenu(flower1, flower2, flower3, flower4)) {
			case 1 : 
				System.out.printf("구매하실 상품 번호를 골라주세요 : ");
				int selectedFlower = Integer.parseInt(sc.nextLine());
				mainMenu.buyFlower(flower1, flower2, flower3, flower4, selectedFlower);
			break;
//			case 2 : flowerMachine.flowerInfo();
//			break;
			case 3 : mainMenu.administer();
			break;
			case 10302 : 
				System.out.println("프로그램 종료");
			//return; >> main 함수 종료
				System.exit(0); // 프로그램 종료(kill) ??  이거 왜 안돼
				break;
			default : 
				System.out.println("번호를 다시 입력해주세요");
			}
		}
		
		
		
		
		
		
		
		
	// 메뉴 동작	
//		DoWhileMenu doWhileMenu = new DoWhileMenu();
//		FakeFlower fakeFlower = new FakeFlower();
//		
//		while(true) {
//			switch(doWhileMenu.displayMenu()) {
//			case 1 : fakeFlower.buyFlowerMenu(1);
//					// 꽃 객체 생성???
//			break;
////			case 2 : 꽃말보기(2);
////			break;
////			case 3 : 관리자메뉴(3);
////			break;
//			default : 
//			//return; >> main 함수 종료
//			System.exit(0); 
//			// 프로그램 종료(kill)
//			}
//
//
//	}

}
}


