import java.util.*; // 꿀팁

public class Ex09_Statement {

	public static void main(String[] args) {
		/*
		 제어문
		 조건문 : if(3가지),  switch(조건) { case값 ... break } >> if문은 범위, switch는 동등, 유한한 개수일때 주로 쓴다 
		 반복문 : for() {} , while(진위여부) { } , do{ } ~ while( )
		 분기문 : break(블럭탈출), continue(아래 구문 skip)
		 */
		int count = 0;
		if(count<1) System.out.println("true"); // 단일 if 문 {}생략 가능
		
		if(count < 1) {
			System.out.println("{ true }");
		}
		
		char data='A';
		switch(data) {
			case 'A' : System.out.println("문자 비교 같아요");
				break;
			case 'B':System.out.println(".....");
				break;
			default : System.out.println("나머지 처리");
			
		}
		//for문 
		//1~100까지 합
		int sum = 0;
		for(int i =1; i<=100; i++) {
			sum+=i;
		}
		
		System.out.printf("1~100까지 누적합 : %d ", sum);
//		System.out.println("sum : "+ sum);

//		Scanner sc = new Scanner(System.in);
//		System.out.print("입력값 : " );
//		String num = sc.nextLine(); 
//		int n = Integer.parseInt(num);
//		int sum2 = n*(n+1)/2;
//		System.out.println(sum2);
		int result = 0;
		for(int i=1; i<=10; i+=2) {
			result += i;
		}
		System.out.println("result : "+result);
		
		
		// for문 안에서 if문 사용 1~1000까지 짝수의 합
		int result2 = 0;
		for(int i=1; i<=1000; i++) {
			if(i%2 == 0) {
				result2 += i;
			}else {
				continue;
			}
		}
		System.out.println("result : "+result2 ); 
		
		

		//////과제1///////////////////////////////////////////////////////////////////////////////
		for(char alphabet =65; alphabet<=90; alphabet++) {
			System.out.print(alphabet + " ");
        }
		
		System.out.println();

		for(int i = 1; i <= 100; i++) {
			System.out.printf(" %d", i);
			if(i%10 == 0)  System.out.println(); 
		}
		
		System.out.println();
		
		int answer=0;
		for(int i=1; i<=6; i++) {
			for(int j=1; j<=6; j++) {
				if(i+j == 6) answer += 1 ;
			}
		}
		System.out.println("answer : "+ answer);
		
		//////과제2///////////////////////////////////////////////////////////////////////////////
//		Scanner sc = new Scanner(System.in);
//		System.err.print("삼각형의 밑변 입력 : ");
//		int num1 = Integer.parseInt(sc.nextLine());
//		//1 왼쪽 직삼각형
//		for(int i=1; i<= num1; i++) {
//			for(int j=1; j<=i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		//1.2 왼쪽 역삼각형
//		for(int i=num1; i>= 1; i--) {
//			for(int j=1; j<=i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		
//		System.out.println();
//		
//		//3 오른쪽 직삼각형
//		for(int i=num1; i>= 1; i--) {
//			for(int j=1; j<=i; j++) {
//				System.out.printf(" ");
//			}
//			for(int j=0; j<=num1-i; j++) {
//				System.out.printf("*");
//			}
//			System.out.println();
//		}
		
		//////과제3///////////////////////////////////////////////////////////////////////////////
		/*
		 *	UNIT : 화폐단위
		 	num : 화폐매수
			SW : 스위칭 변수 , 화폐의 다음 단위를 위해
			MONEY : 입력받는 금액
			아래 코드는 금액을 입력받아 
			예)
			12345
			10000 1개
			5000 0개
			1000 2개
			500 0개
			100 3개 
			50 0개
			10 4개
			5 1개
			1 0개
			를 계산하는 프로그램 입니다 
		 */
		
		//////// 풀이 1 _ 플로차트에 충실하게 코딩
//		int unit = 10000;
//		int num = 0;
//		int sw = 0;
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("MONEY입력");
//		int MONEY = Integer.parseInt(sc.nextLine());
//
//		num = (int) ( MONEY/unit);
//		System.out.printf("MONEY: %d  unit: %d 개 ", unit, num); 
//		System.out.println();
//		do {
//			if(unit > 1 ) {
//				MONEY=MONEY - unit*num;
//				if(sw == 0) {
//					unit=unit/2;
//					sw=1;
//				}else {
//					unit = unit/5;
//					sw=0;
//				}
//			}			
//			num = (int) ( MONEY/unit);
//			System.out.printf("MONEY: %d  unit: %d 개 ", unit, num); 
//			System.out.println();
//		}while(unit > 1);  // 공부! :  do while 문은 do 블록 끝까지 내려온 후 조건을 확인한다. 
		//Test case ; 98766 66666 98733 12345
		
		
		//////// 풀이 2 _ 플로차트에서 개념만 읽고 겹치는 라인이 없도록 코딩

		
/////////////////답지//////////////////////////////////////////////////////////////////		
//		int unit = 10000;
//		int num = 0;
//		int sw = 0;
//		int money = 0;
//		Scanner sc = new Scanner(System.in);
//		System.out.print("분류를 원하는 금액을 입력하세요 : ");
//		money = sc.nextInt();
//		while(unit >= 1) {
//			num = (int)(money/unit);
//			System.out.println("화폐단위 " + unit + " : "+ num+"개");
//			
//			if (money>=1) {
//				money -= unit*num;				
//			}
//			switch(sw) {
//				case 1: unit /= 5; sw = 0; break;
//				case 0: unit /= 2; sw = 1;
//			}
//		}
		
		//===================================
		for(int i = 2; i<=9; i++) {
			for(int j=1; j<=9; j++) {     //
				if(i==j) {					  //
					break; 				 // break의 탈출범위
				}							//
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i = 2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				if(i==j) {
					continue;
				}
				System.out.printf("%s","*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i = 2; i<=9; i++) {
			for(int j=1; j<i; j++) {
				if(i==j) {
					continue;
				}
				System.out.printf("%s","*");
			}
			System.out.println();
		}
		
		// 100부터 0까지의 출력 (시작값100)
		for(int i = 100; i>=0; i--){
			System.out.printf("%s\t", i);
		}
		
		// 피보나치 수
		int a = 0, b=1, c=0;
		for(int i=0; i<10; i++) {
			a=b;
			b=c;
			c= a+b;
			System.out.printf("[%d]*[%d]=[%d]\t", a,b,c);
		}
	}

}
