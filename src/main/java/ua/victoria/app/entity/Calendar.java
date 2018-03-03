package ua.victoria.app.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name ="calendar")
public class Calendar extends BaseEntity{

	@Column(name = "number_tour")
	private int numberTour;
	
	@Column(name = "date_game")
	private Date dateGame;
	
	@OneToOne
	@JoinColumn(name = "id_team_home")
	private Team teamHome;
	
	@OneToOne
	@JoinColumn(name = "id_team_guest")
	private Team teamGuest;

	public Calendar() {

	}

	public Calendar(int numberTour, Date dateGame) {
		this.numberTour = numberTour;
		this.dateGame = dateGame;
	}

	public int getNumberTour() {
		return numberTour;
	}

	public void setNumberTour(int numberTour) {
		this.numberTour = numberTour;
	}

	public Date getDateGame() {
		return dateGame;
	}

	public void setDateGame(Date dateGame) {
		this.dateGame = dateGame;
	}

	public Team getTeamHome() {
		return teamHome;
	}

	public void setTeamHome(Team teamHome) {
		this.teamHome = teamHome;
	}

	public Team getTeamGuest() {
		return teamGuest;
	}

	public void setTeamGuest(Team teamGuest) {
		this.teamGuest = teamGuest;
	}
	
	
	

}
