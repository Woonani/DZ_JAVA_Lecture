import java.util.Scanner;

public class Ex14_Quiz {
	  public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
//	        int random = (int)(3 * Math.random() + 1), user = sc.nextInt();
//	        System.out.println(((random) == user)? "컴퓨터는 " + random + ", 유저는 " + user + "로 비겼습니다." : (random-user==Math.abs(1))? "컴퓨터는 " + random + ", 유저는 " + user + (random-user == 1? "로 졌습니다." : "로 이겼습니다.") : "컴퓨터는 " + random + ", 유저는 " + user + "로 이겼습니다");
		  
		  
		  double random = Math.random();
//			System.out.println(random); // 0<= random < 1
			// 컴퓨터가 낸 수
			random = (3*random+1); //1 <= random < 4;
			System.out.println((int)random);
			// 사용자가 낸 수
			System.out.println("가위(1)바위(2)보(3) 중 한 숫자를 내세요! : ");
			int player = Integer.parseInt(sc.nextLine());
			
//			// 창현&승환님 풀이
//			int value =  (int)random- player ;
//			String result = (value==0) ? "Same!":((value==-1||value==2) ? "You Win" : (value==-2||value==1) ? "You Lose" : "Wrong Number"); 
//			System.out.println(result);
			
			// 1조 참고
			String result="";
			switch((int) random) {
			case 1 : 
			case 2 : 
				result = (player == (int) random) ? "비김" : ((player == (int) (random + 1)) ? "이김" : "짐");
				break;
			case 3 : 
				result = (player == (int) random) ? "비김" : ((player < (int) random) ? "이김" : "짐");
			}
			
			System.out.println(result);
		  
	    }
}
