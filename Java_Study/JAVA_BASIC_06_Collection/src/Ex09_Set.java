import java.util.*;

/*
 Set 인터페이스
 (원 안에 들어가세요) : 순서를 보장(x), 순서가 없다. 중복된 값을 허락하지 않는다
 순서가 없고 중복을 허락하지 않는 데이터 집합
 구현하는 클래스
 HashSet, TreeSet (자료구조)
 
 # 검색과 정렬할때 TreeSet
 */
public class Ex09_Set {

	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<>();
		hs.add(1);
		hs.add(100);
		boolean bo = hs.add(55);
		System.out.println("정상 : "+ bo);
		
		bo = hs.add(1); // 이미 1이라는 데이터가 존재해서 false 반환
		System.out.println("결과 : "+bo);//false 나오면 같은 데이터가 구슬주머니안에 있어요
		
		System.out.println(hs.toString()); // toString()이 재정이 되어있어서 for문을 돌리지 않아도 출력됨.
		// 로또, 차량번호, 회원 id .....
		HashSet<String> hs2 = new HashSet<>();
		hs2.add("b");
		hs2.add("A");
		hs2.add("F");
		hs2.add("C");
		hs2.add("Z");
		hs2.add("A");// 중복이라 안들어감
		hs2.add("H");
		hs2.add("b");// 중복이라 안들어감
		hs2.add("b");// 중복이라 안들어감
		System.out.println(hs2.toString());//[A, b, C, F, H, Z]
		
		String[] strobj = {"A", "B", "C", "D", "B", "A"}; // 10000건
		HashSet<String> hs3 = new HashSet<>();
		for(int i = 0; i<strobj.length;i++) {
			hs3.add(strobj[i]);  //중복 데이터는 add 하지 않는다 
		}
		System.out.println(hs3.toString());
		
		//==========================================
		//Quiz
		//아래 코드를 HashSet 으로 만들고 식사하세요
		/*
		 for(int i = 0 ; i < 6 ; i++) {
			lotto[i] = (int)(Math.random()*45 + 1);
			for(int j = 0 ; j < i ; j++) { //j < i (채워진 개수 만큼 비교)
				if(lotto[i] == lotto[j]) {
					i--;
					break;
					
				}
			}
		} 
	   */
		HashSet<Integer> lotto = new HashSet<>();
//		for(int i = 0 ; i <6 ; i++) {
//			lotto.add((int) (Math.random()*45) + 1);
//			// if문 필요
//		} 
		while(lotto.size() < 6) {
			lotto.add((int) (Math.random()*45) + 1);
			
		}
		
		System.out.println(lotto.toString());
	}

}
