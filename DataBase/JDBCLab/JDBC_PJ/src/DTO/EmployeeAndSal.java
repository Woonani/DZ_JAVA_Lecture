package DTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder

public class EmployeeAndSal { //8개
	private int employeeId;
	private String employeeName;
	private int positionId;
	private Date paymentDate;
	private int salary;
	
	@Override
	public String toString() {
		return "| 사원ID : " + employeeId + "| 사원이름 : " + employeeName
				+ "| 직급ID : " + positionId +  "| 지급일 : " + paymentDate
				+ "| 급여 : " + salary  + "|";
	}
}
