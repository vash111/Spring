package org.zerock.excepion;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class CommonExcepionAdvice {
	
	@ExceptionHandler(Exception.class)
	public String excepion(Exception ex, Model model) {
		log.error("Exception" + ex.getMessage());
		model.addAttribute("exception" , ex);
		log.error(model);
		return "error_page";
	}
}
