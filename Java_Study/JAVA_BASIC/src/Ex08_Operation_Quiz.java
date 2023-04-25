import java.util.*; // 꿀팁

public class Ex08_Operation_Quiz {

	public static void main(String[] args) {
		/*
		 간단한 사칙 연산기 (+, -, *, /)
		 
		 
		 # 입력값은 nexLine()
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력값 : " );
		String inputValue1 = sc.nextLine(); 
		int num1 = Integer.parseInt(inputValue1);
		System.out.print( "입력값(부호) : " );
		String inputValue2 = sc.nextLine(); 
		System.out.print("입력값 : " );
		String inputValue3 = sc.nextLine(); 
		int num2 = Integer.parseInt(inputValue3);
		int result=0;
		boolean test=true;
		switch(inputValue2) {
			case"+":
				result = num1 + num2;
				break;
			case"-":
				result = num1 - num2;
				break;
			case"*":
				result = num1 * num2;
				break;
			case"/":
				result = num1 / num2;
				break;
			default : 
				test=false;
		}
		if(!test) {
			System.out.println("입력오류");
		}else {
			System.out.println("연산결과: " + result);
		}
		
		
		/*
		 문자열의 비교는 ==을 쓰지 않아요
		 String str = "+" ; 
		 if(str == "+")  >> new 생성자로는 주소값과 비교할 수 도 있기 때문!!
		 if(str.equals("*"))
		 */
		
	}

}
