import java.util.Scanner;

public class Ex11_Statement_Quiz {

	public static void main(String[] args) {
		// Quiz 1------------------------------------------------------------------------------------------
		// 메뉴를 보여주고 사용자에 선택 ...
		// 원하시는 메뉴를 선택하지 않으면 강제로 다시 메뉴를 보여 주세요
		
		// 1. 예금
		// 2. 출금
		// 3. 잔고조회
		// 4. 종료
		
		// 예금 처리
		// 잔액 변수를 생성 (balance)
		// 예금 처리 + 누적
		// 출금 처리 - 누적
		// 잔고 balance 출력
		// 종료 		프로그램 끝 (함수의 종류 , 프로그램의 강제 종료)
		Scanner sc = new Scanner(System.in);
		boolean system = true;
		int balance = 10000;
		int inputValue;
		do {
			System.out.println("메뉴를 골라주세요! (번호만입력) \n 1. 예금  \n 2. 출금 \n 3. 잔고조회 \n 4. 종료");
			int menu = Integer.parseInt(sc.nextLine());
			if(menu==1) {
				System.out.printf("입금할 금액 숫자만 입력 : ");
				inputValue = Integer.parseInt(sc.nextLine());
				balance += inputValue;
				System.out.printf("%d원 입금하여 잔고는 %d입니다.\n", inputValue, balance);
			}else if(menu==2) {
				System.out.printf("출금할 금액 숫자만 입력 : ");
				inputValue = Integer.parseInt(sc.nextLine());
				if(inputValue>balance) {
				    System.out.printf("잔액부족입니다. 다시");
				}else {
					balance -= inputValue;
					System.out.printf("%d원 출금하여 잔고는 %d입니다.\n", inputValue, balance);
				}
			}else if(menu==3) {
				System.out.printf("너의 잔고 : %d 원 \n", balance);
				
			}else if(menu==4) {
				System.out.println("은행놀이를 종료합니다");
				system = false;
			}else {
				System.out.println("잘못 선택함");
			}
			
		}while(system);
		
	}

}
