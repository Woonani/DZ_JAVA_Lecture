import java.util.*;

/*
 HashMap<k,v>
 
 HashMap<String,String>
 HashMap<Integer,String>
 HashMap<String,Student>  POINT 
 
 put("kglim", new Student())
 앞에가 타입이고 뒤에 객체의 주소가 들어간다
 
 
 */
class ArrayTest{
	ArrayList<String[]> al = new ArrayList<>(); // String배열의 주소값을 받겠다.
}
class Student{
	int kor;
	int math;
	int eng;
	String name;
	public Student(int kor, int math, int eng, String name) {
		super();
		this.kor = kor;
		this.math = math;
		this.eng = eng;
		this.name = name;
	}
	 
}

public class Ex13_Map_Generic {

	public static void main(String[] args) {
		HashMap<String, String> sts  = new HashMap<>();
		sts.put("A", "AAA");
		System.out.println(sts.get("A"));
		
		// 실무에서 Map
		//학생의 성적 데이터
		// key(학번), value[국어, 영어, 수학] >> Array, Collection(ArrayList);
		
		HashMap<String, Student> smap = new HashMap<>(); // Student라는 객체의 주소값을 넣어야 함! put할때!!
		smap.put("hong", new Student(100, 90, 50, "홍길동"));
		smap.put("kim", new Student(50, 30, 50, "김유신"));
		
		Student sd = smap.get("kim");
		System.out.println(smap.get("kim")); // 주소 나옴 : Student@626b2d4a
		System.out.println(sd.kor +" / " + sd.eng +" / " + sd.math );
		
		//---------------------------------------------------------------------------
		//???????????
		ArrayTest at = new ArrayTest();
		String[] strarr = {"A", "B", "C"};
		at.al.add(strarr);
		//System.out.println(at.al.get(0));//[Ljava.lang.String;@1c4af82c 주소가 나옴
//		System.out.println(at.al.get(0)[0] +" / "+ at.al.get(0)[1]+" / "+ at.al.get(0)[2]);
		//A / B / C
		String[] strarr2 = {"가", "나", "다"};
		at.al.add(strarr2);
//		System.out.println(at.al.get(1)[0] +" / "+ at.al.get(1)[1]+" / "+ at.al.get(1)[2]);
		//가 / 나 / 다
		
		//---------------------------------------------------------------------------
		// Tip _ entrySet() 함수
		Set set = smap.entrySet(); // Map(key,value) 가공 >> key + "=" + value 
		//set으로 받는 이유 : set은 중복을 허용하지 않기 때문에 key값 구분 됨!
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next()); //kim=Student@626b2d4a  : 키 = 객체 주소
		}

		// Tip2 _ key와 value를 분리해서 보고싶다
		// class Entry {Object key, Object value}
		// Map {Entry[] elements} >>> Map.Entry
		for(Map.Entry m: smap.entrySet()) { // entryset을 개선된 for문 사용시
			System.out.println(m.getKey() + " ^/ " + ((Student) m.getValue()).name); //Student 타입으로 down casting걸어서 갖고있는 자원들의 멤버값 볼 수 있다.
		}
		//hong ^/ 홍길동
		//kim ^/ 김유신  출력됨.

	}

}
