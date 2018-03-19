package ua.victoria.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.victoria.app.entity.enumerated.Gender;

@Entity
@Table( name = "user_detail")
@Getter @Setter @NoArgsConstructor
public class UserDetail extends BaseEntity{
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private int age;
	
	private String city;
	
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	@Column(name="web_site")
	private String webSite;
	
	private String phone;
	
	@Enumerated(EnumType.ORDINAL)
	private Gender gender;
	
	private String hobby;
	
	@Column(name = "image_path")
	private String imagePath;
	
	@OneToOne(mappedBy = "userDetail")
	private UserEntity userEntity;

	@Override
	public String toString() {
		return "UserDetail [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", city=" + city
				+ ", birthday=" + birthday + ", webSite=" + webSite + ", phone=" + phone + ", gender=" + gender
				+ ", hobby=" + hobby + ", imagePath=" + imagePath + ", userEntity=" + userEntity + ", getId()="
				+ getId() + "]";
	}
	
	

}
