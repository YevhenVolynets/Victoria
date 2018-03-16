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
import org.springframework.web.bind.annotation.RequestParam;

import ua.victoria.app.entity.Amplua;
import ua.victoria.app.entity.Footballer;
import ua.victoria.app.entity.News;
import ua.victoria.app.entity.Position;
import ua.victoria.app.service.AdminService;
import ua.victoria.app.service.AmpluaService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AmpluaService ampluaService;
	
	
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
	
	@GetMapping("/addPlayer")
	public String addPlayer(Model model) {
		
		model.addAttribute("add", new Footballer());
		model.addAttribute("ampluaList", ampluaService.findAllAmplua());
		/*String a = ampluaService.findAmpluaById(1).getAmplua().getVal();
		System.out.println(a);*/
		return "admin/addPlayer";
	}
	
	@PostMapping("/addPlayer")
	public String savePlayer(
			@ModelAttribute("add")  @Valid Footballer footballer,
			/*@RequestParam("amplua") String pos,*/  BindingResult result) {
		
		System.out.println(footballer);
		/*System.out.println(pos);*/
		return "redirect:/admin/addPlayer";
	}

}
