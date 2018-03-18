package ua.victoria.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.victoria.app.entity.Ligue;
import ua.victoria.app.entity.StatisticsTeam;
import ua.victoria.app.entity.Team;
import ua.victoria.app.repository.StatisticsTeamRepository;
import ua.victoria.app.service.StatisticsTeamService;
import ua.victoria.app.service.TeamService;

@Controller
@RequestMapping("/statistics")
public class StatisticsTeamController {
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private StatisticsTeamService statisticsTeamService;
	
//	@Autowired
//	private StatisticsTeamRepository statisticsTeamRepository;

	@GetMapping("/tournament-table")
	public String showTable(Model model) {
		
		model.addAttribute("listStat1",statisticsTeamService.findPremierLigue());
		model.addAttribute("listStat2", statisticsTeamService.findSecondLigue());
		
		
		
		return "statistics/team/statisticsTable";
	}
	
	@GetMapping("/lastMatch")
	public String showLastMatches() {
		String nameTeam = "\"Вікторія\" 2004 Л.";
		Team team = teamService.findTeamByNameTeam(nameTeam);
		StatisticsTeam statistics = statisticsTeamService.findStatByTeam(team);
		/*statistics.her;*/
		return "statistics/lastMatches";
	}
}
