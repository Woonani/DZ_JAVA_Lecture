import kr.or.kosa.Mouse;
import kr.or.kosa.NoteBook;

public class Ex04_Modifier {

	public static void main(String[] args) {
		/* 
		NoteBook notebook = new NoteBook();
		notebook.color = "blue";
		notebook.year = -2023; // 직접할당의 단점
		
		System.out.println("년도 : "+notebook.year);
		 */

		NoteBook notebook = new NoteBook();
//		notebook.year ; // The field NoteBook.year is not visible
		notebook.setYear(-100);
//		notebook.color = "blue";
		notebook.setColor("blue"); 
		// set 일부러 안만들면 수정 불가
		notebook.noteBookInfo();
		System.out.println(notebook.getYear());
		System.out.println(notebook.getColor());
		
		//---------------------------------------------------------------------------------------------------------------------------------------------------------
		
		NoteBook mynote = new NoteBook();
		Mouse mouse = new Mouse();
		
		//마우스 필요해 연결 해 줄게
		mynote.handleMouse(mouse); //주소값을 전달
		
		
	}

}
















