package ua.victoria.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ua.victoria.app.entity.Team;
import ua.victoria.app.service.CalendarService;
import ua.victoria.app.service.FootballerService;
import ua.victoria.app.service.TeamService;

@Controller
public class VictoriaController {
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private CalendarService calendarService;
	
	@Autowired
	private FootballerService footballerService;
	
	@GetMapping("/victoria-2004")
	public String showvictoria2004(Model model) {
		
		Team team = teamService.findTeamById(20);
		
		
		model.addAttribute("oneTeam", team);
		model.addAttribute("gameHome", calendarService.findHomeCalendar(team));
		model.addAttribute("gameGuest", calendarService.findGuestCalendar(team));
		model.addAttribute("bombardirs",footballerService.findPlayerByIdTeamAndSortByNumberGoal(team));
		model.addAttribute("title", "FC - VICTORIA 2004");
		return "victoria/victoria-2004";
	}

}
