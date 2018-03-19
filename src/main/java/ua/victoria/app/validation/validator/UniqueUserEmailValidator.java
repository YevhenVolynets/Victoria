package ua.victoria.app.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.victoria.app.service.UserService;
import ua.victoria.app.validation.annotation.UniqueUserEmail;

@Component
public class UniqueUserEmailValidator  implements ConstraintValidator<UniqueUserEmail, String>{

	@Autowired
	private UserService userService;
	
	@Override
	public void initialize(UniqueUserEmail arg0) {
		
		
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		
		return userService.findUserByEmail(email)!=null? false: true;
	}

}
