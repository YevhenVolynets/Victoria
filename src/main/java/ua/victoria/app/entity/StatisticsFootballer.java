package ua.victoria.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "statistics_footballer")
public class StatisticsFootballer extends BaseEntity {

@OneToOne(mappedBy = "statistics",fetch =  FetchType.LAZY)
private Footballer footballer;

@Column(name= "count_match")
private int countMatch;

@Column(name= "goal")
private int goal;

@Column(name= "assist_pass")
private int assistPass;

@Column(name= "count_yellow_card")
private int countYellowCard;

@Column(name= "count_red_card")
private int countRedCard;

public StatisticsFootballer() {

}

public StatisticsFootballer(Footballer footballer, int countMatch, int goal, int assistPass, int countYellowCard,
		int countRedCard) {
	this.countMatch = countMatch;
	this.goal = goal;
	this.assistPass = assistPass;
	this.countYellowCard = countYellowCard;
	this.countRedCard = countRedCard;
}

public Footballer getFootballer() {
	return footballer;
}

public void setFootballer(Footballer footballer) {
	this.footballer = footballer;
}

public int getCountMatch() {
	return countMatch;
}

public void setCountMatch(int countMatch) {
	this.countMatch = countMatch;
}

public int getGoal() {
	return goal;
}

public void setGoal(int goal) {
	this.goal = goal;
}

public int getAssistPass() {
	return assistPass;
}

public void setAssistPass(int assistPass) {
	this.assistPass = assistPass;
}

public int getCountYellowCard() {
	return countYellowCard;
}

public void setCountYellowCard(int countYellowCard) {
	this.countYellowCard = countYellowCard;
}

public int getCountRedCard() {
	return countRedCard;
}

public void setCountRedCard(int countRedCard) {
	this.countRedCard = countRedCard;
}



}
