/*
 * 자바4조_ 영화 예매하기_반장쓰코드
 * 인상깊은 점 : 예약번호를 받을 배열을 생성함.
 * 좌석을 배열로 입력받음. (split("-")사용) : 나는 charAt을 사용하여 두자리 수 에러남. 수정ㄱ
 * 에러처리***가 잘 되어있다. : 에러처리 보고 수정ㄱ
 * 영화관의 좌석수를 설정할 수 있다는 점. 
 */
//package kr.or.kosa.dto;

import java.util.Scanner;

public class Quiz_Cinema {

	public static void main(String[] args) {
		Cinema cinema = new Cinema(5,4); 

	}

}

class Cinema {
   
   public int inputIntValue;

   public int[] choice;
   
   public String[][] seat;
   
   public static int resNum;
   
   public int[][] resSeat;
   
   public Cinema(int row, int col) {
      this.seat = new String[row][col];
      for (int i = 0 ; i < row ; i++) {
         for (int j = 0 ; j < col ; j++) {
            this.seat[i][j] = i+"-"+j;
         }         
      }
      
      this.resSeat = new int[row][col];
      for (int i = 0 ; i < row ; i++) {
         for (int j = 0 ; j < col ; j++) {
            this.resSeat[i][j] = 0;
         }         
      }

      this.resNum = 0;
      this.choice = new int[2];
      this.inputIntValue = 0;;
   }
   
   public int showMenu() {
      System.out.println("************************");
      System.out.println("****** 영화 예매하기 ******");
      System.out.println("************************");
      System.out.println("1. 예매하기");
      System.out.println("2. 예매조회");
      System.out.println("3. 예매취소");
      System.out.println("-원하시는 메뉴의 번호를 입력해주세요-");
      return inputIntValue();
   }
   
   public void showSeat(String[][] seat) {
      for (int i = 0 ; i < seat.length ; i++) {
         for (int j = 0 ; j < seat[i].length ; j++) {
            System.out.printf("[%s]",seat[i][j]);
         }
         System.out.println();
      }
   }
   
   //정수를 입력받아 출력하는 함수
   public int inputIntValue() { 
      Scanner sc = new Scanner(System.in);
      this.inputIntValue = sc.nextInt();      
      return this.inputIntValue;
   }
   
   // 좌석 "4-5"를 입력받아 int[]배열 [4,5]로 출력하는 함수
   public void inputStrValue() { 
      Scanner sc = new Scanner(System.in);
      String inputStrValue = sc.nextLine();
      String[] result = inputStrValue.split("-");
      for(int i = 0 ; i < this.choice.length ; i++) {
         this.choice[i] = Integer.parseInt(result[i]);
      }
   }
   
   public void selectSeat() {
      System.out.println("예매하고 싶으신 좌석을 선택해주세요.");
      System.out.println("입력예시) 1-1");
      inputStrValue();      
   }
   
   public boolean isReserved(int[] choice) {
      if(seat[choice[0]][choice[1]].equals("불가")) {
         System.out.println("예매가 불가능합니다");
         return true;
      } else {
         System.out.println("예매가 가능합니다");
         return false;}
   }
   
   public int ruSureReservation() {
      System.out.println("예매하시겠습니까?");
      System.out.println("1.네\t2.아니오");
      return inputIntValue();
   }
   
   public void reservation(int[] choice) {
      this.seat[choice[0]][choice[1]] = "불가";      
      resNum++;
      this.resSeat[choice[0]][choice[1]] = resNum;
      showReservation(choice);
   }
   
   public void showReservation(int[] choice) {
      System.out.println("예매정보");
      System.out.println("예약번호 : "+this.resNum);
      System.out.println("좌석 : "+choice[0]+"-"+choice[1]);      
   }
   
   public void checkRes() {
      System.out.println("예약번호로 좌석을 조회합니다");
      System.out.println("예약번호를 입력하세요");
      inputIntValue();
      for ( int i = 0 ; i < this.resSeat.length ; i++) {
         for ( int j = 0 ; j < this.resSeat[i].length ; j++) {
            if(resSeat[i][j] == this.inputIntValue) {
               System.out.println("예약번호 : "+this.inputIntValue);
               System.out.println("예약좌석 : "+i+"-"+j);
               break;
            }
         }
      }
      System.out.println("초기화면으로 돌아가려면 아무값이나 입력하세요");
      inputIntValue();
   }
   
   public void removeRes() {      
      System.out.println("취소할 예약번호를 입력하세요");
      inputIntValue();
      for (int i = 0 ; i < this.resSeat.length ; i++) {
         for (int j = 0 ; j < this.resSeat[i].length ; j++) {
            if(resSeat[i][j] == this.inputIntValue) {
               this.choice[0] = i;
               this.choice[1] = j;
            }
         }
      }
      System.out.println("["+choice[0]+"-"+choice[1]+"] 좌석을 취소하시겠습니까?");
      System.out.println("1.예\t2.아니오");
      inputIntValue();
      if(inputIntValue ==1) {
         resSeat[choice[0]][choice[1]] = 0;
         seat[choice[0]][choice[1]] = choice[0]+"-"+choice[1];         
         System.out.println("예약이 취소되었습니다.");
         System.out.println("초기화면으로 돌아가려면 아무값이나 입력하세요");
         inputIntValue();
      } else {System.out.println("초기화면으로 돌아갑니다");}

      
   }
   
   public void run() {
      boolean runState = true;
      do {
         try {
            switch(showMenu()) {
               case 1:{
                  showSeat(seat);
                  selectSeat();
                  if(isReserved(choice)) {continue;}
                  else if(ruSureReservation()==1) {
                     reservation(choice);
                     continue;
                  } else {continue;}
               }            
               case 2:{
                  checkRes();
                  continue;
               }
               case 3:{
                  removeRes();
                  continue;
               }
               case 4444:{
                  System.out.println("프로그램을 종료합니다");
                  runState = false;
               }
         }
         } catch (Exception e) {
            System.out.println("잘못된 값을 입력하셨습니다.");
            System.out.println("초기화면으로 돌아갑니다");
         }         
      } while(runState);
   }
   
}