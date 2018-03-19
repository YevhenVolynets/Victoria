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

import ua.victoria.app.entity.UserEntity;
import ua.victoria.app.entity.UserRole;
import ua.victoria.app.service.UserService;

@Controller
public class BaseController {
	
	
	@Autowired
	private UserService userService;  
	/*@GetMapping("/")
	public String showHome() {
		
		return "home";
	}*/
	
	@GetMapping("/")
	public String showUserAddPAge(Model model) {
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
		model.addAttribute("list1", list);
		
		model.addAttribute("userModelka", new UserEntity());
		model.addAttribute("userRoless",UserRole.values());
		
		return "home";
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
	public String showSocial() {
		
		
		return "social";
	}
	
	@GetMapping("/photos")
	public String showPhoto() {
		
		
		return "photo";
	}
	
	@GetMapping("/video")
	public String showVideo(Model model) {
		String aa="width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/Kf5MkitxNk4\" frameborder=\"1\" allow=\"autoplay; encrypted-media\" allowfullscreen";

		model.addAttribute("aa", aa);
		
		return "video";
	}
	
	@GetMapping("/contacts")
	public String showContact() {
		
		
		return "club/contacts";
	}
	
	
}
