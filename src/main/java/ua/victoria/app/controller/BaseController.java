package ua.victoria.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ua.victoria.app.domain.ForgotRequest;
import ua.victoria.app.domain.RegisterRequest;
import ua.victoria.app.entity.News;
import ua.victoria.app.entity.Team;
import ua.victoria.app.entity.UserEntity;
import ua.victoria.app.entity.UserRole;
import ua.victoria.app.mapper.UserMapper;
import ua.victoria.app.service.FootballerService;
import ua.victoria.app.service.NewsService;
import ua.victoria.app.service.StatisticsTeamService;
import ua.victoria.app.service.TeamService;
import ua.victoria.app.service.UserService;
import ua.victoria.app.service.utils.CustomFileUtils;
import ua.victoria.app.service.utils.TokenGenerator;

@Controller
@SessionAttributes("newPass")
public class BaseController {
	
	
	@Autowired
	private UserService userService;  
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private FootballerService footballerService;
	
	@Autowired
	private StatisticsTeamService statisticsTeamService;
	/*@GetMapping("/")
	public String showHome() {
		
		return "home"; 
	}*/
	
	@GetMapping("/")
	public String showUserAddPAge(Model model) throws IOException {
		Team team = teamService.findTeamById(20); 
		
		Document doc = null;
		try {
			doc = Jsoup.connect("https://www.ua-football.com/ua").get();
		} catch (IOException e) {
			System.out.println("not connect");
		}

		Element tableScoreOne = doc.getElementById("allnews");
		List<String> list = new ArrayList<>();
		for(int i=3;i<23;i+=2) {
			list.add(tableScoreOne.childNode(1).childNode(i).toString());
		}
		
		try {
		List<News> list1 =  newsService.findAllAndSortByDate().subList(0, 2);
		for (News news : list1) {
			String oldPathfoto = news.getPathToFoto();
			news.setPathToFoto(CustomFileUtils.getImage("news"+CustomFileUtils.SEPARATOR+oldPathfoto+".png"));
		}
		model.addAttribute("mainnews", list1);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("not list");
		}

		model.addAttribute("list1", list);
		try {
		model.addAttribute("footballtat",footballerService.findPlayerByIdTeamAndSortByNumberGoal(team).subList(0, 5));
		}catch (IndexOutOfBoundsException e) {
			System.out.println("not list");
		}
		
		model.addAttribute("userModelka", new RegisterRequest());
		model.addAttribute("userRoless",UserRole.values());
		model.addAttribute("listStat2", statisticsTeamService.findSecondLigue());
		model.addAttribute("title", "FC - VICTORIA");
		return "home";
	}
	
	@PostMapping("/register")
	public ModelAndView saveUser(@Valid @ModelAttribute("userModelka") RegisterRequest request,BindingResult result) {
		System.out.println(request.getEmail());
		System.out.println(result.getAllErrors());
		if(result.hasErrors()){
			return new ModelAndView("register");
		}
		
		try {
		userService.saveUser(UserMapper.registerToEntity(request));
		}catch (Exception e) {
			return new ModelAndView("register","error","Opps..Can`t save user."); 
		}
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping("/verify")
	public String verifyUser(@RequestParam("token") String token,
			@RequestParam("userid") String useridStr,
			Model model) {
		
		try {
			int userId = Integer.valueOf(useridStr);
			UserEntity entity  = userService.findUserById(userId);
			
			if(entity != null) {
				if(entity.getToken().equals(token)) {
					entity.setToken("");
					entity.setActivated(true);
					
					userService.updateUser(entity);
				}
			}
		}
		catch (Exception e) {
			model.addAttribute("error", "Opps..Verify error");
			return "verify/verify-error";
		}
		model.addAttribute("title", "Верифікація аккаунту");
		return "verify/verify-success";
	}
	
	/*@PostMapping("/")
	public String saveUser(@ModelAttribute("userModelka") @Valid UserEntity user,@RequestParam("password2") String pass, BindingResult result ) {
		
		if(result.hasErrors()) {
			return "home";
		}
		if(!user.getPassword().equals(pass)) {
			System.out.println("password don`t identical");
			return "home";
		}else { 
			System.out.println("password ok");
		userService.saveUser(user);
		userService.createFolder(user);}
		return "redirect:/user/"+user.getId()+"/detail"; 
	}*/
	
	
	@GetMapping("/social")
	public String showSocial(Model model) {
		
		model.addAttribute("title", "Cоціальні мережі");
		return "social";
	}
	

	
	@GetMapping("/video")
	public String showVideo(Model model) {
		String video="width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/Kf5MkitxNk4\" frameborder=\"1\" allow=\"autoplay; encrypted-media\" allowfullscreen";

		model.addAttribute("aa", video);
		model.addAttribute("title", "Відео");
		return "video";
	}
	

	
	@GetMapping("/contacts")
	public String showContact(Model model) {
		
		model.addAttribute("title", "Контакти");
		return "club/contacts";
	}
	
	@GetMapping("/leadership")
	public String showLeadership(Model model) {
		
		model.addAttribute("title", "Керівництво");
		return "club/leadership";
	}
	
	@GetMapping("/symbols")
	public String showSymbols(Model model) {
		
		model.addAttribute("title", "Символіка");
		return "club/symbols";
	}
	
	@GetMapping("/history")
	public String showHistory(Model model) {
		
		model.addAttribute("title", "Історія");
		return "club/history";
	}
	
	@GetMapping("/shop")
	public String showMagazine(Model model) {
		
		model.addAttribute("title", "Магазин");
		return "tmp";
	}
	
	@GetMapping("/victoria-2009")
	public String showVictoria2009(Model model) {
		
		model.addAttribute("title", "FC - VICTORIA 2009");
		return "tmp";
	}

	@GetMapping("/forgotpass")
	public String forgotpass(Model model) {
		
		model.addAttribute("title", "Відновлення паролю");
		return "forgotpass";
	}
	@PostMapping("/forgotpass")
	public String forgotpassnewpass(@RequestParam("email") String email) {
		if(userService.findUserByEmail(email)!=null) {
			userService.forgotPass(userService.findUserByEmail(email));
		
		}
		
		
		return "redirect:/";
	}
	
	@GetMapping("/droppass")
	public String droppassUser(@RequestParam("token") String token,
			@RequestParam("userid") String useridStr,
			Model model) {
		
		try {
			int userId = Integer.valueOf(useridStr);
			UserEntity entity  = userService.findUserById(userId);
			
			ForgotRequest request = UserMapper.entityToForgotRequest(entity);
			
			if(request.getToken().equals(token)) {
					model.addAttribute("newPass", request);
					return "dropPass";
			}
		}
		catch (Exception e) {
			model.addAttribute("error", "Opps..Verify error");
			return "verify/verify-error";
		}
		
		model.addAttribute("title", "Скинення паролю");
		return "tmp";
		
	} 
	@PostMapping("/droppass")
	public String  saveNewEditUser(@Valid @ModelAttribute("newPass") ForgotRequest request,BindingResult result) {
		
		System.out.println(result.getAllErrors());
		if(result.hasErrors()){
			return "tmp";
		}
		UserEntity entity;
		if(request != null && request.getPassword()!= null) {
			entity = userService.findUserByEmail(request.getEmail());
			entity.setPassword(request.getPassword());
			userService.updateAfterForgot(entity);
		}
		return "redirect:/";
	}
}
