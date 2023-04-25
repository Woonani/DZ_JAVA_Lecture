package kr.or.kosa;
/*
 Tv 설계도 요구사항 정의
 Tv는 채널 정보를 가지고 있다. (예를 들면 1~200 값을가질 수 있다) 			public
 Tv는 브랜드 이름을 가지고 있다 (예를 들면 엘지, 삼성)  						public
 Tv는 채널 전환 기능을 가지고 있다. (채널을 한 채널씩 이동이 가능하다)
 -> 채널을 증가 시키는 기능을 가지고 있다.
 -> 채널을 감소 시키는 기능을 가지고 있다.
 Tv의 채널정보와 브랜드 이름을 볼 수 (출력) 있는 기능을 가지고 있다.
 */
public class Tv {
	public int ch; // default > 0
	public String brandName; // default > null
	
//	public void switchCh(boolean data) { // my style X 함수는 한번에 한 기능만!!
//		if(data) {
//			channel += 1;
//		}else {
//			channel -= 1;
//		}
//	} 
	
	public void ch_Up() {
		ch++;
	}
	public void ch_Down() {
		ch--;
	}
		
	public void tvInfo() {
		System.out.printf("기본채널 : %d / 브랜드 명 : %s \n", ch, brandName);
	}
	
//	public int printCh() {
//		return channel;
//	}
//	public String printBrand() {
//		return brandName;
//	}
	
		
}
