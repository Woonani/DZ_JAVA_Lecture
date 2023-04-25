/*
교재 실습 하기
LogicalOperatorExample.java  (92 page) 초급자에 보약 ^^
ConditionalOperationExample.java  (104 page) : 삼항연산자 중복

연산자
   IfDiceExample.java   (115 page) (가위바위보 게임)
 
   **Java 12** 이후부터는 switch 문에서 Expressions (표현식)을 사용할 수 있다  (참고)
   SwitchExpressionsExample.java  (122 page) : 자스 화살표함수같이 switch문 람다함수
  
   KeyControlExample.java  (131 page)
   
   DoWhileExample.java   (133 page) : system.out.println 
   
   BreakOutterExample.java

*/
public class Ex12_ETC {
	public static void main(String[] args) {
		//int x = 5;
		//int y = 0;
		//int result = 5 / 0;     : 0으로 나눌 수 없다
		//java.lang.ArithmeticException: / by zero
		//무한대의 값을 정수로 표현할 수 없기 때문이다
		
	    double result2 = 5 /0.0;
	    System.out.println(result2);  // 예외 발생하지 않고 Infinity (무한대)라고 출력
	    
	    double result3 = 5 % 0.0;
	    System.out.println(result3);  // 예외 발생하지 않고 NaN (Not a Number)라고 출력
	    
	    
	    
	    int x = 5;
	    double y = 0.0;
	    double z = x / y;
	    //double z = x % y;
	    
	   //잘못된 코드
	    System.out.println(z + 2);
	   
	   //알맞은 코드
	    if(Double.isInfinite(z) || Double.isNaN(z)) {
	       System.out.println("값 산출 불가");
	     } else {
	       System.out.println(z + 2);
	     }
	}
}
