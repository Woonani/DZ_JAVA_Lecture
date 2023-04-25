
public class Ex06_Operation {

	public static void main(String[] args) {
		//대입 연산자
		// +=, -=, *=, /=
		
		int sum = 0;
		sum +=1; // sum = sum +1;
		sum -= 1;
		System.out.println("sum : "+ sum);
		
		/*
		 if(조건식) { } 
		 
		 if(조건식) { } else {}

		 if(조건식) { } else if(조건식) { } else if .... else { }
		 
		 간단한 학점 계산기
		 
		 학점 : A+, A-, B+, B-, ..............F
		 
		 판단기준 : 90점 이상 이고 95점 이상이면 
		 //90A(다시판단 95 A+, A-), 80B(다시판단), 70C    나머지F
		  
		 */
		
		int score=78;
		String grade=""; // A+ or A- or B+
		
		if(score >= 90) {
//			score >= 95 ? grade ="A+" : grade ="A-"; // 이렇게 쓰면 안됨
//			grade = (score >= 95) ? "A+" : "A-"; // 이렇게!
			grade ="A";
			if(score >= 95) {
				grade +="+"; //대입연산자
			}else {grade +="-";}
		}else if (score >= 80) {
			grade ="B";
			if(score >= 85) {
				grade +="+";
			}else {grade +="-";}
		}else if (score >= 70) {
			grade ="C";
			if(score >= 75) {
				grade +="+";
			}else {grade +="-";}
		}else {
			grade = "F";
		}
		
		System.out.println("당신의 점수는 "+score+"점, 학점은 "+grade);
		
		if(score >= 90) {
//			score >= 95 ? grade ="A+" : grade ="A-"; // 이렇게 쓰면 안됨
			grade = (score >= 95) ? "A+" : "A-"; // 이렇게!
			
		}else if (score >= 80) {
			grade = (score >= 85) ? "B+" : "B-"; // 이렇게!
		}else if (score >= 70) {
			grade = (score >= 75) ? "C+" : "C-"; // 이렇게!
		}else {
			grade = "F";
		}
		System.out.println("당신의 점수는 "+score+"점, 학점은 "+grade);
		
		//==========================================================
		
		for(char i = 'A'; i <= 'Z'; i++) {
			System.out.print(i);
		}
		System.out.println(); // 엔터처리
		
		for(int i = 65; i <= 90; i++) {
			System.out.print((char) i + " ");
		}
		System.out.println(); // 엔터처리
		
		for(int i = 1; i <= 100; i ++) {
			System.out.print(i + " ");
			if(i%10 == 0) {
				System.out.println();
			}
		}
		
		// 입사시험 (가장많이 나오는 문제)
		// hint) 제어문 (반복문)
		// 구구단 (행 열 개념)
		
		for(int i = 2; i <= 9; i ++) {
			System.out.println(i+"의 단");
			for(int j = 2; j <= 9; j++) {
//				System.out.print( i+" X "+ j +" = "+ i*j + "   ");
				System.out.printf("%d*%d=%d\t", i,j,i*j); // 장점 : 문자열의 결합보다 포맷을 통해 출력하는 것이 열이 잘 맞춰져서 예쁨
			}
			System.out.println(" ");
		}
		
		
		
		
		
		
		
		
		///////////////////////////////////////
		
	}

}
