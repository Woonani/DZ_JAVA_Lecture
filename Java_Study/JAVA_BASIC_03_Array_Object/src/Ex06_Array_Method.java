class Human{
	String name;
}

class OverClass{
	int add (int i , int j ) {
		return i + j;
	}
	void add(Human human) { // Human 타입의 주소값을 넣어주면 되는 구나***************** add(new Human())
		System.out.println(human.name);
	}
	// 1. add(new Human());
	// 2. Human h = new Human(); add(h);
	// 반드시 해야 합니다^^
	
	//배열은 객체다 == 배열도 타입이다.
	int add(int param) {
		return param + 100;
	}
	
	int[] add(int[] params) {// 주소값 받는다잉 // add(String ... values) >> add(1,2,3), add(1,2)
		// int[] arr = {1,2}    add(arr) // 배열타입의 주소값
		// 안의 코드 여러분 마음
//		 add (new 
		int[] target = new int [params.length];
		for(int i = 0; i< target.length; i++) {
			target[i] = params[i] + 1;
		}
		return target; // 주소값(heap에있는 int[] target 배열 주소)
//		return null; // 스택메모리에 생성되는 것 null 값 가질 수 있다. (배열 생성 때 heap 에서 null값 가지듯)
		
		// *앞으로 코딩 할때 리턴 null 일단 정의 해놓고 코드작업하기*
	}
}


public class Ex06_Array_Method {

	public static void main(String[] args) {
		OverClass overt = new OverClass();
		int[] source = {10,20,30,40,50};
		int[] ta = overt.add(source);
		for(int value : ta) {
			System.err.println(value);
			
		}
		
	}


}
