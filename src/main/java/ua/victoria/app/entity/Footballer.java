package ua.victoria.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "footballer")
public class Footballer extends BaseEntity{

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "number_shirt")
	private int numberShirt;
	
	@ManyToOne
	@JoinColumn(name = "id_amplua")
	private Amplua amplua;
	
	@ManyToOne
	@JoinColumn(name = "id_team")
	private Team team;
	
	@OneToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Statistics_footballer")
	private StatisticsFootballer statistics;


	public Footballer() {
	}

	public Footballer(String firstName, String lastName, int numberShirt, Amplua amplua, Team team) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.numberShirt = numberShirt;
		this.amplua = amplua;
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

	public int getNumberShirt() {
		return numberShirt;
	}

	public void setNumberShirt(int numberShirt) {
		this.numberShirt = numberShirt;
	}

	public Amplua getAmplua() {
		return amplua;
	}

	public void setAmplua(Amplua amplua) {
		this.amplua = amplua;
	}
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public StatisticsFootballer getStatistics() {
		return statistics;
	}

	public void setStatistics(StatisticsFootballer statistics) {
		this.statistics = statistics;
	}

	@Override
	public String toString() {
		return "Footballer [firstName=" + firstName + ", lastName=" + lastName + ", numberShirt=" + numberShirt
				+ ", amplua=" + amplua + ", team=" + team + "]";
	}

	
	
	
}
