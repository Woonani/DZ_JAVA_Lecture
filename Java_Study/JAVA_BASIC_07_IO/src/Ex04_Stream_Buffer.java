import java.io.*;
//파일을 buffer로 한번에 읽어서 파일 출력
/*
 Disk (File 처리 대상) >> DISK >> 입출력의 단위가 한 byte씩 
 
 여러명 학생을 한명씩 목적지에 보내는 것이 아니고
 여러명이 탈 수 있는 버스를 대여해서 한번에 보내고 처리하겠다...
 
 버스 : Buffer 
 1. I/O 성능 개선 ( 접근 횟수)
 2. Line 단위 (엔터)
 BufferedOutputStream (보조 스트림) >> 독자적인 작업 불가 >> File (input, output) Stream
 
 */
public class Ex04_Stream_Buffer {

	public static void main(String[] args) {
		//BufferedOutputStream bos = new // 기본적으로 생성될때 OutputStream 이라는 추상 자원 타입의 객체를 parameter로 받아야함.
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fos = new FileOutputStream("data.txt"); // 파일 없으면 알아서 생성함
			bos = new BufferedOutputStream(fos); // 버퍼 탄생 
			
			for(int i =0; i<10; i++) {
				bos.write('A'); // data.txt....................ㅓ 
			}
//			bos.flush();
			
			/*
			 JAVA Buffer (8k byte = 8192 byte)
			 1. Buffer 안에 내용이 채워지면 스스로 출발 (버퍼를 비우는 작업)
			 2. 강제로 출발 (buffer) 강제 비우기 : flush() or close()하면 자동 flush() (close에 flush 포함되어있음)
			 3. 개발 close() 자원해제 >> 내부적으로 flush()
			 
			 비우기를 안 하면 출력안되어있음.
			 */
			
		} catch (Exception e) {
			
		} finally {
			try {
				bos.close();
				fos.close();
			} catch (IOException e2) {
			}
		}
	}

}
