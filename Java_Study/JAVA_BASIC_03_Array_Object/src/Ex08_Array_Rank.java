
public class Ex08_Array_Rank {

	public static void main(String[] args) {
		/*
		 다차원 배열(2차원)
		 [행][열]
		 영화관 좌석, PC방 좌석, 지도 좌표값(경도, 위도) , 오목, 엑셀
		 */
		
		int[][] score = new int[3][2];
		//3행 2열 배열
		// 첨자 0
		
		score[0][0] = 100;
		score[0][1] = 200;
		
		score[1][0] = 300;
		score[1][1] = 400;
		
		score[2][0] = 500;
		score[2][1] = 600;



		//제어문 : for문
		//중첩 for
		for(int i =0; i<3; i++) {
			for(int j =0; j<2; j++) {
				System.out.printf("score[%d][%d]=[%d]\t", i,j,score[i][j]);
			}
			System.out.println();
		}
		
		// Point! : j<score[i].length;
		for(int i =0; i<score.length; i++) {
			for(int j =0; j<score[i].length; j++) {
				System.out.printf("score[%d][%d]=[%d]\t", i,j,score[i][j]);
			}
			System.out.println();
		}
		
		int[][] score2 = new int[][] {{11,12},{13,14},{15,16}};
		// 3행 2열 
		//
		// 개선된 for문
		for(int[] i : score) { // i는 주소!!!!!!!!!!값을 담은 배열
			for(int j : i) { // 배열원소 i의 원소 j는 그냥 int
				System.out.printf("score[%d]\t", j);
			}
			System.out.println();
		}

	}
	

}
