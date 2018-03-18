package ua.victoria.app.service;

import java.util.List;

import ua.victoria.app.entity.StatisticsTeam;
import ua.victoria.app.entity.Team;

public interface StatisticsTeamService {

	public void saveStatistics();
	
	List<StatisticsTeam> findAll();
	
	StatisticsTeam findStatById(int id);
	
	List<StatisticsTeam> findPremierLigue();
	
	List<StatisticsTeam> findSecondLigue();
	
	StatisticsTeam findStatByTeam(Team team);
}
