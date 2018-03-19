package ua.victoria.app.validation.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import ua.victoria.app.validation.validator.UniqueUserEmailValidator;

@Retention(RUNTIME)
@Target({ FIELD, METHOD })
@Constraint(validatedBy=UniqueUserEmailValidator.class)
public @interface UniqueUserEmail {

String message() default "Entered email adress already exist";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default{};
}
