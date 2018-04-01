package ua.victoria.app.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import ua.victoria.app.domain.RegisterRequest;


@ControllerAdvice
public class GlobalController {
	
	@ModelAttribute("userModelka")
	public RegisterRequest globalNewUser() {
		
		return new RegisterRequest();
	}

}
