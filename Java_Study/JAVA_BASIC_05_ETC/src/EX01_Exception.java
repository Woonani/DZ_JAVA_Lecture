/*
 오류
 1. 에러(error)	: 네트워크 장애, 메모리 누수, 하드웨어 >> 개발자가 코드적으로 해결 불가
 2. 예외(exception) : 개발자의 코드 실수로 발생 >> 문제 발생 코드 찾아서 >> 수정 >> 배포
 2.1 컴파일 시 ... 실행파일 생성 안되요 (무조건 해결)
 2.2 런타임시 (실행 도중)에 문제가 발생 >> 강제 종료 >> 문제가 생긴 시점 >> 이후 나머지 코드 실행안됨
 
 예외처리 : 프로그램이 안정적으로 종료 >> 나면 원인분석 >> 코드수정 .... >> 다시 배포
 
 try{
 	>> 문제가 의심되는 코드
 	>> 문제가 발생되면 >> 어떤일이 >> 예외가 발생한 정보를 담을 수 있는 객체를 자동생성 
 	ex)
 	>> [0][1][2]	>> car[3] = "" >> ArrayIndexOutOfBoundsException (생성) >> 예외담기
 	>> new ArrayIndexOutOfBoundsException("정보")
 }catch(Exception e){ // Exception 모든 예외의 부모타입 ( ArrayIndexOutOfBoundsException의 부모클래스가 Exception 이므로 문제없음!)
 		>> 문제 파악 
 		>> 처리 (코드 수정되지 않아요) 보고
 		>> 1. 관리자 email
 		>> 2. 로그기록 (장애 발생 기록)
 		>> 3. 강제종료는 막는다 
 }finally{
 		>> 문제가 발생되던, 발생하지 않던 강제적으로 실행되는 코드
 		// 함수 return 만나도 종료.. return을 만나도 finally 강제 실행
 		>> DB작업 ...DB자원 종료(해제) 강제 ....
 }
 */
public class EX01_Exception {

	public static void main(String[] args) {
		/*
		System.out.println("main start");
		System.out.println(0/0);
		//  java.lang.ArithmeticException: / by zero
		// 문제가 발생하면 종료 ... 더 이상 코드 실행하지 않아요
		System.out.println("main end");
		 
		 */
		try {
			System.out.println("main start");
			System.out.println(0/0);

		}catch(Exception e) { // 부모타입 변수는 자식타입의 주소값을 받을 수 있다. (다형성)
			// 문제파악 .. 전달
			System.out.println("문제발생 > "+ e.getMessage());  	
			e.printStackTrace();
			/*
			 java.lang.ArithmeticException: / by zero at EX01_Exception.main(EX01_Exception.java:41)

			 */

	}
			//finally {
			System.out.println("main end");

//		}
	}

}
