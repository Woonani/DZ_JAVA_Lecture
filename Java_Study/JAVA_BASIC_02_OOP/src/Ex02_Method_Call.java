import java.util.Scanner;

import kr.or.kosa.Fclass;

public class Ex02_Method_Call {

	public static void main(String[] args) {

		Fclass fclass = new Fclass();
		fclass.m();
		
		fclass.m2(1234);
		
//		fclass.m3(); // 이려면 리턴값 못 받으므로 아래처럼 사용하기
		int result = fclass.m3();
		System.out.println("return value : "+result);
		
		int result2 = fclass.m4(33);
		System.out.println("return value2 : "+result2);
		
		int result3 = fclass.opSum(-500);
		System.out.println("return value3 : "+result3);
		
		//quiz 답 확인
//		Scanner sc = new Scanner(System.in);
//		System.out.println("정수 입력:");
//		int num1 = Integer.parseInt(sc.nextLine());
//		int num2 = Integer.parseInt(sc.nextLine());
//		int result4 = fclass.max(num1, num2);
//		System.out.println("return quiz : "+result4);
		
	}

}
