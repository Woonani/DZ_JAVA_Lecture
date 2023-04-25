
public class Ex05_Operation {

	public static void main(String[] args) {
		// 연산자 (산술, 논리, 관계)
		int result = 100 / 100;
		System.out.println("result : " + result);

		result = 13 / 2; // 덮어쓰기 가능!
		System.out.println("result : " + result);

		// 나머지를 구하는 연산자 (%)
		result = 13 % 2;
		System.out.println("result : " + result);

		// 증가, 감소 ( 증가감 연산자 : ++1씩 증가, --1)
		int i = 10;
		++i; // 전치 증가
		System.out.println("i : " + i);
		i++; // 후치증가
		System.out.println("i : " + i);
		// 다른 결합 없이 혼자 있으면 전치와 후치는 의미가 없다

		// Today point (증가감 연산자와 다른 연산이 결합되면)
		int i2 = 5;
		int j2 = 4;
		int result2 = i2 + ++j2;
		System.out.println("result2 : " + result2 + ", j2 :" + j2); // 10, 5 : 증가후 연산
		result2 = i2 + j2++;
		System.out.println("result2 : " + result2 + ", j2 :" + j2); // 10, 6 : 연산 후 증가

		byte b = 100;
		byte b2 = 1;

//		byte b3 = b + b2;  // Type mismatch: cannot convert from int to byte
		// 연산시 자바는 기본적으로 4byte 공간을 만들고 공간에 값을 넣고 연산 > 결국 (int + int)가 됨....
		// byte b3 = (byte) (b + b2); // 해결1) 손실이 발생할 수 있다.
		// System.out.println("b3 : " + b3);
		int b3 = b + b2; // 해결2) 손실은 발생하지 않는다
		System.out.println("b3 :  " + b3);

		/*
		 * Today point 1. 정수의 연산은 [int] 타입으로 변환 후 처리된다 ex) byte + short >> 컴파일러가 내부적으로
		 * 값들을 int라는 방에 넣고 처리한다 >> int + int 로 처리 ex) char + char >> 컴파일러가 내부적으로 int +
		 * int 처리 정수의 연산에서 int보다 작은 타입들은 내부적으로 모두 int로 바꾸어 연산처리 된다. 정수에서 long 예외 .....
		 * 나머지는 byte, char, shor, >> int.로 전환 후 처리 ex) char + int >> int , int + int >>
		 * int,, int + long >> long
		 * 
		 * 2. 정수 + 실수 >> 타입의 크기와 상관 없이 >> 실수가 승자
		 */

		// long lo = 10000000000; 기본 int 라서 접미사 필요
		long lo = 10000000000L;
		// float fo = 1.2; 기본 doubble 이라서 접미사 필요
		float fo = 1.2f;
		// long result3 = lo + fo; // 둘다 8byte 지만 정수 < 실수 이므로
		long result3 = (long) (lo + fo); // 해결1 둘다 8byte 지만 정수 < 실수 이므로
		float result3_1 = lo + fo; // 해결2

		char c2 = '!';
		char c3 = '!'; // asci 33번
		int result4 = c2 + c3; // char도 정수 방 에 넣고 계산 되므로 가능
		System.out.println("result4 : " + result4);

		// 변수 >> 타입(자료형) >> 연산(산술, 논리, 관계) >> 제어문 (if, for, while...)
		// 제어문
		int sum = 0; // local variable (사용전에 반드시 초기화)
		for (int j = 0; j <= 100; j++) {
			// System.out.println("sum : " + sum); // 5050Q
			if (j % 2 == 0) {
				// 짝수라면 = 2의 배수라면
				sum += j; // sum = sum+ j
			}
		}
		System.out.println("sum : " + sum); //

		// == 연산자 (값을 비교하는 연산자)
		if (10 == 10.0f) { // 타입을 비교하는 것이 아니고 [값을 비교]
			System.out.println("true");
		} else {
			System.out.println("false");
		}

		// != 부정 연산자
		if ('A' != 65) {
			// 같지 않다면
			System.out.println("어 같지 않아 : true");
		} else {
			// 같다면
			System.out.println("어 같은 값이야: false");
		}

		// Today Point
		// 연산자 중에서 제어문 역할 (조건, 반복)
		// 삼항 연산자
		int p = 10;
		int k = -10;
		int result5 = (p == k) ? p : k;
//		String result5 = (p == k ) ? "A" : "b"; // b 출력
		System.out.println("result5 : " + result5);

		// === javascript 타입도 같고 값도 같은 것을

		// if 문
		int result6 = 0; // result9는 main함수 안에 있는 local variable!
		if (p == k) {
			result6 = p;
		} else {
			result6 = k;
		}
		System.out.println("result6 : " + result6);

		/*
		 * 진리표 (논리연산) 0 : 거짓 (false) 1 : 참 (true)
		 * 
		 * OR 연산, AND 연산
		 * 
		 * DB 쿼리 Oracle) SQL은 자연어 ... select * from emp where job='IT' and sal > 3000;
		 * select * from emp where job='IT' or sal > 3000; AND OR 0 0 0 0 0 1 0 1 1 0 0
		 * 1 1 1 1 1
		 * 
		 * 연산자 비트 연산 ( | or 연산 ..... & and 연산) || 논리연산 (OR) , && 논리연산 (AND)
		 * 
		 */

		int x = 3;
		int y = 5;

		// 비트연산 (십진수 >> 이진수로 바꾸어서 연산하는 방법)
		System.out.println("x | y  : OR 연산 " + (x | y)); // 7
		/*
		 * 128 64 32 16 8 4 2 1 0 0 1 1 >> 3 4비트 0 1 0 1 >> 5 4비트
		 * ------------------------------ 0 1 1 1 >> | 비트 OR연산 3 >> 11(2) 5>> 101(2) 7
		 * >> 111(2) - or 연산 1 >> 1 (2) - and 연산
		 */

		System.out.println("x | y  : OR 연산 " + (x & y)); // 1
		/*
		 * 128 64 32 16 8 4 2 1 0 0 1 1 >> 3 4비트 0 1 0 1 >> 5 4비트
		 * ------------------------------ 0 0 0 1 >> | 비트 AND연산
		 * 
		 * 
		 * 비트 (영상처리, 판독)
		 * 
		 * Today Point (&& >> and 연산) (|| >> or 연산) if(10> 0 && -1 > 1 && 100 > 2 && 1 >
		 * -1) { A } else { B } ... // 10> 0 && -1 > 1 : B // 조건 배치 잘하면 연산 빠르게 활용 가능
		 * if(10> 0 || -1 > 1 || 100 > 2 || 1 > -1) { A } else { B } ... //10> 0 : A
		 * 
		 */

		int data = 90;
		switch (data) {
		case 100:
			System.out.println("100입니다");
		case 90:
			System.out.println("90입니다");
		case 80:
			System.out.println("80입니다");
		default:
			System.out.println("일치하는 값이 없습니다");
		}
		/*
		 * 90입니다 80입니다 일치하는 값이 없습니다
		 */

		switch (data) {
		case 100:
			System.out.println("100입니다");
			break;
		case 90:
			System.out.println("90입니다");
			break;
		case 80:
			System.out.println("80입니다");
			break;
		default:
			System.out.println("일치하는 값이 없습니다");
		}
		/*
		 * 90입니다
		 */
		int month = 5;
		String res = " "; // char 와 달리 String은 빈문자로 초기화 가능
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			res = "31일";
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			res = "30일";
			break;
		case 2:
			res = "28일";
			break;
		default:
			res = "월 데이터가 아닙니다";
		}
		System.out.println(month + "월은 " + res + "일자 까지 입니다");

		// 난수 (랜덤값, 임의의 추출값)을 얻기를 원해요
		// 쉬운방법 : 구글 검색 (친절하게)
		// 자바를 만드는 자습서 (API 문서) 자원에 대한 설명과 사용방법 (영어)
		// https://docs.oracle.com/javase/8/docs/api/index.html 검색
		// 패키지 기준 (폴더별로 자원을 모아 모아 ...)
		// java.lang.Math 클래스 활용하면 여러가지 수학적인 기능을 사용 ...
		// import java.lang.* 생략 ... default open ...

		// public static double random();
		// double greater than or equal to 0.0 and less than 1.0
		// 결과 : 0.0 <= random < 1.0

		System.out.println("Math.random() : " + Math.random()); // default double로 약 16자리 소수
		System.out.println("(int)Math.random()*10 : " + (Math.random() * 10));
		System.out.println("(int)Math.random()*10 : " + (int) ((Math.random() * 10) + 1));

		/////////////////////////////////

		int score2 = ((int) ((Math.random() * 10) + 1)) * 100;
		switch (score2) {
		case 1000:
			System.out.println("점수는 " + score2 + "경품으로 TV , NoteBook , 냉장고 , 한우세트 , 휴지");
			break;
		case 900:
			System.out.println("점수는 " + score2 + "경품으로 NoteBook , 냉장고 , 한우세트 , 휴지");
			break;
		case 800:
			System.out.println("점수는 " + score2 + "경품으로냉장고 , 한우세트 , 휴지");
			break;
		case 700:
			System.out.println("점수는 " + score2 + "경품으로  한우세트 , 휴지");
			break;
		case 600:
			System.out.println("점수는 " + score2 + "경품으로 휴지");
			break;
		default:
			System.out.println("점수는 " + score2 + "경품으로 칫솔 드려요!");

		}
/////////////////////////////////

		int score3 = ((int) ((Math.random() * 10) + 1)) * 100;
		String present = " ";
		switch (score3) {
		case 1000:
			present += " TV, ";
		case 900:
			present += " NoteBook,  ";
		case 800:
			present += "냉장고, ";
		case 700:
			present += "한우세트, ";
		case 600:
			present += "휴지";
			break;
		default:
			present = "칫솔";
		}
		System.out.println("점수는 " + score3 + " 경품으로"+ present +"드려요!");
		
		
		
		
		
		
		//switch(조건) 정수만 .. 아니죠
		  //조건식은 "문자열"도 가능 , "문자" 가능
		  
		  String m = "F";
		  String f="";
		  switch(m) {
		  	case "A":
		  	case "B":
		  	case "C":
		  	case "D":
		  	case "E":
		  	case "F":
		  	case "G": f="ok";
		  	   break;
		  	case "H":
		  	case "k": f= "no";
		  	   break;
		  	default : f ="no data";
		  }
	      System.out.println("결과 : " + f);
/////////////////////////////////

		
		
	}

}
