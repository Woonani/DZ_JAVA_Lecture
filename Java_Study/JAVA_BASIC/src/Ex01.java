import kr.or.kosa.Car;

public class Ex01 {

	public static void main(String[] args) {
		System.out.println("Hello"); // Ctrl+F11(+fn) (저장>컴파일>실행)

		//자동차 생산
		//Car mycar; // 함수 안 지역변수 : stack (아직 car안만들어짐)
		Car mycar = new Car(); // : hip (car생성)
		mycar.setDoor(2);
		mycar.setCarColor("red");
		mycar.run();
	}
	

}
