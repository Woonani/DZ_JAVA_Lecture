package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
@Getter
@Setter
@AllArgsConstructor   모든 멤버필드 파라메터로 ...
@ToString
@NoArgsConstructor  기본 생성자
*/

@Data
public class Emp {
		private int empno;
		private String ename;
		/*
		 * public int getEmpno() { return empno; } public void setEmpno(int empno) {
		 * this.empno = empno; } public String getEname() { return ename; } public void
		 * setEname(String ename) { this.ename = ename; }
		 */
		
}
