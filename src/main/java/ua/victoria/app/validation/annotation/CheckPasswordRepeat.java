package ua.victoria.app.validation.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import ua.victoria.app.validation.validator.CheckPasswordForgotValidator;
import ua.victoria.app.validation.validator.CheckPasswordValidator;

@Retention(RUNTIME)
@Target(value=ElementType.TYPE)
@Constraint(validatedBy = {CheckPasswordValidator.class, CheckPasswordForgotValidator.class})
public @interface CheckPasswordRepeat {

	String message() default "Entered passwords not match";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default {};
}
