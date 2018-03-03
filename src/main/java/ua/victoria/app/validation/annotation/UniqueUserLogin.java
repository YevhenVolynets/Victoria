package ua.victoria.app.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import ua.victoria.app.validation.validator.UniqueUserLoginValidator;

//перераховуємо для чого вказуємо анотації
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME) // вказуємо що створ під час виконання
@Constraint(validatedBy = UniqueUserLoginValidator.class)//по якому класу валідація
public @interface UniqueUserLogin {

	String  message() default "Login already exists";
	
	Class<?>[] groups() default {};  //для групування
	
	Class<? extends Payload>[] payload() default {};//для роботи з метаданими
}
