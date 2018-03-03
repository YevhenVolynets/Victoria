package ua.victoria.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "coach")
public class Coach extends BaseEntity{
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "type_coach")
	private TypeCoach typeCoach;
	
	@ManyToOne
	@JoinColumn(name = "id_team")
	private Team team;

	public Coach() {
		
	}

	public Coach(String firstName, String lastName, String phoneNumber, TypeCoach typeCoach, Team team) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.typeCoach = typeCoach;
		this.team = team;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public TypeCoach getTypeCoach() {
		return typeCoach;
	}

	public void setTypeCoach(TypeCoach typeCoach) {
		this.typeCoach = typeCoach;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	
	

}
