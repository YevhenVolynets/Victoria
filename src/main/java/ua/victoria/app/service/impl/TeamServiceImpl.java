package ua.victoria.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.victoria.app.entity.Footballer;
import ua.victoria.app.entity.ParserTableResult;
import ua.victoria.app.entity.Team;
import ua.victoria.app.repository.ParserTableResultRepository;
import ua.victoria.app.repository.TeamRepository;
import ua.victoria.app.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService{
	
	
	private TeamRepository teamRepository;
	
	@Autowired
	private ParserTableResultRepository parserTableResultRepository;
	
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

	@Override
	public void saveTeamWithTable() {
		List<ParserTableResult> teams = parserTableResultRepository.findAll();
		String name;
		for (ParserTableResult result : teams) {
			Team team = new Team();
			name = result.getName();
			if(name.charAt(name.length()-1)=='.') {
				name = name.substring(0, name.length()-3);
			}
			team.setNameTeam(name);
			teamRepository.save(team);
		}
	}



}
