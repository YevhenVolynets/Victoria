package ua.victoria.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.victoria.app.entity.ParserTableResult;
import ua.victoria.app.entity.StatisticsTeam;
import ua.victoria.app.entity.Team;
import ua.victoria.app.entity.enumerated.Ligue;
import ua.victoria.app.repository.ParserTableResultRepository;
import ua.victoria.app.repository.StatisticsTeamRepository;
import ua.victoria.app.repository.TeamRepository;
import ua.victoria.app.service.StatisticsTeamService;

@Service
public class StatisticsTeamServiceImpl implements StatisticsTeamService {

	@Autowired
	private StatisticsTeamRepository statisticsTeamRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private ParserTableResultRepository parserTableResultRepository;
	
	public void saveStatistics() {
		List<ParserTableResult> tableResult =  parserTableResultRepository.findAll();
		for (ParserTableResult result : tableResult) {
			StatisticsTeam statisticsTeam = new StatisticsTeam();
			Team team = new Team(result.getName());
			teamRepository.save(team);
			statisticsTeam.setWinMatch(Integer.parseInt(result.getWin()));
			statisticsTeam.setDrawMatch(Integer.parseInt(result.getDraw()));
			statisticsTeam.setLoseMatch(Integer.parseInt(result.getLose()));
			statisticsTeam.setCountMatch(Integer.parseInt(result.getGame()));
			statisticsTeam.setPoint(Integer.parseInt(result.getPoint()));
			statisticsTeam.setRatingPosition(Integer.parseInt(result.getNumInTable()));
			statisticsTeam.setLigue(result.getLigue());
			
			int indx =  result.getScoredMissedGoal().indexOf('-');
		
			statisticsTeam.setScoredGoal(Integer.parseInt(result.getScoredMissedGoal().substring(0, indx)));
			statisticsTeam.setMissedGoal(Integer.parseInt(result.getScoredMissedGoal().substring(indx+1,result.getScoredMissedGoal().length())));
			statisticsTeam.setTeam(team);
			
			statisticsTeamRepository.save(statisticsTeam);
			
		}
	}

	@Override
	public List<StatisticsTeam> findAll() {
		
		return statisticsTeamRepository.findAll();
	}

	@Override
	public StatisticsTeam findStatById(int id) {
		
		return statisticsTeamRepository.findOne(id);
	}

	@Override
	public List<StatisticsTeam> findPremierLigue() {
		
		return statisticsTeamRepository.findLigue(Ligue.First);
	}

	@Override
	public List<StatisticsTeam> findSecondLigue() {
		
		return statisticsTeamRepository.findLigue(Ligue.Second);
	}

	@Override
	public StatisticsTeam findStatByTeam(Team team) {
		
		return statisticsTeamRepository.findStatByTeam(team);
	}
}
