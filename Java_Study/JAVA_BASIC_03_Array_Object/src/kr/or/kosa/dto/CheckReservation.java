package kr.or.kosa.dto;

import java.util.Scanner;

public class CheckReservation {
	Scanner sc = new Scanner(System.in);

	String reservationNum = Cinema.reservationNum;
	
	String[][] seat;
	String[][] reservedSeatInfo;
	CheckReservation(String[][] seat, String[][] reservedSeatInfo){
		this.seat = seat;
		this.reservedSeatInfo = reservedSeatInfo;
	}
	
	
	// 예매 번호를 입력받아 예약한 좌석을 확인하는 함수
	public int[] checkReservation() {  //
		
		// 예배번호 입력 받기
		System.out.println("예매번호 6자리를 입력해주세요.");
		String inputNum = sc.nextLine().replace(" ", "");
		int row=-1; int col=-1;
		boolean reservedSeat=false;

		// 예매 번호로 예약좌석 조회
		for(int i = 0; i<reservedSeatInfo.length;i++) {
			for(int j=0; j<reservedSeatInfo[i].length; j++) {
				//null 체크
				if(reservedSeatInfo[i][j] != null && reservedSeatInfo[i][j].equals(inputNum)) {
					row=i+1;
					col=j+1;
					reservedSeat = true;
					break;
				
				}
			}
		}
		
		
		// 고객의 예매 좌석만 보여주기
		if(reservedSeat) {			
			System.out.println();
			System.out.println("###########화면###########");
			String[][] seatCheck = new String[4][5];
			for(int i =0; i<seatCheck.length;i++) {
				for(int j=0; j<seatCheck[i].length; j++) {
					if(i == row-1 && j == col-1) {
						System.out.printf("[고객]");						
						
					}else {
						System.out.printf("[%d-%d]", i+1,j+1);						
					}
				}
				System.out.println();
			}
			System.out.println();
			System.out.printf("고객님이 예매하신 좌석은 [%d-%d]입니다.", row, col);
			System.out.println();
			
		}else {
			System.out.println("입력주신 예매번호로 조회되는 좌석이 없습니다.");
			System.out.println();
			System.out.println();
		}
		
		// 조회한 좌석 번호 반환 : 3번 메뉴 예매 취소에서 사용
		int[] result = {row,col};
		return result;
	}
	
}
