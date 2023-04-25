//import kr.or.kosa.DoWhileMenu;
//import kr.or.kosa.FakeFlower;
import kr.or.kosa.*;

public class FakeFlowerQuiz {

	public static void main(String[] args) {
		
		Flower flower1 = new Flower("Rose", 9550, "");
		MainMenu mainMenu = new MainMenu();
		FlowerMachine flowerMachine = new FlowerMachine();
		
		while(true) {
			switch(mainMenu.displayMenu()) {
			case 1 : flowerMachine.buyFlower();
			break;
			case 2 : flowerMachine.flowerInfo();
			break;
			case 3 : mainMenu.administer();
			break;
			case 10302 : 
				System.out.println("프로그램 종료");
			//return; >> main 함수 종료
				System.exit(0); // 프로그램 종료(kill) ??  이거 왜 안돼
				break;
			default : 
				System.out.println("번호를 다시 입력해주세요");
			}
		}

	}
}
