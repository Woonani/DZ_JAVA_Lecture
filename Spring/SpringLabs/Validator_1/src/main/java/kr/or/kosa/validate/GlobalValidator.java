package kr.or.kosa.validate;

import java.util.Set;
import java.util.regex.Pattern;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.or.kosa.vo.FormVO;

@Component
public class GlobalValidator implements Validator, InitializingBean {
	
	private javax.validation.Validator validator;

	@Override
	public void afterPropertiesSet() throws Exception {
		ValidatorFactory vFactory = Validation.buildDefaultValidatorFactory();
		validator = vFactory.usingContext().getValidator();
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return FormVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
//		Set<ConstraintViolation<Object>> violations = validator.validate(target);
//		for(ConstraintViolation<Object> violation : violations) {
//			String propertyPath = violation.getPropertyPath().toString();
//			String message = violation.getMessage();
//			errors.rejectValue(propertyPath, message, message);
//		}		
		
		FormVO formVO = (FormVO)target;
		
		int empId = formVO.getEmpId();
		if(empId < 300) {
			errors.rejectValue("empId", "Min.formVO.empId", "Validator : 사원번호는 300 이상이어야 합니다.");
		}
		
		String namePattern = "[가-힣]{2,}";
		String empName = formVO.getEmpName();
		if(!Pattern.matches(namePattern, empName)) {
			errors.rejectValue("empName", "Pattern.formVO.empName", "Validator : 올바른 이름을 입력하십시오.");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "NotNull.formVO.phoneNumber", 
												  "Validator : 빈칸 혹은 공백이 올 수 없습니다.");		
	}
}


