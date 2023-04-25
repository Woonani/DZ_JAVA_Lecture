package kr.or.kosa;

import java.util.Scanner;

public class DoWhileMenu {
	Scanner sc = new Scanner(System.in);
//	private String studentName;
//	private int studentGrade;
//	 
//	// 함수) 성적 데이터 입력 기능
//	public void inputRecord () {
//		 
//	}
//	// 함수) 성적 데이터 삭제
//	public void deleteRecord () {
//		
//	}
//	// 함수) 성적 데이터 정렬
//	public void sortRecord () {
//		
//	}
	
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
//		System.out.println();
//		System.out.println("1.상품구매");
//		System.out.println();
//		System.out.println("2.꽃말보기");
//		System.out.println();
//		System.out.println("3.관리자 메뉴");
		System.out.println();
		System.out.println("**번호를 눌러 상품을 선택해주세요**");
//		System.out.println("4.프로그램 종료"); // 나중에 관리자 메뉴에 넣기
//		System.out.println();
		int menuNum = Integer.parseInt(sc.nextLine());
		
		return menuNum;
		
		

	}
	
	


}