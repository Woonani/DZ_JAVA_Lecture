package kr.or.kosa.dto;

import java.util.Scanner;

public class Cinema {
	Scanner sc = new Scanner(System.in);
	
	String[][] seat;

	String[][] reservedSeatInfo;
	
	static String reservationNum;
	// 예매 클래스
	Reservation reservation; // ***선언 먼저
	// 예매 조회 클래스
	CheckReservation checkReservation;
	// 예매 취소 클래스
	CancelMovie cancelMovie;
	
	public Cinema(String[][] seat, String[][] reservedSeatInfo){
		this.seat = seat;
		reservation = new Reservation(seat, reservedSeatInfo); // ***생성할 때 seat 보내주기
		checkReservation = new CheckReservation(seat, reservedSeatInfo);
		cancelMovie = new CancelMovie(seat, reservedSeatInfo);
	}

	
	public void movieSystem() {
//		System.out.println(seat[2][3]);
		do {
			switch(cinemaMenu()) {
			case "1" :
				reservation.reservationMenu();
				break;
			case "2" :
				checkReservation.checkReservation();
				break;
			case "3" :
				int[] result = checkReservation.checkReservation();
				cancelMovie.cancelMovieTicket(result);
				break;
			default : 
				System.out.println("잘못선택하셨습니다. 메뉴를 다시 골라주세요.");
			
			}
			
		}while(true);
	}
	
	
	
	
	// 메인메뉴
	public String cinemaMenu() {
		System.out.println("*************************");
		System.out.println("*******영화 예매 시스템******");
		System.out.println("*************************");
		System.out.println("1. 예매하기");
		System.out.println("2. 예매조회");
		System.out.println("3. 예매취소");
		String menuNum = sc.nextLine().replace(" ", "");
		return menuNum;
	}
}
