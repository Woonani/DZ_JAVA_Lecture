import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// 보조Stream - PrintWriter 

public class Ex12_PrintWriter_String_Finder {

	String baseDir = "D:\\temp"; //검색할 디렉토리
	String word="HELLO";//검색할 단어
	String savetxt = "result.txt"; //HELLO단어가 들어있는 파일 정보 저장
	
	void Find() throws IOException { //Find 함수 사용시 try .. throw에서 예외처리 강제
		File dir = new File(baseDir);
		if(!dir.isDirectory()) {
			System.out.println("유효한 폴더가 아니예요");
			System.exit(0);
		}
		
		PrintWriter writer = new PrintWriter(new FileWriter(savetxt));
		BufferedReader br = null;
		
		File[] files = dir.listFiles();
		for(int i = 0 ; i < files.length ; i++) {
			if(!files[i].isFile()) {
				continue; //skip 아래 코드 무시 ...
			}
			//파일이면
			br = new BufferedReader(new FileReader(files[i]));
			
			//a.txt
			//a.txt 한문장씩 read  (한줄)
			String line="";
			while((line = br.readLine()) != null) {
				//단어검색
				if(line.indexOf(word) != -1) {
					//a.txt 한줄씩 읽어서 그문장 안에 HELLO 단어가 하나라도 존재하면
					writer.write("word = " + files[i].getAbsolutePath() +"\n");
				}
//				else {
//					writer.write("아무것도 없드라"  +"\n");
//				}
			}
			writer.flush();
		}
		br.close();
		writer.close();
	}
	
	public static void main(String[] args) {
		Ex12_PrintWriter_String_Finder wordFinder =new Ex12_PrintWriter_String_Finder();
		try {
			wordFinder.Find();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
