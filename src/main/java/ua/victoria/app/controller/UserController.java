package ua.victoria.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.victoria.app.editor.UserEditor;
import ua.victoria.app.entity.User;
import ua.victoria.app.entity.UserRole;
import ua.victoria.app.service.UserService;

@Controller
@SessionAttributes("userModel")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@InitBinder("user") //вказується назва сессії
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(User.class, new UserEditor(userService));
	}
	
	@GetMapping("/add")
	public String showUserAddPAge(Model model) {
		model.addAttribute("userModel", new User());
		model.addAttribute("userRoles",UserRole.values());
		
		return "user/add";
	}
	
	@GetMapping("/list")
	public String showAllUsers(Model model) {
		model.addAttribute("usersList", userService.findAllUsers());
		
		return "user/list";
	}
	
	@PostMapping("/add")
	public String saveUser(@ModelAttribute("userModel") @Valid User user, BindingResult result ) {
		if(result.hasErrors()) {
			return "user/add";
		}
		userService.saveUser(user);
		return "redirect:/user/list";
	}

}
