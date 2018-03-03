package ua.victoria.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import ua.victoria.app.validation.annotation.UniqueTeamName;

@Entity
@Table(name = "team")
public class Team extends BaseEntity{
	
	@Column(name = "name_team")
	@Size(min=3,max = 20,message = "The name should be beteen 3 and 20 symbols")
	@UniqueTeamName(message = "Team already exists")
	private String nameTeam;
	
	@OneToMany(mappedBy = "team")
	private List<Footballer> footballers = new ArrayList<>();
	
	@OneToMany(mappedBy = "team")
	private List<Coach> coachs = new ArrayList<>();
	
	@OneToOne(mappedBy = "team",fetch = FetchType.LAZY)
	private StatisticsTeam statistics;

	public Team() {
	}


	public Team(String nameTeam) {
		this.nameTeam = nameTeam;
	}

	public String getNameTeam() {
		return nameTeam;
	}

	public void setNameTeam(String nameTeam) {
		this.nameTeam = nameTeam;
	}


	public List<Footballer> getFootballers() {
		return footballers;
	}


	public void setFootballers(List<Footballer> footballers) {
		this.footballers = footballers;
	}


	public List<Coach> getCoachs() {
		return coachs;
	}


	public void setCoachs(List<Coach> coachs) {
		this.coachs = coachs;
	}


	public StatisticsTeam getStatistics() {
		return statistics;
	}


	public void setStatistics(StatisticsTeam statistics) {
		this.statistics = statistics;
	}


	@Override
	public String toString() {
		return "Team [getId()=" + getId() + ", nameTeam=" + nameTeam + "]";
	}
	
}
