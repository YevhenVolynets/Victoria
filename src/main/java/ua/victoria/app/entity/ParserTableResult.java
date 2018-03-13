package ua.victoria.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "parses_table_result")
public class ParserTableResult extends BaseEntity{
	
	@Column(name = "num_in_table")
	private String numInTable;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "list_teams")
	private String listTeams;
	
	@Column(name = "game")
	private String game;
	
	@Column(name = "win")
	private String win;
	
	@Column(name = "draw")
	private String draw;
	
	@Column(name = "lose")
	private String lose;
	
	@Column(name = "scored_missed_goal")
	private String scoredMissedGoal;
	
	@Column(name = "point")
	private String point;
	
	@Column(name = "ligue")
	@Enumerated(EnumType.ORDINAL)
	private Ligue ligue;

	public ParserTableResult() {
		
	}

	public ParserTableResult(String numInTable, String name, String listTeams, String game, String win, String draw,
			String lose, String scoredMissedGoal, String point) {
		this.numInTable = numInTable;
		this.name = name;
		this.listTeams = listTeams;
		this.game = game;
		this.win = win;
		this.draw = draw;
		this.lose = lose;
		this.scoredMissedGoal = scoredMissedGoal;
		this.point = point;
	}

	public String getNumInTable() {
		return numInTable;
	}

	public void setNumInTable(String numInTable) {
		this.numInTable = numInTable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getListTeams() {
		return listTeams;
	}

	public void setListTeams(String listTeams) {
		this.listTeams = listTeams;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getWin() {
		return win;
	}

	public void setWin(String win) {
		this.win = win;
	}

	public String getDraw() {
		return draw;
	}

	public void setDraw(String draw) {
		this.draw = draw;
	}

	public String getLose() {
		return lose;
	}

	public void setLose(String lose) {
		this.lose = lose;
	}

	public String getScoredMissedGoal() {
		return scoredMissedGoal;
	}

	public void setScoredMissedGoal(String scoredMissedGoal) {
		this.scoredMissedGoal = scoredMissedGoal;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}
	
	

	public Ligue getLigue() {
		return ligue;
	}

	public void setLigue(Ligue ligue) {
		this.ligue = ligue;
	}

	@Override
	public String toString() {
		return "ParsesTableResult [numInTable=" + numInTable + ", name=" + name + ", listTeams=" + listTeams + ", game=" + game
				+ ", win=" + win + ", draw=" + draw + ", lose=" + lose + ", scoredMissedGoal=" + scoredMissedGoal
				+ ", point=" + point + ", getId()=" + getId() + "]";
	}
	
	

}
