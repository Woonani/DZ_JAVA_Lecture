import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
// 이미지 파일을 입력받아 이미지 파일로 출력
public class Ex03_Stream_ImageCopy {

	public static void main(String[] args) {
		String oriFile = "D:\\Temp\\apple.jpg";
		String targetFile = "copy.jpg"; // 아무 경로도 안쓰면 default 경로에 
		// default 경로 : C:\Douzone\JAVA\Labs\JAVA_BASIC_07_IO\copy.jpg
		// 프로젝트 폴더가 default 경로가 된다잉
		
		FileInputStream fs = null;
		FileOutputStream fos = null;
		
		try {
			fs = new FileInputStream(oriFile);
			fos = new FileOutputStream(targetFile);
			
			int data = 0;
			while((data = fs.read()) != -1) {
				fos.write(data); // byte값
			}
		} catch (Exception e) {
			e.printStackTrace();

		}finally {
			try {
				fs.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
