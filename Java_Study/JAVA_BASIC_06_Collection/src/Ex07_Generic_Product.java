import java.util.ArrayList;
import java.util.List;

import kr.or.kosa.CopyEmp;
import kr.or.kosa.Emp;

class Product {
	int price;
	int bonuspoint;

	Product(int price){
		this.price = price;
		this.bonuspoint= (int)(this.price/10.0);
	}
}


class KtTv extends Product{

	KtTv(){
		super(500); 
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "KtTv";
	}
}

class Audio extends Product{
	Audio(){
		super(100); 
	}
	@Override
	public String toString() {
		return "Audio";
	}
}

class NoteBook extends Product{
	NoteBook(){
		super(150); 
	}
	@Override
	public String toString() {
		return "NoteBook";
	}
}
public class Ex07_Generic_Product {

	public static void main(String[] args) {
		// 1. Array 사용해서 객체 생성
		// KtTv, Audio, NoteBook을 담을 수 있는 Cart 만드세요
		Product[] cart = new Product[3];
		cart[0] = new KtTv();
		cart[1] = new Audio();
		cart[2] = new NoteBook();
		// 단점 : 배열의 크기가 고정
		
		//2. ArrayList를 사용해서 Cart를 만드세요
		List<Product> pcart = new ArrayList<>(); // 컴파일러가 알아서 <>에 <Product> 채워줌
		pcart.add(new KtTv());
		pcart.add(new KtTv());
		pcart.add(new KtTv());
		pcart.add(new KtTv());
		pcart.add(new Audio());
		pcart.add(new NoteBook());
		// 동적으로 추가, 삭제
		for(Product product : pcart) {
			System.out.println(product);
		}
		
		//Emp
		//3. ArrayList를 사용해서 사원 3명 만드세요
		List<Emp> emplist = new ArrayList<>();
		emplist.add(new Emp(123,"가","영업"));
		emplist.add(new Emp(1,"가","영업"));
		emplist.add(new Emp(13,"가","영업"));
		
		//3.1 사원의 정보를 toString()사용하지 말고 사번, 이름, 직종을 출력하세요
		// 개선된 for문
		for(Emp emp : emplist) {
			System.out.println(emp.getEmpno()+" / "+emp.getEname()+" / "+emp.getJob());
		}
		
		
		//3.2 3.1 과 동일한데 일반 for문을 사용해서 사번, 이름, 직종을 출력하세요
		for(int i = 0; i<emplist.size(); i++) {
			System.out.println(emplist.get(i));
		}
		
		//-----------------------------------------------------------------------
		// ArrayList 사용해서 사원 3명을 만드세요(CopyEmp)
		// CopyEmp(100, "김씨", 1000)
		// CopyEmp(200, "박씨", 2000)
		// CopyEmp(300, "이씨", 3000)
		List<CopyEmp> copylist = new ArrayList<>();
		copylist.add(new CopyEmp(100, "김씨", 1000));
		copylist.add(new CopyEmp(200, "박씨", 2000));
		copylist.add(new CopyEmp(300, "이씨", 3000));
		
		// 4.1 200번 사원의 급여를 6000으로 수정하세요 (일반 for문을 통해서) getter, setter
		for(int i =0 ; i<copylist.size();i++) {
			if(copylist.get(i).getEmpno() == 200) {
				copylist.get(i).setSal(6000);
				break;
			}
		}
		
		//4.2 300번 사원의 이름을 박씨에서 "궁금해씨" 수정해서 그 결과를 출력하세요 (개선된 for문)
		for(CopyEmp emp: copylist ) {
			if(emp.getEname().equals("박씨")) {
				emp.setEname("궁금해씨");
			}
		}
	}

}
