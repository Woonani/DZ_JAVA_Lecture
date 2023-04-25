import java.io.*;
import java.util.Arrays;
//정수를 입력받아 byte로 출력
/*
 IO(input / output)
 
 Stream(통로)
 데이터 종류 : 이미지, 파일 <> 문자
 
 JAVA API >> 클래스를 제공 받아요 - 입출력을 위한 클래스
 I/O 기본 단위는 Byte
 
 추상 클래스 
 InputStream, OutputStream (추상함수 ... 재정의)
 
 *당신이 Byte 데이터 관련 작업을 하고싶다면 
 [입력] InputStream을 상속 구현하고 있는 클래스를 사용해라
 -
 file을 입력할 대상이 
 1. Memory라면 : ByteArrayInputStream
 2. File : FileInputStream	(**)
 
 *당신이 Byte 데이터 관련 작업을 하고싶다면 
 [출력] OutputStream을 상속 구현하고 있는 클래스를 사용해라
 -
 file을 출력할 대상이 
 1. Memory라면 : ByteArrayOutputStream
 2. File : FileOutputStream	(**)
 
 사실 지금까지 memory Array, Collection 통해서 메모리기반 작업 .....
 
 */
public class Ex01_Stream {

	public static void main(String[] args) {
		
		//byte (-128 ~ 127) 정수를 저장하는 타입
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null; // 현재 메모리를 가지고 있지 않아요
		
		// 빨대 >> memory >> read, write
		ByteArrayInputStream input = null;// 빨대 (통로) 입력
		ByteArrayOutputStream output = null; // 빨대 (통로) 출력
		
		input = new ByteArrayInputStream(inSrc); // Byte배열을 타입으로 하는 주소값을 parameter로 넘김
												  // input 대상 inSrc >> read
		output = new ByteArrayOutputStream(); // write
		
		System.out.println("outSrc before : " + Arrays.toString(outSrc)); //Arrays.toString(outSrc): 배열의 값을 확인할 수 있는 매서드
		
		//공식같은 로직(암기)
//		int data = 0;
//		while((data = input.read()) != -1) { // 없으면 -1인가봄			
//			System.out.println("data : " + data);
//
//		}
		/*
		 * 그리고 위에서 read로 input에서 소모해버려서 이 while문으로 read할 data가 다 소진되고 없음 ㅎㅎ
		while(input.read() != -1) { 
			System.out.println(input.read()); //1,3,5,7,9
			// read() 함수는 내부적으로 next() 를 가지고 있어서 조건문에서 한번 소비되어 버리기 때문이다. 
		}
		 */
		
		int data = 0;
		while((data = input.read()) != -1) { // inSrc로부터 input읽어온 데이터가 없으면 -1 return.			
//			System.out.println("data : " + data);
			//read 한 데이터를 다른 Stream을 사용해서 출력
			output.write(data); // 출력통로 안에 (빨대) 안에 데이터를 담고 있는 것
			//write 대상이 data 아니고 ByteArrrayOutputStream 자신의 통로에 ....
		}
		// byte[] outSrc = null;
		outSrc = output.toByteArray(); // 자신이 가지고 있는 데이터를 Byte[]로 바꾸어서 주소를 outSrc에 전달
		//바꾸어서 주소를 outSrc 전달
		System.out.println("outSrc before :" + Arrays.toString(outSrc));
		
		
		// 위 과정은 사실 배열의 복사를 이용하면 간단하게 구현가능하다.
	}

}
