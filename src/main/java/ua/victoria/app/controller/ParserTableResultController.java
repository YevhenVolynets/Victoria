package ua.victoria.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.victoria.app.service.ParserTableResultService;
import ua.victoria.app.service.StatisticsTeamService;

@Controller
@RequestMapping("/admin/parser")
public class ParserTableResultController {
	
	@Autowired
	private ParserTableResultService parserTableResultService;
	
	@Autowired
	private StatisticsTeamService statisticsTeamService;
	
	@GetMapping("/addTablePremierLigue")
	public String goPars1(Model model) throws IOException {
		parserTableResultService.connectToSite("lt_27");
		model.addAttribute("title", "Додавання вищої ліги");
		return "redirect:/admin";
	}
	@GetMapping("/addTableSecondLigue")
	public String goPars2(Model model) throws IOException {
		parserTableResultService.connectToSite("lt_28");
		model.addAttribute("title", "Додавання першої ліги");
		return "redirect:/admin";
	}
	
	@GetMapping("/addFinalTable")
	public String saveStatistics(Model model) {
		statisticsTeamService.saveStatistics();
		model.addAttribute("title", "Створення фінальної таблиці");
		return "redirect:/admin";
	}

}
