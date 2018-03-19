package ua.victoria.app.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import ua.victoria.app.domain.RegisterRequest;
import ua.victoria.app.validation.annotation.CheckPasswordRepeat;

@Component
public class CheckPasswordValidator implements  ConstraintValidator<CheckPasswordRepeat, RegisterRequest>{

	@Override
	public void initialize(CheckPasswordRepeat arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(RegisterRequest user, ConstraintValidatorContext context) {
		
		if(user.getPassword() == null || user.getPasswordConfirmation() == null) {
			return false;
		}
		if(user.getPassword().equals(user.getPasswordConfirmation())) {
			return true;
		}
		
		return false;
	}

}
