import java.util.ArrayList;
import java.util.List;
class Board {
//	private List<Comment> comments;
	private List<Comment> comments = new ArrayList<>();
	public void addComment(Comment comment) {
		comments.add(comment);
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Board [comments=" + comments + "]";
	}
	
}

class Comment {
	private Board board;
	
	public void setBoard(Board board) {
		this.board = board;
		board.addComment(this);
	}
}
public class FreeNote {
	public static void main(String[] args) {
		Board board = new Board();
		Comment co1 = new Comment();
		board.addComment(co1);
		System.out.println(board.getComments().toString()); // 생성 못함 : Comment 클래스에 board 등록이 없나?
//		co1.setBoard(board);
	}

}
/*


JAVA_BASIC_
3/16 : Ex01~2
3/17 : Ex03~4
3/20 : Ex05~8
3/21 : Ex09~14

JAVA_BASIC01_scope
3/20 : Apt, Ex01

JAVA_BASIC02_OOP
3/21 : Ex01~2
3/22 : Ex03~6
3/23 : Ex07~
3/24 : 

3/27 : 
3/28 : 
3/29 : 05_ETC / 04_OOP Ex01~02
3/30 : 04_OOP Ex03~13
3/31 : 04_OOP Ex14~15 / 04_OOP_2 Ex01 ~ 
*/