package kr.or.kosa;

import java.util.Scanner;

public class Payment {
	public void buyFlower(int selectedFlower) {
		
	}
	
	public static void payMoney(int price, int money) {
		int change = money - price;
		if(change > 0) {
				
			int unit = 10000;
			int num = 0;
			int sw = 0;
	
		
			do {
				num = (int) ( change/unit);
				if(num > 0) {					
					System.out.printf(" %d 원  %d 개 , ", unit, num); 
//					System.out.println();
				}
				if(unit <= 1 ) {break;}
					change=change - unit*num;
					if(sw == 0) {
						unit=unit/2;
						sw=1;
					}else {
						unit = unit/5;
						sw=0;
					}
					
			}while(true); 
			
			
			System.out.println("거스름돈과 상품을 받아주세요!");
		}else if(change == 0){
			System.out.println("결제완료! 상품이 나옵니다.");
		}else{
			System.out.println("금액이 부족합니다. 처음부터 다시 진행해 주세요!");
		}
	}
	
}
