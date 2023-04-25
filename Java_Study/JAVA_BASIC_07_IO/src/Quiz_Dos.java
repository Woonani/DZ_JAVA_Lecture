import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Quiz_Dos {

	static String defaultPath = "D:" + File.separator + "temp" + File.separator;
	static String path = defaultPath;
	
	public static void main(String[] args) {
	
		System.out.println("Bitamp Microsoft Windows DOS 명령어 [Version 1.1]");
		System.out.println("2020 Bitcamp. All rights reserved\n");
	
		Scanner sc = new Scanner(System.in);
	
		String[] input = null;
	
		while (true) {
			System.out.print(path + ">");
			input = sc.nextLine().trim().split(" "); // input배열에 띄어쓰기 기준으로 각 방에 저장, 첫 번째 방 전에 공란 방지
	
			if (input[0].equalsIgnoreCase("exit")) { // 오직 exit로만 Dos 종료 가능
				System.out.println("Exit");
				System.exit(0);
				return;
			}
	
			switch (input[0].toLowerCase()) {
//			case "dir":
//				searchDirectory();
//				break;
			case "cd": 
			case "cd..":
			case "cd\\": 
			case "cd/": 
				changeDirectory(input);
				break;
//			case "md":
//			case "mkdir":
//				makeDirectory(input);
//				break;
//			case "rd":
//			case "rmdir":
//				removeDirectory(input);
//				break;
			case "ren":
			case "rename":
				//System.out.println(Arrays.toString(input));
				renameDirectory(input);
				break;
//			case "type":
//				readTextFile(input);
//				break;
//			case "help":
//				displayHelp();
//				break;
			default:
			}
		}
	}
	
	static void changeDirectory(String[] input) { // input은 띄어쓰기로 구분되어 들어오는 배열

		if(input.length > 1) {
			// 시작할때만 가능
			if(input[1].equals("\\") || input[1].equals("/")) {
				//최상위 경로로 이동
				path = path.split(":")[0]+":"+ File.separator;
			}else {
				StringTokenizer st = new StringTokenizer(input[1], "\\/");
				while(st.hasMoreTokens()) {
					String parsePath = st.nextToken();
					if(parsePath.equals("..")) { 
						//상위 경로로 이동				
						File temp1 = new File(path);
						path = temp1.getParent() ;	
						if(path.equals(path.split(":")[0] + ":" + File.separator)) {
							break;
						}else {
							path += File.separator;
						}						
					}else {
						File temp2 = new File(path + parsePath);
						if(temp2.exists()) {
							path += parsePath + File.separator;
						}else {
							System.out.println("존재하지 않는 경로입니다. 올바른경로를 입력하세요");
							break;
						}
					}
				}
			}
		}else if(input.length == 1){
			if(input[0].equals("cd..")) {				
				//상위 경로로 이동
				File temp = new File(path);
				path = temp.getParent();
			} else if( input[0].equals("cd\\") || input[0].equals("cd/")) {
				//최상위 경로로 이동
				path = path.split(":")[0]+":"+ File.separator;	
			} else if( input[0].equals("cd")) {
				//현재경로에 그대로
			} 
		}
	}
	
	static void renameDirectory(String[] input) {
		File beforeRen = new File(path + input[1] );//input[1] : 기존 파일명
		if(beforeRen.exists()) {
			File afterRen = new File(path + input[2] );//input[2] : 바꿀 파일명
			if(afterRen.exists()) {
				System.out.println("이미 존재하는 파일명입니다.");
			}else {				
				beforeRen.renameTo(afterRen);
				if(!afterRen.exists()) {
				System.out.println("error!");
				}
			}
		}else {
			System.out.println("존재하지 않는 파일입니다.");
		}
	}
}