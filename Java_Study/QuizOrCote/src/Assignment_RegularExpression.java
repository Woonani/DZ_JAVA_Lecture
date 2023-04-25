import java.util.regex.Pattern;

/*
 정규 표현식 표준(java, javascript , Oracle , c#) 공통적인 규칙
 어떠한 문자를 만들때 [규칙] 부여 >> 유효한 판단 근거 
 주민번호 : 숫자 6자리 - 숫자 7자리 {\d6}-{\d7} 규칙에 ...
 12345-1234567 >> false
 핸드폰
 차량번호
 우편번호
 도메인주소
 이메일 주소 등 검증 정규 표현식 개발자 .... 
​
 */
import java.util.regex.Pattern;
public class Assignment_RegularExpression {

	public static void main(String[] args) {
	  // 전화번호
      String patternPhone = "(^01([0-9]))([.-]?)(\\d{3}|\\d{4})([.-]?)(\\d{4})"; // 휴대폰 번호
      String phoneNumber = "012-1123-0000"; 

      boolean result1 = Pattern.matches(patternPhone, phoneNumber);
      System.out.println(result1); 

      // 주민등록번호
      String PatternJumin = "^[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])[-][1-4]\\d{6}"; // 주민번호([0-1])
      String Jumin = "960230-1199999";

      boolean result2 = Pattern.matches(PatternJumin, Jumin);
      System.out.println(result2); 
      
      // 이메일
      String PatternEmail = "^[a-z0-9]+[@][a-zA-Z0-9.-]+$"; // 
      String email = "tjrwls3394@daum.co.kr";

      boolean result3 = Pattern.matches(PatternEmail, email);
      System.out.println(result3);
      
      // 우편번호
      String PatternAddressNum = "^[0-9]{3}[-][0-9]{3}|[0-9]{5}"; // 
      String addressNum = "020-437";

      boolean result4 = Pattern.matches(PatternAddressNum, addressNum);
      System.out.println(result4);
      
      // 도메인 url 추출
      String domainAddress = "^http[s]?[://]+[a-z0-9].[a-z.-]*$";
      String address = "https://naver.com";
      
      boolean result5 = Pattern.matches(domainAddress, address);
      System.out.println(result5);
      /*
       *주소
정규표현식 : ((([가-힣]+(\d{1,5}|\d{1,5}(,|.)\d{1,5}|)+(읍|면|동|가|리))(^구|)((\d{1,5}(~|-)\d{1,5}
|\d{1,5})(가|리|)|))([](산(\d{1,5}(~|-)\d{1,5}|\d{1,5}))|)|(([가-힣]|(\d{1,5}(~|-)\d{1,5})|\d{1,5})+(로|길)))
       */
   }


}
