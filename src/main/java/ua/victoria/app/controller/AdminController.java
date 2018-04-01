package ua.victoria.app.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
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
import org.springframework.web.multipart.MultipartFile;

import ua.victoria.app.entity.Amplua;
import ua.victoria.app.entity.Calendar;
import ua.victoria.app.entity.Footballer;
import ua.victoria.app.entity.News;
import ua.victoria.app.entity.Photo;
import ua.victoria.app.entity.StatisticsFootballer;
import ua.victoria.app.entity.Team;
import ua.victoria.app.entity.UserEntity;
import ua.victoria.app.entity.enumerated.Ligue;
import ua.victoria.app.entity.enumerated.Position;
import ua.victoria.app.service.AdminService;
import ua.victoria.app.service.AmpluaService;
import ua.victoria.app.service.CalendarService;
import ua.victoria.app.service.FootballerService;
import ua.victoria.app.service.NewsService;
import ua.victoria.app.service.PhotoService;
import ua.victoria.app.service.StatisticsFootballerService;
import ua.victoria.app.service.TeamService;
import ua.victoria.app.service.UserService;
import ua.victoria.app.service.utils.CustomFileUtils;

@Controller
@RequestMapping("/admin")
@SessionAttributes({"oneModel","teamModel","add","onePlayer"})
public class AdminController {
	
	private AdminService adminService;
	private AmpluaService ampluaService;	
	private CalendarService calendarService;	
	private TeamService teamService;	
	private FootballerService footballerService;
	private StatisticsFootballerService statisticsFootballerService;
	private NewsService newsService;	
	private UserService userService;
	private PhotoService photoService;
	
	@Autowired
	public AdminController(AdminService adminService, AmpluaService ampluaService, CalendarService calendarService,
			TeamService teamService, FootballerService footballerService,
			StatisticsFootballerService statisticsFootballerService, NewsService newsService, UserService userService, PhotoService photoService) {
		
		this.adminService = adminService;
		this.ampluaService = ampluaService;
		this.calendarService = calendarService;
		this.teamService = teamService;
		this.footballerService = footballerService;
		this.statisticsFootballerService = statisticsFootballerService;
		this.newsService = newsService;
		this.userService = userService;
		this.photoService = photoService;
	}

	@GetMapping
	public String getMenu(Model model) {
		model.addAttribute("title","Адмін панель");
		return "admin/main";
	}
	
	@GetMapping("/addNews")
	public String addNews(Model model) {
		adminService.createFolder("news");
		model.addAttribute("news", new News());
		model.addAttribute("title", "Додавання новини");
		return "admin/addNews";
	}
	
	@PostMapping("/addNews")
	public String saveNews(@ModelAttribute("news")  News news,@RequestParam("fileUpload") MultipartFile file,Principal principal) throws IOException {
		
		if(news!=null) {
			news.setCreateDate(new Date());
			newsService.saveNews(news);
			
			if (!file.isEmpty() && file!=null) {
				BufferedImage image = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
				File dest = new File(CustomFileUtils.ROOT_PATH+CustomFileUtils.SEPARATOR+"news"+CustomFileUtils.SEPARATOR+"news_"+news.getId()+".png");
				ImageIO.write(image, "png", dest);
			}
			UserEntity author = userService.findUserByEmail(principal.getName());
			news.setAuthor(author);
			newsService.saveNews(news);
			news.setPathToFoto("news_"+news.getId());
			newsService.saveNews(news);
			
		}
		
		return "redirect:/admin";
	}
	
	@GetMapping("/addPlayer")
	public String addPlayer(Model model) {
		Footballer footballer = new Footballer();
		footballer.setStatistics(new StatisticsFootballer());
		model.addAttribute("add", footballer);
		if(ampluaService.findAllAmplua().isEmpty()) {
			ampluaService.createAmplua();
		}
		model.addAttribute("teamModel", teamService.findAllTeams());
		model.addAttribute("ampluaList", ampluaService.findAllAmplua());
		System.out.println("get");
		model.addAttribute("title", "Додавання футболіста");
		return "admin/addPlayer";
	}
	
	@PostMapping("/addPlayer")
	public String savePlayer(
			@ModelAttribute("add")  @Valid Footballer footballer, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
		}else {
		statisticsFootballerService.saveStatistics(footballer.getStatistics());
		footballerService.savePlayer(footballer);
		}
		
		return "redirect:/admin/addPlayer";
	}
	@GetMapping("/addCalendar")
	public String saveCalendar(Model model) {
		
		calendarService.workWithPars();
		model.addAttribute("title", "Парсинг календаря");
		return "redirect:/admin/";
	}
	
	@GetMapping("/editCalendar")
	public String editCalendar(Model model){
		model.addAttribute("calendarListModel",calendarService.findAllCalendar());
		model.addAttribute("title", "Редагування календаря");
		return "calendar/edit";
	}
	
	@GetMapping("/calendar/edit")
	public String editOneCalendar(@RequestParam("id") int id,Model model) {
		model.addAttribute("oneModel", 	calendarService.findOneCalendar(id));
		List<Ligue> list = new ArrayList<>();
		list.add(Ligue.First);list.add(Ligue.Second);
		model.addAttribute("ligueList",list );
		model.addAttribute("title", "Редагування календаря");
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
		model.addAttribute("teamsModel",teamService.findAllTeams());
		model.addAttribute("title", "Додавання до календаря");
		return "calendar/add";
	}
	
	@PostMapping("/saveNewCalendar")
	public String createCalendar(@ModelAttribute("calendarModel") Calendar calendar,
								@RequestParam("date") String date){
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		  try {

	          Date date1 = formatter.parse(date);  
	          calendar.setDateGame(date1);
	          formatter.format(date1);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	
		calendarService.saveCalendar(calendar);
		return "redirect:/admin/editCalendar";
	}
	
	@GetMapping("/player/addStatistics")
	public String addStatPlayer(Model model) {
		model.addAttribute("teamssModel",teamService.findAllTeams());
		model.addAttribute("footballerModel", footballerService.findAll());
		/*Team team = teamService.findTeamById(20);*/
		model.addAttribute("title", "Додавання статистики футболіста");
		return "statistics/footballer/addStatFootballer";
	}
	  
	@GetMapping("/addStatisticsPlayer")
	public String showPlayer(@RequestParam("team") String id,Model model) {
		model.addAttribute("listPlayer", teamService.findTeamById(Integer.parseInt(id)).getFootballers());
		model.addAttribute("title", "Додавання статистики футболіста");
		return "statistics/footballer/editFootballers";
	}
	
	@GetMapping("/footballer/statistics/edit")
	public String showEditOnePlayer(@RequestParam("id") int id,Model model) {
		model.addAttribute("onePlayer",footballerService.findByIdPlayer(id));
		model.addAttribute("title", "Редагування статистики футболіста");
		return "statistics/footballer/editOne";
	}
	 
	@PostMapping("/saveFootballer")
	public String saveFootballer(@ModelAttribute("onePlayer") Footballer footballer) {
		System.out.println(footballer.getStatistics());
		statisticsFootballerService.saveStatistics(footballer.getStatistics());
		footballerService.savePlayer(footballer);
		return "redirect:/admin";
	}
	
	@GetMapping("/addPhoto")
	public String addPhoto(Model model) {
		
		model.addAttribute("photo", new Photo());
		model.addAttribute("title", "Додавання фото");
		return "admin/addPhoto";
	}
	
	@PostMapping("/addPhoto")
	public String saveImg(@ModelAttribute("photo") Photo photo,@RequestParam("fileUpload") MultipartFile file) throws IOException {
		
		if (!file.isEmpty() && file!=null) {
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
			File dest = new File(CustomFileUtils.RESOURCES_IMG_PATH+file.getOriginalFilename());
			ImageIO.write(image, "png", dest);
			photo.setNamePhoto(file.getOriginalFilename());
			photoService.savePhoto(photo);
		}
		
		
		return "redirect:/admin";
	}
}
