import java.util.Arrays;

/*
 배열은 객체다 (Array)
 1. new를 통해서 생성한다. (주소값을 갖는다)
 2. heap 메모리에 생성 (관리자원)
 3. 정적배열(고정배열) : 배열은 한번 선언하면 (크기가 정해지면) 변경 불가 < > 동적(Collection : API 클래스)
 4. 자료구조(알고리즘) : 제어문(결합) : 기초적인 자료구조
 
 */
public class Ex01_Array {

	public static void main(String[] args) {
		int s, s1, s2, s3, s4;
		int s5; int s6; int s7;
		//같은 타입의 변수 여러개를 선언해서 사용
		
		// 배열
		int[] score = new int [5];
		//score (101동) >> 101호, 102호 규칙 ....
		// int 타입의 방을 5개 >> heap >> 연속된 공간 >> 방이름 제공(index(첨자)) >> [0][1][2][3][4]
		System.out.println(score[0]);
		score[0] = 100;
		score[1] = 200;
		score[2] = 300;
		score[3] = 400;
		score[4] = 500;
		//score[5] = 600;
		// java.lang.ArrayIndexOutOfBoundsException:Index 5 out of bounds for length 5
		// 방의 개수는 항상 index 값보다 1이 크다 (n-1 마지막 index)
		System.out.println(score[3]);
		//Array 방에 있는 (score) 모든 값을 한번에 출력
		// 궁합 (for >> 중첩 for)
		for(int i = 0 ; i < 5 ; i++) {
			System.out.printf("score[%d]=%d\t",i,score[i]);
		}
		System.out.println();
		
		//배열은 객체다 
		for(int i = 0 ; i < score.length ; i++) {  //Array 배열의 개수를 제공한다 (score.length)
			System.out.printf("score[%d]=%d\t",i,score[i]);
		}
		System.out.println();
		// java.util.Arrays  헬퍼클래스 >> 당신이 필요한 다양한 함수 >> static
		String resultArray = Arrays.toString(score);
		// [100, 200, 300, 400, 500] 함수가 자동 생성
		System.out.println(resultArray);
		
		// Tip) 당분간 쓰지 마세요
		//Arrays.sort(score);
		// 변수 3개 자리이동 순서 바꾸는 ....swap .... 
		//  정렬 알고리즘 (신입 : 버블, 퀵, 셀렉 정렬등 할 수 있어야함.)
		
		//Today point
		//배열 만드는 3가지
		int[] arr = new int[5]; //기본
//		System.out.println("arr : "+arr[4]);
		int[] arr2 = new int[] {10,20,30,40,50}; //초기값을 통해서 배열의 개수를 정의하고 값을 할당
		//System.out.println("arr2"+arr2); // arr2[I@6a5fc7f7

		int[] arr3 = {11,22,33}; //컴파일러가 알아서 new 처리
		//System.out.println("arr3"+ arr3); // arr3[I@3b6eb2ec

		//Tip) const arr = [1,2,3,4,5]; let arr = [100, 200, 300, 400, 500];
		
		for(int i = 0; i < arr2.length ; i++) {
			System.out.println(arr2[i]);
		}
		
		// 배열은 객체다 (new ... heap)
		int[] arr4; // stack arr4 변수생성(null) >> 메모리가 없어요
		arr4 = new int[] {21,22,23,24,25}; // 이렇게 하면 메모리를 가짐
		System.out.println(arr4); //I@5594a1b5 주소값을 가지고 있다.
		
		int[] arr5 = arr4; // 주소값 할당
		System.out.println(arr5); //I@5594a1b5 arr4와 같은 주소값을 가지고 있다.

		// 같은 메모리를 보고 있다
		System.out.println(arr5 == arr4); //true
		
		//배열의 타입은 : 8가지 + String + 클래스(타입)
		String[] strarr = new String[] {"가", "나", "가나다"};
		for(int i = 0; i < strarr.length; i++) {
			System.out.println(strarr[i]);
		}
		
		char[] carr = {'A','B', 65};
		float[] farr = new float[3];
		Car[] cararr = new Car[3]; // cararr[0] 무엇을 담을 수 있을까요 : Car 타입의 주소값
		// Car c = new Car();
		// cararr[0] = new Car();
		
	}

}

class Car{ // 클래스 == 설계도 == 데이터 타입
	
}
