package kr.or.kosa.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class FormVO {
	@Min(value=300, message="JSR303: 사원번호는 300 이상이어야 합니다.")
	private int empId;
	
	@Pattern(regexp="[가-힣]{2,}", message="JSR303: 올바른 이름을 입력하십시오.")
	private String empName;
	
	@NotBlank(message="JSR303: 빈칸 혹은 공백이 올 수 없습니다.")
	private String phoneNumber;
}


