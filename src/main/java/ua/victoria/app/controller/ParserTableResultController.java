package ua.victoria.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.victoria.app.service.ParserTableResultService;
import ua.victoria.app.service.StatisticsTeamService;

@Controller
@RequestMapping("/parser")
public class ParserTableResultController {
	
	@Autowired
	private ParserTableResultService parserTableResultService;
	
	@Autowired
	private StatisticsTeamService statisticsTeamService;
	
	@GetMapping("/addTable")
	public String goPars() throws IOException {
		parserTableResultService.connectToSite();
		return "redirect:/";
	}
	
	@GetMapping("/addFinalTable")
	public String saveStatistics() {
		statisticsTeamService.saveStatistics();
		return "redirect:/";
	}

}
