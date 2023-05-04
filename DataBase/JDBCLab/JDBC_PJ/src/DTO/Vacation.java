package DTO;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Vacation {
	private int requestNumber;
	private String vacationType;
	private String reason;
	private Date startDate;
	private Date endDate;
	private char approvalStatus;
	private int employeeId;
	private int approverId;
}
