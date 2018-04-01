package ua.victoria.app.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import ua.victoria.app.domain.ForgotRequest;
import ua.victoria.app.validation.annotation.CheckPasswordRepeat;

public class CheckPasswordForgotValidator implements ConstraintValidator<CheckPasswordRepeat, ForgotRequest>{

	@Override
	public void initialize(CheckPasswordRepeat arg0) {
		
		
	}

	@Override
	public boolean isValid(ForgotRequest user, ConstraintValidatorContext context) {
		
		if(user.getPassword() == null || user.getPasswordConfirmation() == null) {
			return false;
		}
		if(user.getPassword().equals(user.getPasswordConfirmation())) {
			return true;
		}
		
		return false;
	}

}
