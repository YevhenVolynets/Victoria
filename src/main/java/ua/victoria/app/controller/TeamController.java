package ua.victoria.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.victoria.app.entity.Team;
import ua.victoria.app.service.TeamService;

@Controller
@RequestMapping("/team")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@GetMapping("/add")
	public String showAddTeamPage(Model model) {
		model.addAttribute("teamModel", new Team());
		return "team/add";
	}
	
	@GetMapping("/list")
	public String showAllTeam() {
		
		return "team/list";
	}
	
	@PostMapping("/add")
	public String saveTeam(@ModelAttribute("teamModel")
					 @Valid Team team, BindingResult result
			) {
		if(result.hasErrors()) {
			return "team/add";
		}
		teamService.saveTeam(team);
		return "redirect:/team/list";
	}
	@GetMapping("/addpars")
	public String writeTeam() {
		teamService.saveTeamWithTable();
		return "redirect:/";
	}
	

}
