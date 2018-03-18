package ua.victoria.app.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.victoria.app.entity.Amplua;
import ua.victoria.app.entity.Calendar;
import ua.victoria.app.entity.Footballer;
import ua.victoria.app.entity.Ligue;
import ua.victoria.app.entity.News;
import ua.victoria.app.entity.Position;
import ua.victoria.app.service.AdminService;
import ua.victoria.app.service.AmpluaService;
import ua.victoria.app.service.CalendarService;
import ua.victoria.app.service.TeamService;

@Controller
@RequestMapping("/admin")
@SessionAttributes("oneModel")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AmpluaService ampluaService;
	
	@Autowired
	private CalendarService calendarService;
	
	@Autowired
	private TeamService teamService;
	
	@GetMapping
	public String getMenu() {
		
		return "admin/main";
	}
	
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
		if(ampluaService.findAllAmplua().isEmpty()) {
			ampluaService.createAmplua();
		}
		model.addAttribute("ampluaList", ampluaService.findAllAmplua());
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
	@GetMapping("/addCalendar")
	public String saveCalendar() {
		
		calendarService.workWithPars();
		
		return "redirect:/admin/";
	}
	
	@GetMapping("/editCalendar")
	public String editCalendar(Model model){
		model.addAttribute("calendarListModel",calendarService.findAllCalendar());
		
		return "calendar/edit";
	}
	
	@GetMapping("/calendar/{id}")
	public String editOneCalendar(@RequestParam("id") int id,Model model) {
		model.addAttribute("oneModel", 	calendarService.findOneCalendar(id));
		List<Ligue> list = new ArrayList<>();
		list.add(Ligue.First);list.add(Ligue.Second);
		model.addAttribute("ligueList",list );
		return "calendar/editone";
	}
	
	@PostMapping("/saveCalendar")
	public String updateCalendar(@ModelAttribute("oneModel") Calendar calendar,
								@RequestParam("dateGame1") String date, BindingResult result){
		System.out.println(result.getAllErrors());
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		  try {

	          Date date1 = formatter.parse(date);  
	          calendar.setDateGame(date1);
	          formatter.format(date1);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
		  System.out.println(calendar);
		calendarService.saveCalendar(calendar);
		return "redirect:/admin/editCalendar";
	}

	@GetMapping("/calendar/add")
	public String addStat(Model model) {
		
		List<Ligue> list = new ArrayList<>();
		list.add(Ligue.First);list.add(Ligue.Second);
		
		
		
		model.addAttribute("calendarModel", new Calendar());
		model.addAttribute("ligueList",list);
		model.addAttribute("teamsModel",teamService.findAllTeams() );
		return "calendar/add";
	}
	
	@PostMapping("/saveNewCalendar")
	public String createCalendar(@ModelAttribute("calendarModel") Calendar calendar,
								@RequestParam("dateGame1") String date, BindingResult result){
		System.out.println(result.getAllErrors());
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		  try {

	          Date date1 = formatter.parse(date);  
	          calendar.setDateGame(date1);
	          formatter.format(date1);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
		  System.out.println(calendar);
		calendarService.saveCalendar(calendar);
		return "redirect:/admin/editCalendar";
	}
}
