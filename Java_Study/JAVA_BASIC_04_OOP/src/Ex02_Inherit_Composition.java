/*
 현업 개발
 한 개의 클래스로 설계 경우 (x)
 
 설계도 1장 모든 업무를 구현 .. 현실적으로 불가능
 설계도를 여러개로 나눈다...문제 발생 (기준, 논리)
 
 쇼핑몰
 결제관리, 배송관리, 재고관리, 회원관리, 상품관리, 판매처관리, 카드 관리 ... >> 각각의 업무별로 설계도
 
 *********기준*************
 여러개의 설계도가 있을 때 관계 ... 만들어주는 기준
 
 1. 상속 : is ~ a  : 은 (는) ~ 이다 >> 상속의 관계로 보자 (부모를 뒤에)
 2. 포함 : has ~ a : 은 (는) ~ 가지고 있다 >>  

원은 도형이다.
경찰은 권총이다. (x)
경찰은 권총을 가지고 있다.

원은 도형이다
원 extends 도형
삼각형은 도형이다
삼각형 extends 도형

원, 점 관계
원은 점이다 (x)

원은 점을 가지고 있다.(o)
has ~ a (부품정보)
>> class 원 { 점이라는 부품이 member field 구현   점 원의점}
>> class 점 { x, y }

경찰 권총
경찰은 권총이다 (x)
경찰은 권총을 가지고 있다 (o)
>> class 권총 {}
>> class 경찰 { 권총 member field }

원은 도형이다
삼각형은 도형이다
사각형은 도형이다

도형 분모 (공통적) 자원 : 추상화, 일반화 >> 그리다, 색상
원은 : 구체화, 특수화(자신만이 가지는 특징) >> 반지름, 한점

점: 좌표값(x,y)
원은 점을 가지고 있다
삼각형은 점을 가지고 있다
사각형은 점을 가지고 있다.

----------------------------------------
class Shape{ 그리다, 색상 } >> 상속관계 부모 >> 원, 삼각형, 사각형
class Point { 좌표값 } >> 포함관계 >> (부품)

구체화, 특수화 : Circle, Triangle 

 */

class Shape {
	String color = "gold";
	void draw() {
		System.out.println("도형을 그리다");
	}
}

class Point {
	int x;
	int y;
	
	Point(){
//		this.x = 1;
//		this.y = 1;
		this(1,1);
	}
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

// 문제)
/*
 원을 만드세요 (원의 정의 : 원은 한점과 반지름을 가지고 있다)
 1. 원은 도형이다 (is ~ a) : Shape
 2. 원은 점을 가지고 있다. (has ~ a) : Point
 3. 원의 특수화되고 구체화된 내용은 : 반지름
 
 원의 반지름은 초기값 10을 가진다. 
 점의 좌표는 초기값 (10, 15)를 가진다.
 초기값을 설정하지 않으면 반지름과 점의 값을 입력받을 수 있다.
 */


class Circle extends Shape { //1. 원은 도형이다
	Point point; // 포함 > 부품 2. 원은 점을 가지고 있다. 
	//int x; 	int y;	// 틀림!!!
	int r; // 구체화, 특수성
	
	Circle(){
//		r=10;
//		Point point = new Point(10, 15);
		this(10, new Point(10,15)); //?????????????
//		this.Circle(10, new Point(10,15)); //!!!!이거아님!!!!!
	}
	
	Circle( int r, Point point){//point는 Point 객체의 주소값을 받는다
		this.r = r;
		this.point = point;
				
	}
//	Circle(int x, int y, int r){
//		this.point = new Point(x, y);
//		this.r = r;
//	}
}

//문제2)
/*
삼각형 클래스를 만드세요
삼각형은 3개의 점과 색상과 그리고 그리다 기능을 가지고 있다.
hint) Shape, Point 제공 받아서 설계도 작성하세요
hint) (x,y),(x,y),(x,y)
default 삼각형을 만들 수 있고 3개의 좌표값을 받아서 그릴 수 있다.
*/
// 내답
class Triangle extends Shape {
	Point[] points;

	Triangle(){
		this.points = new Point[]{new Point(),new Point(), new Point()};
	}
	Triangle(Point point1, Point point2, Point point3){
		this.points = new Point[]{point1,point2, point3};
		
	}
}

public class Ex02_Inherit_Composition {

	public static void main(String[] args) {
		// 원-------------------------------------------------------
		Circle circle = new Circle();
		System.out.println(circle.r);
		System.out.println(circle.color);
		System.out.println(circle.point.x);//주소값.주소값.주소값.field
		System.out.println(circle.point.y); 
		circle.draw();
		
		// 반지름, 점의 값을 자유롭게생성하는 방법 두 가지---------------
		// 두줄로 : point가 다른 데서 쓰일 때는 이게 낫고 
		Point point = new Point(1,2); 
		Circle circle3 = new Circle(100, point);
		// 한줄로 : 한번만 필요할 때는 이게 낫다 (이런식의 코드가 많기는 함)
		Circle circle2 = new Circle(100, new Point(1,2)); 
		
		
		// 삼각형-------------------------------------------------------
		Triangle triangle = new Triangle(new Point(1,2),new Point(1,2),new Point(1,2));
		System.out.println(triangle.color);
		System.out.println(triangle.points[0].x);
		triangle.draw();
		
		//교수님 삼각형
//		Triangle1 tri = new Triangle1();
//		tri.trianglePoint();
//		
//		Triangle tri2 = new Triangle1(new Point(1,2), new Point(3,4),new Point(5,6));
//		tri2.trianglePoint();
//		
//		
//		Point[] parray = new Point[] {new Point(11,22),new Point(33,44),new Point(55,66)};
//		Triangle2 tri3 = new Triangle2(parray);
//		tri3.trianglePoint();
	}

}
/*
다 쉬신 분은 아래 문제 풀어 보세요 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
삼각형 클래스를 만드세요
삼각형은 3개의 점과 색상과 그리고 그리다 기능을 가지고 있다
hint) Shape , Point 제공 받아서 설계도 작성 하세요
hint) (x,y) , (x,y) , (x,y)
default 삼각형을 만들 수 있고  3개의 좌표값을 받아서 그릴 수 있다 

개인별로 풀어 보시고 제가 한 바퀴 돌면서 채점을 해 드릴게요 ^^
50 , 70 , 100점 으로 나누어 드릴게요 ^^
*/
// 교수님 삼각형 클래스
class Triangle1 extends Shape {
	Point x;
	Point y;
	Point z;
	
	public Triangle1() {
		//this.x = new Point(10,20);
		//this.y = new Point(30,40);
		//this.z = new Point(50,60);
		this(new Point(10,20),new Point(30,40),new Point(50,60));
	}
	
	public Triangle1(Point x , Point y , Point z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	//구체화 ,특수화
	//추가적인 기능
	void trianglePoint() {
		System.out.printf("x :(%d,%d)\t",x.x , x.y);
		System.out.printf("y :(%d,%d)\t",y.x , y.y);
		System.out.printf("z :(%d,%d)\t",z.x , z.y);
		System.out.println();
	}
	
}


//100점
class Triangle2 extends Shape {
	Point[] pointarray;
	
	
	public Triangle2() {
		this(new Point[] {new Point(10,20),new Point(30,40),new Point(50,60)});
	}
	
	public Triangle2(Point[] pointarray) {
		this.pointarray = pointarray;
	}
	
	
	//구체화 ,특수화
	//추가적인 기능
	void trianglePoint() {
		for(Point point : this.pointarray) {
			System.out.printf("(%d,%d)\t",point.x , point.y);
		}
		/*
		System.out.printf("x :(%d,%d)\t",x.x , x.y);
		System.out.printf("y :(%d,%d)\t",y.x , y.y);
		System.out.printf("z :(%d,%d)\t",z.x , z.y);
		System.out.println();
		*/
	}
	
}
