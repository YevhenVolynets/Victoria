package ua.victoria.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.victoria.app.entity.Team;
import ua.victoria.app.repository.TeamRepository;
import ua.victoria.app.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService{
	
	
	private TeamRepository teamRepository;
	
	@Autowired
	public TeamServiceImpl(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}

	@Override
	public void saveTeam(Team team) {
		teamRepository.save(team);
		
	}

	@Override
	public List<Team> findAllTeams() {
		
		return teamRepository.findAll();
	}

	@Override
	public Team findTeamById(int id) {
		
		return teamRepository.findOne(id);
	}

	@Override
	public Team findTeamByNameTeam(String nameTeam) {
		
		return teamRepository.findTeamByNameTeam(nameTeam);
	}

}
