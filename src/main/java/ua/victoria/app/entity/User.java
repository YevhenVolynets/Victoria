package ua.victoria.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import ua.victoria.app.validation.annotation.UniqueUserLogin;

@Entity
@Table(name = "user")
public class User extends BaseEntity{
	
	@Column(name = "login")
	@UniqueUserLogin(message = "User with this login already exists")
	private String login;
	
	@Column(name = "email")
	@NotNull
	@Email(message="Email is bad")
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", email=" + email + ", password=" + password + ", userRole=" + userRole
				+ ", phone=" + phone + ", firstName=" + firstName + ", lastName=" + lastName + ", getId()=" + getId()
				+ "]";
	}

	
	
	

}
