package DI_06_Spring;
// 설계
// article dto > ariticle dao interface > oracle/maria dao 각각 
//> service
public class ArticleService {
	//Articleservice 는 ArticleDao에 의존한다
	//Articleservice 는 ArticleDao의 주소가 필요하다
	
	//2가지 (생성자, setter)주입 방법이 있음
	
	//1. 일단 주소를 받으려면 멤버필드가 있어야 함.
	private ArticleDao articledao;
	//2. 생성자 파라미터로 주소를 주입 받음
	public ArticleService(ArticleDao articledao) { // oracledao, mysqldao 다형성
		// 3. 주입받은 주소를 멤버필드에 할당함
		this.articledao = articledao;
		System.out.println("Articleservice 생성자 호출");
	}
	
	// 글쓰기 서비스
	public void write(Article article) {
		this.articledao.insert(article);
	}
}
