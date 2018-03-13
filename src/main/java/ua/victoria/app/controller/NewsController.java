package ua.victoria.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/news")
public class NewsController {
	
	@GetMapping("/")
	public String showNews() {
		
		return "news/new";
	}  

}
