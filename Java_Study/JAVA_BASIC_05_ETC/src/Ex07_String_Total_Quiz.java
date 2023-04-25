import java.util.Scanner;

public class Ex07_String_Total_Quiz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("주민번호 13자리를 입력해 주세요. ");
		System.out.println("예시) 123456-1234567");
		System.out.printf(": ");
		String jumin = sc.nextLine();
		System.out.println();
		int n = Integer.parseInt(jumin.substring(7,8));
		checkNumber(jumin);
		checkBackNumber(n);
		checkGender(n);
	}
	
	// 1. 자리수 체크 (기능)함수 (14 ok)  return true , false
	public static boolean checkNumber(String jumin) {
		return (jumin.length() == 14) ? true:false;
	}
	
	//2. 뒷번호 첫번째 자리값 1~4까지의 값만 허용 기능함수  return true, false
	public static boolean checkBackNumber(int n) {
		return (n>0 && n<5)?true: false;
	}
	
	//3. 뒷번호 첫번째 자리값을 가지고 1,3 남자 , 2,4 여자 출력 기능함수  void  출력
	public static void checkGender(int n) {
		String gender = (n == 1 || n == 3) ? "남자" : "여자";
		System.out.println(gender);
	}
}
