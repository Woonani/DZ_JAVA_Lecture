package kr.or.kosa;

import java.util.Scanner;

public class MainMenu {
	Scanner sc = new Scanner(System.in);
	 
	// 함수) 상품구매 기능
	public void flowerMenu () {
	}
	// 함수) 꽃말보기 기능
	public void flowerMeaning () {
		
	}
	// 함수) 관리자 기능
	public void administer () {
		
		
	}
	
	public int displayMenu() {
		System.out.println("*******************");
		System.out.println("*******꽃자판기*******");
		System.out.println("*******************");
		System.out.println("**  @   **   #   **");
		System.out.println("**  |   **   |   **");
		System.out.println("**1.장미 **2.카네이션**");
		System.out.println("*******************");
		System.out.println("**  &   **   ^   **");
		System.out.println("**  |   **   |   **");
		System.out.println("**3.무궁화**4.국화  **");
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