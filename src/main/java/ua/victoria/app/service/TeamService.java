package ua.victoria.app.service;

import java.util.List;

import ua.victoria.app.entity.Team;

public interface TeamService {
	
	void saveTeam(Team team);
	
	List<Team> findAllTeams();
	
	Team findTeamById(int id);
	
	Team findTeamByNameTeam(String nameTeam);
	
	void saveTeamWithTable();

}
