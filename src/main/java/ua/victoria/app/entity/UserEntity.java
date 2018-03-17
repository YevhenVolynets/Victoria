package ua.victoria.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.victoria.app.validation.annotation.UniqueUserLogin;

@Entity
@Table(name = "user")
@Getter @Setter @NoArgsConstructor
public class UserEntity extends BaseEntity{
	
	@Column(name = "login")
	/*@UniqueUserLogin(message = "User with this login already exists")*/
	private String login;
	
	@Column(name = "email")
	/*@NotNull
	@Email(message="Email is bad")*/
	private String email; 
	
	@Column(name = "password")
	@Size(min=5,max=32,message = "Password should be between 5 and 32 symbols")
	private String password;
	
	@Column(name = "user_role")
	@Enumerated(EnumType.ORDINAL)
	private UserRole userRole;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "image_path")
	private String imagePath;
	
	
	private String token;
	
	@Column(name = "is_activated")
	private boolean isActivated;

	
	@Override
	public String toString() {
		return "User [login=" + login + ", email=" + email + ", password=" + password + ", userRole=" + userRole
				+ ", phone=" + phone + ", firstName=" + firstName + ", lastName=" + lastName + ", getId()=" + getId()
				+ "]";
	}

	
	
	

}
