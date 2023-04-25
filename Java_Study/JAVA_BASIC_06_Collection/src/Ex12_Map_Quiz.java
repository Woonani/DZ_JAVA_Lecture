import java.util.*;
public class Ex12_Map_Quiz {

	public static void main(String[] args) {
		/*
		 Map 사용하는 데이터 집합
		 지역번호, 우편번호, 회원가입(id, pwd)
		 */
		HashMap loginmap = new HashMap(); // 메모리에는 회원id,pwd저장
		loginmap.put("kim", "kim1004");
		loginmap.put("scott", "tiger");
		loginmap.put("lee", "kim1004");

		/*
		 우리 시스템은 회원가입한 회원의 id, pwd를 관리하고 있다
		 로그인 시 아이디와 비번을 확인해서 회원이라면 사이트 접속 가능
		 
		 id(o), pwd(o) >> 회원님 방가		1
		 id(o), pwd(x) >> 비밀번호 입력 추가	2
		 
		 id(x), pwd(o) >>회원가입 유도		3
		 id(x), pwd(x) >>회원가입 유도		3
		 
		 사용자로부터 id, pwd입력 받으세요
		 id는 공백제거, 소문자 변환 String 변수에 담아서 사용
		 pwd는 공백제거
		
		 id(o), pwd(o) >> 회원님 방가방가 출력하고 while 탈출
		 id(o), pwd(x) >> 비밀번호 확인 출력만
		 
		 id(x), pwd(o) >> id 맞지 않습니다, 재입력하세요
		 id(x), pwd(x) >> id 맞지 않습니다, 재입력하세요
		 
		 */
		// 내 풀이
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("id를 입력해주세요 : ");
			String id = sc.nextLine().replace(" ","").toLowerCase();
			if(!loginmap.containsKey(id)) {
				System.out.println("id 맞지 않습니다. 재입력하세요");
			}else {
				System.out.println("pwd를 입력해주세요 : ");
				String pwd = sc.nextLine().replace(" ","").toLowerCase();
				if(loginmap.get(id).equals(pwd)) {
					System.out.println("회원님 방가방가");
					break;
				}else {
					System.out.println("비밀번호 확인");
					
				}
			}
		}
		// 강사님 풀이
		/*
		 Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("id ,pwd 입력해 주세요");
			
			System.out.println("ID");
			String id = sc.nextLine().trim().toLowerCase();
			
			System.out.println("PWD");
			String pwd = sc.nextLine().trim();
			
			if(!loginmap.containsKey(id)) {
				//id(x)
				System.out.println("id 맞지 않아요 ...재입력하세요");
			}else {
				//id(0)
				if(loginmap.get(id).equals(pwd)) {
					System.out.println("회원님 방가방가");
					break;
				}else {
					System.out.println("비밀번호 확인하세요");
				}
				
			}
			
		}
		 */
		
	}

}
