package ua.victoria.app.controller;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.victoria.app.entity.User;
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
		model.addAttribute("userModelka", new User());
		model.addAttribute("userRoless",UserRole.values());
		
		return "home";
	}
	
	@PostMapping("/")
	public String saveUser(@ModelAttribute("userModelka") @Valid User user,@RequestParam("password2") String pass, BindingResult result ) {
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
	}
	
	
	@GetMapping("/social")
	public String showSocial() {
		
		
		return "/social";
	}
	
	@GetMapping("/photos")
	public String showPhoto() {
		
		
		return "/photo";
	}
	
	@GetMapping("/video")
	public String showVideo() {
		
		
		return "/video";
	}
	
	@GetMapping("/contacts")
	public String showContact() {
		
		
		return "/club/contacts";
	}
}
