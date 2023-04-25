import java.io.DataInputStream;
import java.io.FileInputStream;

public class Ex14_DataInputStream {

	public static void main(String[] args) {
		//파일 score.txt 학생 점수 기록
		// read 학생 점수 합계 / 평균
		
		int sum = 0;
		int score = 0;
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			fis = new FileInputStream("score.txt");
			dis = new DataInputStream(fis);
			while(true) {
				score = dis.readInt(); //writeInt()  // 읽다가 예외가 발생하면 catch로 빠짐
				System.out.println("score int 파일 : " + score);
				sum += score;
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
//			e.printStackTrace();
			System.out.println("sum의 결과 : " + sum);
		} finally {
			try {
				dis.close();
				fis.close();
			}catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}

}
