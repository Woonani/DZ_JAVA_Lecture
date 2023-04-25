import java.util.StringTokenizer;

import javax.annotation.processing.SupportedSourceVersion;

public class Ex06_String_Method {

	public static void main(String[] args) {
		String str = "hello";
		String concatstr = str.concat(" world");
		System.out.println(concatstr); // hello world
		
		System.out.println(str.contains("elo")); // false : ello라서
		System.out.println(str.contains("ello")); // true
		
		String str2 = "a b c d"; //[a][ ][b][ ][c][ ][d]
		System.out.println(str2.length()); //7
		// 참고) 위 공백과 관련하여
//		char blank = ' '; // : 공백가능
//		char blank = ''; // : 빈문자는 안됨

		
		String filename ="hello java world";
		System.out.println(filename.indexOf("e")); // 1
		System.out.println(filename.indexOf("java")); // 6
		System.out.println(filename.indexOf("개폭망")); // -1
		// 값이 없으면 -1 리턴 .... 배열에 원하는 단어가 없다.
		// 신문사설 원하는 검색 ... 내가 원하는 단어가 있는지를 ...확인
		if(filename.indexOf("wo") != -1) {
			System.out.println("wo 단어라 하나라도 있다."); // 있으니까 출력됨
		}
		System.out.println("indexOf : "+filename.indexOf("wo")); // 11
		System.out.println("contains : "+filename.contains("wo")); // true
		
		// .lastIndexOf() : 마지막으로 나온 알파벳
		System.out.println(filename.lastIndexOf("a")); //9 
		System.out.println(filename.lastIndexOf("l")); //14 
		
		// length(), indexOf(), substring(), replace(), split() 암기...
		
		//.substring() : 시작 index ~ 끝 index 전에 자름
		String result = "superman";
		System.out.println(result.substring(0)); // superman
		System.out.println(result.substring(1)); // uperman
		System.out.println(result.substring(3,6)); // erm
		System.out.println(result.substring(0,1)); // s
		System.out.println(result.substring(0,0)); // (0,-1)이 돼서 안나옴
		
		
		// Quiz
		String filename2 = "home.jpg"; //또는 h.jpeg, aaaaa.hwp올 수 있어요
		// 여기서 파일명과 확장자를 분리해서 출력
		// 파일명 : home
		// 확장자 : jpg
		// 단 위에 배운 함수만 사용해서 출력하세요.
		int position = filename2.indexOf(".");
		System.out.println("파일명 : "+ filename2.substring(0,position) +", 확장자 : "+ filename2.substring(position+1));
		
//		//Quiz
//				String filename2 = "home.jpg"; //또는  h.jpeg , aaaaa.hwp 올 수 있어요
//				//여기서 파일명과 확장자를 분리해서 출력
//				//파일명 : home
//				//확장자 : jpg
//				//단 위에 배운 함수만 사용해서 출력하세요
//				int position = filename2.indexOf(".");
//				String file = filename2.substring(0,position);
//				
//				
//				String extention2 = filename2.substring(++position);
//				System.out.println(extention2);
//				
//			
//				String extention =  filename2.substring(position, filename2.length());
//				System.out.println(extention);
//				
//				System.out.println(position);
//				System.out.println(file);
		
		// replace()
		String str3 = "ABCDDADDDDDDA";
		String result3 = str3.replace("DDDDD", "오늘은 화요일");
		System.out.println(result3);
		
		result3 = str3.replace("A", "a");
		System.out.println(result3);
		
		// ETC
		System.out.println(str3.charAt(0));
		System.out.println(str3.charAt(3));
		System.out.println(str3.endsWith("DDDA")); // true  뒤에서 부터 찾는다리
		System.out.println(str3.equalsIgnoreCase("abcDDADDDDDDA")); //true 대소문자 구분없이 비교
		
		// Today Point
		String str4 = "슈퍼맨,팬티,노랑색,우하하,우하하";
		String[] namearray = str4.split(","); // split 결과는 배열이다
		for(String s: namearray) {
			System.out.println("s: "+s);
		}
		
		
		// 정규표현식 꼭 알아야 한다! >> 표준화 되어있게 때문!
		
		/*
		IP 주소를 .(dot) 기준으로 나누는 예제입니다.
	    구분자를 지정하는 파라미터는 정규표현식이라서 .만 넣으면 원하시는대로 나오지 않습니다.
		정규표현식의 예약어라서 .(dot) 앞에 역슬래시(\)를 2개 넣어야 인식됩니다.
		*/
		//정규표현식 문법적 요소인 .을 출력하기 위해서는 \\. 으로!
		String ipAddress = "110.20.0.255";
		String[] ips = ipAddress.split("\\.");
		for (int i = 0; i < ips.length; i++) {
			System.out.println("ips[" + i + "] = " + ips[i]);
		}

		// 출력
		//ips[0] = 110
		//ips[1] = 20
		//ips[2] = 0
		//ips[3] = 255	
		 
		//정규표현식 (문자들을 조합해서 규칙을 만들고 : 그 규칙하고 데이터 비교해서 판단)
				//우편번호 : {\d3}-{\d3} >> 12-123 (false) , 123*123(false) , 111-111(true)
				//https://cafe.naver.com/erpzone/220
					
				//정규 표현식(java , javascript , Oracle , C#) 표준 
				//핸드폰 , 차량번호 , 도메인주소 , 이메일 정규표현으로 구현 >> 입력한 데이터 유효성 검증  	

				//참고 ....StringTokenizer
				 String str6 = "a/b,c-d.f";
				 StringTokenizer sto = new StringTokenizer(str6 , "/,-.");
				 while(sto.hasMoreElements()) {
					 System.out.println(sto.nextToken());
				 }
		
		
		 // 넌센스
		 String str7 = "홍     길     동";
		 //저장 >> 공백제거 >> "홍길동"
		 System.out.println(str7.replace(" ", "")); // 홍길동
		
		 String str8 = "     홍길동      ";
		 System.out.println(">"+str8+"<");
		 System.out.println(">"+str8.trim()+"<");
		 
		 String str9 = "    홍    길    동    ";
		 //"홍길동"
		 //자바를 .... 혼나요
		 String result5 = str8.trim();
		 result5 = result5.replace(" ", "");
		 System.out.println(result5);
		 
		 // 여러개의 함수를 연결해서 (method chain)
		 System.out.println(str9.trim());
		 System.out.println(str8.replace(" ", "").trim().substring(2));
		 
		 //hint
		 
		 int sum=0;
		 String[] numarr = {"1","2","3","4"};
		 for(String s : numarr) {
			 sum += Integer.parseInt(s);
		 }
		 System.out.println("sum : " + sum);
		 
		 
		 //Quiz //주민번호의 합을 구하세요
		 String jumin = "123456-1234567";
		 int sum3 = 0;
		 for(int i=0; i<jumin.replace("-", "").split("").length; i++) {
			 sum3 += Integer.parseInt(jumin.replace("-", "").split("")[i]);
		 }
		 System.out.println(sum3);
		 
		 // 쌤추천 답
		 int sum4=0;
		 for(int i=0; i<jumin.length()-1; i++) {
			sum4 += Integer.parseInt(String.valueOf(jumin.replace("-", "").charAt(i)));
		 }
		 System.out.println(sum4);
			 
		 // 반장 답
//			 String jumin="123456-1234567";
//			 int sum1 = 0;
//			 jumin = jumin.replace("-", "");
//			 for (int i = 0 ; i < jumin.length() ; i++) {
//				 sum1 += Integer.parseInt(jumin.substring(i,i+1));
			 	//
//			 }
//			 System.out.println(sum1);
		//4조
		 int sum1 = 0;
		 jumin = jumin.replace("-", "");
		 for (int i = 0 ; i < jumin.length() ; i++) {
			 sum1 += Integer.parseInt(jumin.substring(i,i+1));
		 }
		 System.out.println(sum1);
		
		 /* 6조
			int sum = 0;
			for (int i = 0; i < jumin.length(); i++) {
				if(jumin.charAt(i)!='-') 	{
						sum += Character.getNumericValue(jumin.charAt(i));
						//sum+=Integer.parseInt(String.valueOf(jumin4.charAt(i)));
				}
			}
				System.out.println(sum);
		 */
		 /* 2조
		    jumin.replace("-", "0");
			System.out.println(jumin);
			
			int[] input = new int[jumin.length()];
			int sum1=0;
			for(int i=0; i<jumin.length(); i++) {
				input[i]=Character.getNumericValue(jumin.charAt(i));
				sum1+=input[i];
			}System.out.println(sum1);
		*/	
		 /* 5조
		 int sum = 0;
		 for (int i = 0; i < jumin.length(); i++) {
		     char c = jumin.charAt(i);
		     if (c == '-') continue;
		     sum += Integer.parseInt(String.valueOf(c));
		 }
		 System.out.println(sum);
		 */
		 /*
		   String[] numarr2 = jumin.replace("-","").split("");
		   int sum3=0;
		   for(String i : numarr2) {
			   sum3+= Integer.parseInt(i);
		   }
		   System.out.println("주민번호 합2:" + sum3);
		  */
	}
	// concat = push()
	// substring(2) 숫자 하나만 쓰면 2부터 다~
	// split 결과는 배열이다

}
