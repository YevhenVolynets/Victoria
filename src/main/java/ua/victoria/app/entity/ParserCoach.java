package ua.victoria.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "parser_coach")
public class ParserCoach extends BaseEntity{
	
	@Column(name = "name_team")
	private String nameTeam;
	
	@Column(name = "year_team")
	private String yearTeam;
	
	@Column(name = "name_coach")
	private String nameCoach;
	
	@Column(name = "phone")
	private String phoneNumber;

	public ParserCoach() {
	
	}

	public ParserCoach(String nameTeam, String yearTeam, String nameCoach, String phoneNumber) {
		super();
		this.nameTeam = nameTeam;
		this.yearTeam = yearTeam;
		this.nameCoach = nameCoach;
		this.phoneNumber = phoneNumber;
	}

	public String getNameTeam() {
		return nameTeam;
	}

	public void setNameTeam(String nameTeam) {
		this.nameTeam = nameTeam;
	}

	public String  getYearTeam() {
		return yearTeam;
	}

	public void setYearTeam(String  yearTeam) {
		this.yearTeam = yearTeam;
	}

	public String getNameCoach() {
		return nameCoach;
	}

	public void setNameCoach(String nameCoach) {
		this.nameCoach = nameCoach;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "ParserCoach [nameTeam=" + nameTeam + ", yearTeam=" + yearTeam + ", nameCoach=" + nameCoach
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
	

}
