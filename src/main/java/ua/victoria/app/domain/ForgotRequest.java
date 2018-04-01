package ua.victoria.app.domain;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.victoria.app.validation.annotation.CheckPasswordRepeat;

@NoArgsConstructor
@Getter @Setter
@CheckPasswordRepeat
public class ForgotRequest {
	
	@Pattern(regexp = "[a-zA-Z].+[a-zA-Z0-9+.]+@[A-Za-z]{2,5}+.[A-Za-z]{1,4}$", message = "Typed email has not correct format")
	@NotEmpty private String email;
	 private String password;
	 private String passwordConfirmation;
	 private String token;
	

}
