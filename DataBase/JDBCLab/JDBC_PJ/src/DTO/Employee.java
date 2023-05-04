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

public class Employee { //8개
	private int employeeId;
	private String employeeName;
	private String address;
	private String phoneNumber;
	private Date hireDate;
	private int departmentId;
	private int positionId;
	private int managerId;
	
	@Override
	public String toString() {
		return "| 사원ID : " + employeeId + "| 사원이름 : " + employeeName + "| 주소 : " + address
				+ "| 전화번호 : " + phoneNumber + "| 입사일 : " + hireDate + "| 부서ID : " + departmentId
				+ "| 직급ID : " + positionId + "| 부서장ID : " + managerId + "|";
	}
}
