package ua.victoria.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "statistics_team")
public class StatisticsTeam extends BaseEntity{

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_team")
	private Team team;
	
	@Column(name = "count_match")
	private int countMatch;
	
	@Column(name = "win_match")
	private int winMatch;
	
	@Column(name = "lose_match")
	private int loseMatch;
	
	@Column(name = "draw_match")
	private int drawMatch;
	
	@Column(name = "scored_goal")
	private int scoredGoal;
	
	@Column(name = "missed_goal")
	private int missedGoal;
	
	@Column(name = "point")
	private int point;
	
	@Column(name = "rating_position")
	private int ratingPosition;
	
	@Column(name = "ligue")
	@Enumerated(EnumType.ORDINAL)
	private Ligue ligue;


	public StatisticsTeam() {

	}

	public StatisticsTeam(int countMatch, int winMatch, int loseMatch, int drawMatch, int scoredGoal, int missedGoal,
			int point) {
		this.countMatch = countMatch;
		this.winMatch = winMatch;
		this.loseMatch = loseMatch;
		this.drawMatch = drawMatch;
		this.scoredGoal = scoredGoal;
		this.missedGoal = missedGoal;
		this.point = point;
	}

	public int getCountMatch() {
		return countMatch;
	}

	public void setCountMatch(int countMatch) {
		this.countMatch = countMatch;
	}

	public int getWinMatch() {
		return winMatch;
	}

	public void setWinMatch(int winMatch) {
		this.winMatch = winMatch;
	}

	public int getLoseMatch() {
		return loseMatch;
	}

	public void setLoseMatch(int loseMatch) {
		this.loseMatch = loseMatch;
	}

	public int getDrawMatch() {
		return drawMatch;
	}

	public void setDrawMatch(int drawMatch) {
		this.drawMatch = drawMatch;
	}

	public int getScoredGoal() {
		return scoredGoal;
	}

	public void setScoredGoal(int scoredGoal) {
		this.scoredGoal = scoredGoal;
	}

	public int getMissedGoal() {
		return missedGoal;
	}

	public void setMissedGoal(int missedGoal) {
		this.missedGoal = missedGoal;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getRatingPosition() {
		return ratingPosition;
	}

	public void setRatingPosition(int ratingPosition) {
		this.ratingPosition = ratingPosition;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	  
	public Ligue getLigue() {
		return ligue;
	}

	public void setLigue(Ligue ligue) {
		this.ligue = ligue;
	}

	@Override
	public String toString() {
		return "StatisticsTeam [team=" + team + ", countMatch=" + countMatch + ", winMatch=" + winMatch + ", loseMatch="
				+ loseMatch + ", drawMatch=" + drawMatch + ", scoredGoal=" + scoredGoal + ", missedGoal=" + missedGoal
				+ ", point=" + point + ", ratingPosition=" + ratingPosition + ", getId()=" + getId() + "]";
	}
	
	
	
	
	
}
