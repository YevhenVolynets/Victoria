package ua.victoria.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.victoria.app.entity.News;
import ua.victoria.app.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/addNews")
	public String addNews(Model model) {
		adminService.createFolder();
		model.addAttribute("news", new News());
		
		return "admin/addNews";
	}
	
	@PostMapping("/addNews")
	public String saveNews(@ModelAttribute("news")  News news, @RequestParam("path") String foto) {
		if(news!=null) {
			
		}
		
		return "redirect:/";
	}

}
