package DI_06_Spring;

// OracleDao, mysqlDao 사용하는 공통함수 (추상함수)를 강제구현하게 할것임. 
public interface ArticleDao {
	void insert(Article article);
	
	// 추가구현
	//CRUD
	
}
