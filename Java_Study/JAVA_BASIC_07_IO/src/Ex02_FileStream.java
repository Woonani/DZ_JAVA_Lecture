import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
// 파일을 byte로 입력받아 파일로 출력
/*
 Today Point
 
 Byte 데이터를 read / write 대상이 >> File (a.txt)
 
 FileInputStream
 FileOutputStream
 이미지, 엑셀 read, write
 
 File >> 1.txt, 1.data (write, read)
 
 I/O자원은 개발자 직접적으로 자원에대한 해제작업을 해줘야 함 (워드 파일 작업중에 같은 파일 열었어요 ..상황 기존파일 닫기)
 >> Close()
 >> 예외처리 (강제된) 사용하는 I/O 계열의 클래스는 강제로 예외처리를 요구하는 코드가 많다
 
 */
public class Ex02_FileStream {

	public static void main(String[] args) {
		FileInputStream fs = null;
		FileOutputStream fos = null;

		String path = "D:\\Temp\\a.txt";
		
		try {
			fs = new FileInputStream(path);
			fos = new FileOutputStream("D:\\Temp\\new.txt", true);
			// 현재 Temp 폴더 안에 new.txt 파일이 없어요
			/*
			 FileOutStream
			 1. write 파일이 존재하지 않으면 >> 자동 파일 생성 (create 기능)
			 
			 2. fos = new FileOutputStream("D:\\Temp\\new.txt", false);
			    false >> overwrite
			 
			 3. fos = new FileOutputStream("D:\\Temp\\new.txt", true);
			    true >> append (첨부) 
			    // 1번 실행후 true 옵션으로 3번 실행시 new.txt에는 HelloHelloHelloHello 이렇게 되어있다. 
			 
			 */
			int data = 0;
			while((data = fs.read()) != -1) {
//				System.out.println("정수 : " + data + " : " + (char) data); //정수 : 72 : H
				fos.write(data); // 출력 스트림 // D:\\Temp\\new.txt
			}
			
		} catch (Exception e) { //} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 정상, 비정상
			// 함수가 강제로 return을 하더라도
			// finally block은 실행된다.
			// 자원해제 (I/O) 가비지 컬렉터가 관리하지 않아요
			// close() 명시적 >> 소명자 호출
			
			try { // 없는 파일을 닫을 수도 있으니 예외처리~
				fs.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}

