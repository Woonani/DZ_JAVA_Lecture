import kr.or.kosa.Singleton;

public class Ex15_Singleton_main {

	public static void main(String[] args) {
		/* 1 */
//		Singleton s = new 생성자를 private으로 막아 보이지 않게 함
		/* 2 */
//		System.out.println(Singleton.p); //일반적으로 안함 //kr.or.kosa.Singleton@1c4af82c
		
		/* 3 */
		Singleton s = Singleton.getInstance();//kr.or.kosa.Singleton@1c4af82c
		Singleton s1 = Singleton.getInstance();//kr.or.kosa.Singleton@1c4af82c
		Singleton s2 = Singleton.getInstance();//kr.or.kosa.Singleton@1c4af82c
		
		System.out.println((s == s1)); // true
		System.out.println((s2 == s1)); //true
		// s, s1, s2 모두 같다!! 이것이 싱글톤!
		 
		

	}

}
