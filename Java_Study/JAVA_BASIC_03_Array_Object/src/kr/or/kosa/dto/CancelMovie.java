package kr.or.kosa.dto;

import java.util.Scanner;

public class CancelMovie {
	String[][] seat;
	String[][] reservedSeatInfo;
	
	public CancelMovie(String[][] seat, String[][] reservedSeatInfo) {
		this.seat = seat;
		this.reservedSeatInfo = reservedSeatInfo;
	}
	
	
	// 예매한 영화 취소하는 함수
	public void cancelMovieTicket(int[] result) {
		Scanner sc = new Scanner(System.in);
		
		int row = result[0];
		int col = result[1];
		int inputNum= 9999999;
		
		// 예매좌석이 있는 경우 취소 여부를 입력받음
		if(row !=-1&&col!=-1) {

			System.out.println("예매를 취소하시겠습니까?");
			System.out.println("네(1), 아니오(2) 중 하나를 입력해 주세요.");
				
			inputNum = Integer.parseInt(sc.nextLine());
		}
		
		// 예매 취소 메뉴 처리 :  좌석 있는 경우 & 없는경우 모두 처리
		switch(inputNum) {
		case 1: 
			// 좌석 초기화
			seat[row-1][col-1] = row+"-"+col; // 예매 좌석 표시
			reservedSeatInfo[row-1][col-1] = String.valueOf("");
			System.out.println("확인 "+seat[row-1][col-1] + reservedSeatInfo[row-1][col-1]);
			System.out.println("예매가 취소되었습니다. 감사합니다.");
			System.out.println();
			System.out.println();
			break;
		case 2:
			System.out.println("초기화면으로 돌아갑니다.");
			System.out.println();
			break;
		case 9999999:
			System.out.println("초기화면으로 돌아갑니다.");
			System.out.println();

			break;
		default:
			System.out.println("잘못입력하셨습니다. 초기화면으로 돌아갑니다.");
			System.out.println();

			break;
			
		}
		
		
		
	}
	
	
}
