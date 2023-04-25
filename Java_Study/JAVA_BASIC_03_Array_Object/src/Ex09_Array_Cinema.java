
public class Ex09_Array_Cinema {

	public static void main(String[] args) {
		String[][] seat = new String[3][5];
		/*
		 [][][][]
		 [][][][]
		 [][][][]
		 */
		for(int i =0; i<seat.length;i++) {
			for(int j=0; j<seat[i].length; j++) {
				//좌석을 초기화
				seat[i][j]="__"; // 빈의자 배치
			}
		}
		//예매
		seat[2][1]="홍길동";
		seat[0][0]="김유신";
		
		// 예매 좌석 현황 보여주기
		for(int i =0; i<seat.length;i++) {
			for(int j=0; j<seat[i].length; j++) {
				//좌석을 초기화
			System.out.printf("[%s]", seat[i][j].equals("__")?"좌석":"예매");
			}
		 System.out.println();
		}
		
		// 예매 .... 어떤 좌석 선택 [행][열] 예매 가능 여부 확인하기
		// 좌석 정보를 입력해주세요
		int row, col;
		row = 1;
		col = 0;
		if(seat[row][col].equals("__")) {
			System.out.println("예매 가능 해요");
		}else {
			System.out.println("이미 예약 되었습니다");
		}
		
		// 예매 종료 (영화 시작)
		// 좌석을 초기화
		for(int i =0; i<seat.length;i++) {
			for(int j=0; j<seat[i].length; j++) {
				//좌석을 초기화
				seat[i][j]="__"; // 빈의자 배치
			}
		}

	}

}
