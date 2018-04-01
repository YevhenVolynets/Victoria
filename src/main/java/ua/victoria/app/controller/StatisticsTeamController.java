package ua.victoria.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.victoria.app.entity.Calendar;
import ua.victoria.app.entity.StatisticsTeam;
import ua.victoria.app.entity.Team;
import ua.victoria.app.entity.enumerated.Ligue;
import ua.victoria.app.repository.StatisticsTeamRepository;
import ua.victoria.app.service.CalendarService;
import ua.victoria.app.service.StatisticsTeamService;
import ua.victoria.app.service.TeamService;

@Controller
@SessionAttributes("userModelka")
@RequestMapping("/statistics")
public class StatisticsTeamController {
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private CalendarService calendarService;
	
	@Autowired
	private StatisticsTeamService statisticsTeamService;
	
//	@Autowired
//	private StatisticsTeamRepository statisticsTeamRepository;

	@GetMapping("/tournament-table")
	public String showTable(Model model) {
		
		model.addAttribute("listStat1",statisticsTeamService.findPremierLigue());
		model.addAttribute("listStat2", statisticsTeamService.findSecondLigue());
		model.addAttribute("title", "Турнірна таблиця");
		
		
		return "statistics/team/statisticsTable";
	} 
	
	@GetMapping("/team/{id}/lastMatch")
	public String showLastMatches(@PathVariable("id") String id,Model model) {
		Team team = teamService.findTeamById(Integer.parseInt(id));
		model.addAttribute("lastModel",calendarService.findLastMatch(team));
		model.addAttribute("title", "Останній матч " + team.getNameTeam());
		return "statistics/lastMatch";/**/
	}
}
