package ua.victoria.app.entity;

import java.util.Date;


import javax.persistence.*;

import ua.victoria.app.entity.enumerated.Ligue;

@Entity
@Table(name ="calendar")
public class Calendar extends BaseEntity{

	@Column(name = "number_tour")
	private int numberTour;
	
	@Column(name = "ligue")
	@Enumerated(EnumType.ORDINAL)
	private Ligue ligue; 
	
	@Column(name = "date_game")
	@Temporal(TemporalType.DATE)
	private Date dateGame;
	
	@OneToOne
	@JoinColumn(name = "id_team_home")
	private Team teamHome;
	
	@OneToOne
	@JoinColumn(name = "id_team_guest")
	private Team teamGuest;
	
	@Column(name="score_home")
	private int scoreHome;
	
	@Column(name = "score_guest")
	private int scoreGuest;

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

	public int getScoreHome() {
		return scoreHome;
	}

	public void setScoreHome(int scoreHome) {
		this.scoreHome = scoreHome;
	}

	public int getScoreGuest() {
		return scoreGuest;
	}

	public void setScoreGuest(int scoreGuest) {
		this.scoreGuest = scoreGuest;
	}

	public Ligue getLigue() {
		return ligue;
	}

	public void setLigue(Ligue ligue) {
		this.ligue = ligue;
	}

	@Override
	public String toString() {
		return "Calendar [numberTour=" + numberTour + ", ligue=" + ligue + ", dateGame=" + dateGame + ", teamHome="
				+ teamHome + ", teamGuest=" + teamGuest + ", scoreHome=" + scoreHome + ", scoreGuest=" + scoreGuest
				+ ", getId()=" + getId() + "]";
	}

	public Date getDateGame() {
		return dateGame;
	}

	public void setDateGame(Date dateGame) {
		this.dateGame = dateGame;
	}


}
