
public class Ex14_Quiz {

	public static void main(String[] args) {
//		System.out.println("이건 어떻게 구현된 함수 일까요");
		
		//System
		//out
		//println
		//을 구현해 보세요
		//먼저 구현하신 조에게 커피 드릴게요 ^^(불금이니까요)

		Ssystem.out.printt();
		
	}

}
class Ssystem{
	public static final print out; // 필드가 프린트 객체의 주소값을 가짐
	static {
		out = new print();
	}
}
class print{
	public void printt() {System.out.println("1111");}
}
/*
  //내 답 조금 틀림 : final static public 이런거
   
 
public class Ex14_Quiz {

	public static void main(String[] args) {
//		System.out.println("이건 어떻게 구현된 함수 일까요");
		
		Ssystem ssystem = new Ssystem();
		ssystem.out.print();
		
	}

} 

class Ssystem{
	static print out= new print();
}
final class print{
	public void print() {}
}
 */

