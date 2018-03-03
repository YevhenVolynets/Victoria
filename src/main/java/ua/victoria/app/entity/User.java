package ua.victoria.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import ua.victoria.app.validation.annotation.UniqueUserLogin;

@Entity
@Table(name = "user")
public class User extends BaseEntity{
	
	@Column(name = "login")
	@UniqueUserLogin(message = "User with this login already exists")
	private String login;
	
	@Column(name = "password")
	@Size(min=5,max=32,message = "Password should be between 5 and 32 symbols")
	private String password;
	
	@Column(name = "user_role")
	@Enumerated(EnumType.ORDINAL)
	private UserRole userRole;

	public User() {
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	
	

}
