package ua.victoria.app.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import ua.victoria.app.validation.validator.UniqueTeamNameValidator;

@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueTeamNameValidator.class)
public @interface UniqueTeamName {

	String  message() default "Team already exists";
	
	Class<?>[] groups() default {};  
	
	Class<? extends Payload>[] payload() default {};
}
