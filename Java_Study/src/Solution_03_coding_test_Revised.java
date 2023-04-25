import java.util.Scanner;
import java.io.FileInputStream;
// https://greendreamtrre.tistory.com/514
//최적화를 시켜보자 :
class Solution_03_coding_test_Revised {
	
	static int AnswerN;
	static int N = 10;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("C:\\sample_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt(); // 장기판 칸 수
			
			String blank = sc.nextLine(); // 테스트후 삭제 : 빈줄 출력

			
			
			// 바둑판 배열 셋팅
			char[][] pan = new char[N][N]; // 바둑판
			int rX=0; int cX=0; // X의 초기 좌표
			int rowX=0; int colX=0; // X의 이동후 좌표
			
			for(int i = 0; i<N; i++) {
				String oneLine = sc.nextLine().replace(" ", "");
				for(int j= 0; j<N; j++) {
					pan[i][j] = oneLine.charAt(j);
					if(oneLine.charAt(j) == 'X') { rX = i; cX = j; }
				}
			}
			

			//  상하좌우 방향으로 rowX 또는 colX에 대입 할 값 변경
			for(int k=1; k<=4; k++) {
			 
				int a=0; int b=0;
				switch(k) {
				case 1: // 상
					a = -1; b=0;
					break;
				case 2: // 하
					a = 1; b=0;
					break;
				case 3: // 좌
					a = 0; b = -1;
					break;
				case 4: // 우
					a = 0; b = 1;
					break;
				}
				rowX=rX; colX=cX; // X좌표 초기화
				do {
					if(pan[rowX+a][colX+b] == 'L') {
						rowX = rowX + a;
						
						colX = colX + b;
					}else if(pan[rowX+a][colX+b] == 'H') {
						if(pan[rowX+a+a][colX+b+b]== 'H') {
							AnswerN += 1;
							rowX = rowX +a +a;
							colX = colX +b +b;
							break;
						}else if(pan[rowX+a+a][colX+b+b]== 'L') {
							rowX = rowX +a +a;
							colX = colX +b +b;
						}else if(pan[rowX+a+a][colX+b+b]== 'Y') {
							break;
						}
					}else { 
						break; // 판이 끝났거나 Y를 만난 경우
					}
				}while(rowX>1 && rowX<6 && colX>1 && colX<6  );
			
			}
			
			System.out.println("#"+test_case+" "+AnswerN);
			AnswerN=0;
		}
	}
	

}
