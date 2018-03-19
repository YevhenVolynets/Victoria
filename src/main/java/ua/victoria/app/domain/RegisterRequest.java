package ua.victoria.app.domain;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.victoria.app.validation.annotation.CheckPasswordRepeat;
import ua.victoria.app.validation.annotation.UniqueUserEmail;

@NoArgsConstructor
@Getter @Setter
@CheckPasswordRepeat
public class RegisterRequest {

	@Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{1,63}$", message = "Typed email has not correct format")
	@UniqueUserEmail
	@NotEmpty private String email;
	@NotEmpty private String password;
	@NotEmpty private String passwordConfirmation;
	
}
