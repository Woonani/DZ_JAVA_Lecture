import kr.or.kosa.dto.Cinema;

public class Ex10_Cinema {

	public static void main(String[] args) {
		// 좌석 초기화
		String[][] seat = new String[4][5];
		String[][] reservedSeatInfo = new String[4][5];
		for(int i =0; i<seat.length;i++) {
			
			for(int j=0; j<seat[i].length; j++) {
				//좌석을 초기화
				seat[i][j]=(i+1)+"-"+(j+1); 
			}
		}


		// 영화관 시스템 켜기
		Cinema ci = new Cinema(seat,reservedSeatInfo);
		ci.movieSystem();

	}

}
