package ua.victoria.app.service;

import java.util.List;

import ua.victoria.app.entity.StatisticsTeam;

public interface StatisticsTeamService {

	public void saveStatistics();
	
	List<StatisticsTeam> findAll();
	
	StatisticsTeam findStatById(int id);
	
	List<StatisticsTeam> findPremierLigue();
	
	List<StatisticsTeam> findSecondLigue();
}
