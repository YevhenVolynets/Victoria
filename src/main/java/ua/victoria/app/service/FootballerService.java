package ua.victoria.app.service;

import java.util.List;

import ua.victoria.app.entity.Footballer;
import ua.victoria.app.entity.Team;

public interface FootballerService {

	void savePlayer(Footballer footballer);
	
	Footballer findByIdPlayer(int id);
	
	List<Footballer> findAll();
	
	List<Footballer> findPlayerByIdTeamAndSortByNumberShirt(Team team);
	
	List<Footballer> findPlayerByIdTeamAndSortByNumberGoal(Team team);
	
	List<Footballer> findPlayerByTeam(Team team);
}
