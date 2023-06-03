package kr.or.kosa.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor //파라미터가 없는 기본 생성자를 생성
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 만들어줌
@ToString
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int sal;
	private Date hiredate;
	
}
