package DTO;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder

public class Salary {
	private int employeeId;
	private Date paymentDate;
	private int salary;
	@Override
	public String toString() {
		return "| 사원ID : " + employeeId + "| 지급일 : " + paymentDate + "| 급여액 : " + salary + "|";
	}
	
	
}
