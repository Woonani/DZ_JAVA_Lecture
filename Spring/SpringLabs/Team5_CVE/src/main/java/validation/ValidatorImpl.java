package validation;



import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import vo.Emp;

public class ValidatorImpl implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Emp.class.equals(clazz); //Emp클래스만 지원하겠다. 
        //내가 어떤 형식의 클래스에서 객체를 검증하고 에러를 지정할지 정하는 메소드
    }

    @Override
    public void validate(Object target, Errors errors) {
    	Emp emp = (Emp)target;
    	System.out.println(emp);
    	
        // 필수 필드 검증
    	System.out.println("validate 진입");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ename", "field.required");
    	// 이름에 공백넣어도 삽입되는데 이걸 키면 에러발생.  이름에 null이거나 공백만 넣으면
        // 에러 발생시 errors 객체에 error정보( 해당 필드와 error 키워드)를 담음. 
        System.out.println("-----공백validation통과-----");

  
        if (emp.getEmpno() > 9999) { // 사번이 4자리보다 클경우 
            errors.rejectValue("empno", "field.maxlength");
            //empno필드( 넘어온 객체의)에 대한 검증실패를 나타내는 메시지를 errors객체에 추가.
        }
        
        System.out.println("-----4자리이하validation통과-----");        
        // error객체에 추가한 error키워드들은 errors.getFieldErrors() 메서드를 사용하여 필드별 오류 정보를 얻을 수 있습니다.
        
    }
   

	
}