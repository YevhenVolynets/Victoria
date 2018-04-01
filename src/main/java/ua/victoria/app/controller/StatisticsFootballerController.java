package ua.victoria.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.victoria.app.entity.Team;
import ua.victoria.app.service.FootballerService;
import ua.victoria.app.service.TeamService;

@Controller
@RequestMapping("/statistics/team")
public class StatisticsFootballerController {
	
	@Autowired
	private FootballerService footballerService;
	
	@Autowired
	private TeamService teamService;
	
	@GetMapping("/{id}/footballer")
	public String showStatisticsFootballer(Model model,@PathVariable("id") String id) {
		Team team = teamService.findTeamById(Integer.parseInt(id)); 
	
		model.addAttribute("oneteamModel",footballerService.findPlayerByIdTeamAndSortByNumberShirt(team));
		model.addAttribute("title", "Cтастика футболістів" + team.getNameTeam());
		return "statistics/footballer/showStatistics";
	}

}
