import java.io.IOException;

import kr.or.kosa.utils.ExClass;

public class Ex04_throws {

	public static void main(String[] args) {
		// 抗寇 惯积 矫
		//		ExClass ex = new ExClass("Temp");
		
		// 规过1.
		try {
			ExClass ex = new ExClass("Temp");
		} catch (NullPointerException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// 规过2.
		try {
			ExClass ex = new ExClass("Temp");
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	
	}

}
