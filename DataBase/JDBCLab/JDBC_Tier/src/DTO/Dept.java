package DTO;

import lombok.Data;
import lombok.ToString;

/*
DTO or VO or Domain는 다 같은 말
데이터 베이스에 있는 Dept 테이블과 1:1 매핑 클래스
Dept 데이터 1건을 담을 수 있는 클래스

new Dept() >> select * from dept where deptno=10 으로 맵핑되는것
데이터 하나가 객체 하나에 담김
Dept를 List에 담아야 함


*/


@Data
@ToString
public class Dept {
	private int deptno;
	private String dname;
	private String loc;
}
