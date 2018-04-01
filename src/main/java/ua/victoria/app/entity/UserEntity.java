package ua.victoria.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "user")
@Getter @Setter 
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
	
	private String token;
	
	@Column(name = "is_activated")
	private boolean isActivated;
	
	@OneToOne()
	@JoinColumn(name = "id_user_detail")
	private UserDetail  userDetail;
	
	@OneToMany(mappedBy = "author" )
	private List<News> newsList = new ArrayList<>();

	



	public UserEntity() {
		
	}







	@Override
	public String toString() {
		return "UserEntity [login=" + login + ", email=" + email + ", password=" + password + ", userRole=" + userRole
				+ ", token=" + token + ", isActivated=" + isActivated + ", getId()=" + getId() + "]";
	}

	
	 
	
	

}
