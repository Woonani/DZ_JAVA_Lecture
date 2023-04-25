package kr.or.kosa.dto;
import java.util.Scanner;

public class Reservation {
	Scanner sc = new Scanner(System.in);
	String[][] seat;
	String[][] reservedSeatInfo;
	String reservationNum = Cinema.reservationNum;
	
	
	Reservation(String[][] seat, String[][] reservedSeatInfo){
		this.seat = seat;
		this.reservedSeatInfo = reservedSeatInfo;
	}
	
	
	
	// 영화 예매 기능 메뉴 함수
		public void reservationMenu() {
			int resultNum;
			System.out.println("*********좌석 현황**********");
			for(int i =0; i<seat.length;i++) {
				for(int j=0; j<seat[i].length; j++) {
				System.out.printf("[%s]", seat[i][j]);
				}
			 System.out.println();
			}
			System.out.println("-------------------------");
			System.out.println("좌석을 선택해 주세요. 입력예시)1-1");
			System.out.println("이미 예매된 좌석은 \"예매\"라고 표시됩니다.");
			try {
				String selectedSeat = sc.nextLine().replace(" ", "").replace("-","");

				int row = Character.getNumericValue(selectedSeat.charAt(0));
				int col = Character.getNumericValue(selectedSeat.charAt(1));
				
				System.out.printf("선택하신 좌석은 :%s-%s \n", selectedSeat.charAt(0), selectedSeat.charAt(1));
				
				//
				boolean availableSeat = reservation(row,col);				
			}catch(Exception e) {
				System.out.println("입력오류. 처음부터 다시 진행해 주세요.");
//				e.printStackTrace();
			}
			
		}
		
	
		
		// 예매 처리 함수
		public boolean reservation(int row, int col) {
			boolean result;

			if(seat[row-1][col-1].equals((row)+"-"+(col))) {
				System.out.printf("예매 가능 합니다. ");
				System.out.println("예매하시겠습니까?");
				System.out.println("네(1), 아니오(2), 초기화면(0)중 하나를 입력해주세요.");
				int menuNum = Integer.parseInt(sc.nextLine().replace(" ",""));
				
				switch(menuNum) {
				case 1:
					int reservationNum;
					do { // 예약번호가 6자리이고, 첫자리가 0으로 시작하지 않도록 체크
						reservationNum= (int) (Math.random()*1000000+1);
					}while(String.valueOf(reservationNum).length()<6);
					
					// 예매좌석 표시, 예약 번호 정보 입력
					seat[row-1][col-1] = "예매"; 
					reservedSeatInfo[row-1][col-1] = String.valueOf(reservationNum);

					// 예매정보와 좌석 표시
					System.out.println("예매가 완료되었습니다.");
					System.out.println();
					for(int i =0; i<seat.length;i++) {
						for(int j=0; j<seat[i].length; j++) {
						System.out.printf("[%s]", seat[i][j]);
						}
					 System.out.println();
					}
					System.out.println();
					System.out.printf("예매한 좌석번호: [%d-%d] / 예매번호 : [%d] \n",row,col, reservationNum);
					System.out.println("감사합니다.");
					System.out.println();

					break;
				case 2:
					System.out.println("좌석을 다시 골라주세요");
					System.out.println();

					reservationMenu();
					break;
				case 3:
					System.out.println("초기화면으로 돌아갑니다.");
					System.out.println();

					break;					
					default:
				}
				result = true;
			}else {
				System.out.println("이미 예약 되었습니다");
				System.out.println();

				result = false;
			}
			return result;
		}
		
		
}
