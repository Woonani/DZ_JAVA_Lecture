import kr.or.kosa.DoWhileMenu;

public class Ex15_DoWhileMenu {

	public static void main(String[] args) {
		DoWhileMenu Menu = new DoWhileMenu();
		while(true) {
			switch(Menu.displayMenu()) {
			case 1 : Menu.inputRecord();
			break;
			case 2 : Menu.deleteRecord();
			break;
			case 3 : Menu.sortRecord();
			break;
			case 4 : System.out.println("프로그램 종료");
			//return; >> main 함수 종료
			System.exit(0); // 프로그램 종료(kill)
			}
		}
	}

}
