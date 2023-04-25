import java.io.File;

public class Ex08_File_Dir {

	public static void main(String[] args) { // args는 이 file이 실행할 때 파라미터로 들어와야 찍어볼 수 있다.
//		System.out.println(args[0]);
		if(args.length != 1) { // 방법을 ...
			System.out.println("사용법 : java 파일명  [디렉토리명]");
			System.exit(0); // 강제종료
			
		}
		// 터미널 커멘드라인에서 아래와 같이 치면 main함수 param으로 args 자리에 C:\\Temp가 와서 활용가능하다.
		// java Ex08_File_Dir D:\\Temp
		
		File f = new File(args[0]); // File("D:\\Temp")
		if(!f.exists() || !f.isDirectory()) {
			// 존재하지 않거나 또는 디렉토리가 아니라면
			System.out.println("유효하지 않은 경로입니다.");
			System.exit(0);
			
		}
		
		// 실제 존재하는 경로이고 ... 폴더라면
		// POINT
		// 제시한 File("C:\\Temp") 이 경로로 파일/폴더를 배열에 담음
		File[] files = f.listFiles();
		// [file][txt][jpg][txt][txt]
		//System.out.println(files.length);
		for(int i = 0 ; i < files.length ; i++) {
			String name = files[i].getName(); //파일명 or 폴더명
			System.out.println(files[i].isDirectory() ? "[DIR]" + name : name);
		}
				
	}
}
