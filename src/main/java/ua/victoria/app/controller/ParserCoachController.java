package ua.victoria.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.victoria.app.entity.ParserCoach;
import ua.victoria.app.service.ParserCoachService;

@Controller
@RequestMapping("/parser")
public class ParserCoachController {
	Document doc;
	
	@Autowired
	private ParserCoachService parserCoachService;
	
	@GetMapping("/addCoach")
	public String goPars() throws IOException {
		
		parserCoachService.connectToSite();
		return "redirect:/";
	}

}
