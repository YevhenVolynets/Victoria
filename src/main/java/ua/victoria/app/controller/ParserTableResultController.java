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
	
	@GetMapping("/addTablePremierLigue")
	public String goPars1() throws IOException {
		parserTableResultService.connectToSite("lt_27");
		return "redirect:/admin";
	}
	@GetMapping("/addTableSecondLigue")
	public String goPars2() throws IOException {
		parserTableResultService.connectToSite("lt_28");
		return "redirect:/admin";
	}
	
	@GetMapping("/addFinalTable")
	public String saveStatistics() {
		statisticsTeamService.saveStatistics();
		return "redirect:/admin";
	}

}
