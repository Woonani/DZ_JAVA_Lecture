import java.util.*;

//Today Point(ArrayList)
public class Ex02_ArrayList {

	public static void main(String[] args) {
		// List 인터페이스 구현하고 있는 클래스 >> ArrayList >> 순서보장(index), 중복데이터 허용
		// 식당 번호표, 은행 번호표(동명이인)
		ArrayList arraylist = new ArrayList(); // ctrl + shift + o
		arraylist.add(100);
		arraylist.add(200);
		arraylist.add(300);
		
		for(int i=0; i<arraylist.size();i++) {
			System.out.println(arraylist.get(i));
		}
		// 위 / 아래 같은 거지만 위에꺼 연습 충분히 하기!!!!!!!!!!!
		System.out.println(arraylist.toString());
		
		// add 함수는 데이터 순차적으로 넣기
		arraylist.add(400); // index > 3번째 
		arraylist.add(0, 1111); // push 처럼 쓰임
		System.out.println("0번째 방에 1111cnrk : "+arraylist.toString());
		//0번째 방에 1111cnrk : [1111, 100, 200, 300, 400]
		// 1. 비순차적인 데이터 추가, 삭제 >> 성능이 좋지 않아요 >> 순서가 있는 데이터 집합
		// 2. 순차적인 데이터 추가, 삭제 유리
		
		System.out.println(arraylist.contains(200)); // true
		System.out.println(arraylist.size()); //5
		arraylist.clear(); // 데이터 삭제 (용량은 남아 있다)
		System.out.println(arraylist.size()); //0
		
		arraylist.add(101);
		arraylist.add(102);
		arraylist.add(103);
		System.out.println(arraylist.isEmpty()); // false
		System.out.println(arraylist.size()); // 3
		
		Object value = arraylist.remove(0); // remove는 지운 데이터를 반환
		System.out.println(value); // 101 // [101][102][103] >> 101 삭제
		System.out.println(arraylist.toString()); //[102][103] >> 빈공간 매꿈
		
		//Point 다형성
		// 인터페이스 부모 타입
		// 다형성(확장성, 유연성)
		// ArrayList arralist = new ArrayList();
		// 습관적으로 다형성 하려고 노력하기!
		List li = new ArrayList();
		// 부모타입의 참조변수 li는 자식객체의 주소값을 가질 수 있다 (다형성)
		// 인터페이스는 구현코드가 없어요 ... 재정의 ... 자식의 함수 실행된다!!!
//		어렵다리 li라는 변수가 Vector가 올 수도 있잖아
		// Buy라는 함수 할때 Audio 말고도 Tv도 사기 위해 Product에 받았잖아 그런거야
		li.add("가");
		li.add("나");
		li.add("다");
		li.add("라");
		System.out.println(li.toString());
		List li2 = li.subList(0, 2); // 내부적으로 List 인터페이스 ...코드 : 원본배열 보존
		// List 를 큰 양동이라고 생각하자
		System.out.println(li2);
		System.out.println(li);
		
		// ArrayList >> Array
		// 정렬 
		 ArrayList alist = new ArrayList();
		 alist.add(50);
		 alist.add(1);
		 alist.add(7);
		 alist.add(40);
		 alist.add(46);
		 alist.add(3);
		 alist.add(15);
		 System.out.println(alist.toString());//[50, 1, 7, 40, 46, 3, 15]
		 Collections.sort(alist); //낮은 값부터 정렬
		 // 초급 .. 코드 직접 작성
		 System.out.println(alist.toString()); //[1, 3, 7, 15, 40, 46, 50]
		 //높은값
		 Collections.reverse(alist);
		 
		 System.out.println(alist.toString()); //[50, 46, 40, 15, 7, 3, 1]
		 
		 
		//======================================
		 
		
	}

	class Solution {
		public int solution(int[] ingredient) {
			ArrayList<Integer> array = new ArrayList<>();
			for(int i=0; i < ingredient.length; i++ ) {
				array.add(ingredient[i]);
			}
			
			int answer = 0;
			for(int i=0; i<=ingredient.length-4; i++) {
				if(array.get(i) == 1 &&array.get(i+1) == 2 && array.get(i+2) == 3 && array.get(i+3) == 1 ) {
					array.remove(i);
					array.remove(i+1);
					array.remove(i+2);
					array.remove(i+3);
					answer++;
					i-=2;
				} 
				
			}
			return answer;
		}
	}
}
