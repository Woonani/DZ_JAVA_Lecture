package kr.or.kosa.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.or.kosa.validate.EmpValidator;
import kr.or.kosa.vo.FormVO;

@Controller
public class MainController {

    @PostMapping(value = "/main")
    public String mainPost(@ModelAttribute @Valid FormVO formVO, BindingResult bindingResult, Model model) {
    	String result = null;
        if (bindingResult.hasErrors()) {
        	List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println("Error in field: " + error.getField());
                System.out.println("Error message: " + error.getDefaultMessage());
            }
            result = "main";
        } else {
        	System.out.println("유효성 검증 통과");
        	result = "main";
        }        
        return result;
    }

    @GetMapping(value = "/main")
    public String mainGet(Locale locale, Model model) {
    	model.addAttribute("formVO", new FormVO());
        return "main";
    }
}



