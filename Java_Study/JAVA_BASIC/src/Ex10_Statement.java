import java.util.*;

public class Ex10_Statement {

	public static void main(String[] args) {
		
		//반복문 (while, do~while)
		int i = 10;
		while(i>=10) { //true
			// 반드시
			// 증가감을 통해서 true, false 판단
			// --i; 증가감의 위치도 고민하자 ....
			System.out.println(i);
			--i;
		}
		
		// while 1~100까지의 합
		int j = 1;
		int sum = 0;
		while(j<=100) { // for (int j = 1; j <= 100; j++
			sum += j;
			j++;
		}
		System.out.println("sum : "+sum);
		
		// while(true) { } 메뉴만들어서 ...
		 
		// while문으로 구구단을 작성
		int a = 2;
		while(a<=9) {
			int b=1;
			while(b<= 9) {
//				System.out.printf("%d*%d=%d\t", a,b,a*b);
				b++;
			}
//			System.out.println();
			a++;
			
		}
		
		// 무한 포문 존재
		//for( ; ; ){ if(조건) {break; } }
		// while(true){ if(조건) break; }
		// do~while : 일단 한번은 강제적으로 수행 ... 그리고 조건을 보고 판단한다
		// do { 실행블럭 } while (조건판단)
		/*
		 메뉴구성
		 점심 메뉴를 선택하세요
		 1. 짜장
		 2. 짬뽕
		 3번 입력값 하면 잘못된 입력입니다....
		 다시 메뉴를 보여주기 
		 *프로그램 동작에 있어서 어떤것을 강제 할때 많이 사용
		 */
		
		Scanner sc = new Scanner(System.in);
		int inputData=0;
		do {
			System.out.println("숫자입력해 (0~9) :");
			inputData = Integer.parseInt(sc.nextLine());
		}while(inputData >= 10); //while 조건 true 계속해서 do문을 실행
										// while 조건 false do 실행하지 않아요
		// do while문 주의! : while 안 조건이 true일때 do를 탄다는 것! while문 탈출하려면 조건 false!
		System.out.println("당신이 입력한 숫자는 : " + inputData);
		
		
	}


}
