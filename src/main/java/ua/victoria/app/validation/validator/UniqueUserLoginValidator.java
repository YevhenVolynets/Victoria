package ua.victoria.app.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.victoria.app.service.UserService;
import ua.victoria.app.validation.annotation.UniqueUserLogin;

@Component
public class UniqueUserLoginValidator 
				implements ConstraintValidator<UniqueUserLogin, String>{

	
	private UserService userService;
	
	@Autowired
	public UniqueUserLoginValidator(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void initialize(UniqueUserLogin arg0) {
		
		
	}

	@Override
	public boolean isValid(String login, ConstraintValidatorContext arg1) {
		if(login == null ) {
			
			return false;
		}
		
		if(userService.findUserByLogin(login) != null) {
			return false;
		} else 
			return true;
		
	}

}
