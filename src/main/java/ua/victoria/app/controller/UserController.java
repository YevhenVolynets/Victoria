package ua.victoria.app.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.Principal;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import ua.victoria.app.editor.UserEditor;
import ua.victoria.app.entity.UserEntity;
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
		binder.registerCustomEditor(UserEntity.class, new UserEditor(userService));
	}
	
	@GetMapping("/profile")
	public String showProfile(Model model,Principal principal) { 
		UserEntity entity = userService.findUserByEmail(principal.getName());
		model.addAttribute("user", entity);
		return "user/profile";
	}
	
	@GetMapping("/{userId}/detail")
	public String showUser(@PathVariable("userId") int userId, Model model) throws IOException {
		
		String fileName = "D:/tmp/"+userId+"/logo.png";
		if ((new File(fileName)).exists()) {
			File file = new File("D:/tmp/"+userId+"/logo.png");
			
			byte[] encodeFileToByte = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
			String encodeFileBase64 = new String(encodeFileToByte);
			model.addAttribute("imageFromDisk",encodeFileBase64);
		} else {
			File file = new File("D:/tmp/default.png");
			byte[] encodeFileToByte = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
			String encodeFileBase64 = new String(encodeFileToByte);
			model.addAttribute("imageFromDisk",encodeFileBase64);
		} 

		UserEntity user1 = userService.findUserById(userId);
		model.addAttribute("userOne",user1);
		System.out.println(user1);
		return "user/detail";
	}
	
	@PostMapping("/add")
	public String saveUser(@ModelAttribute("userModel") @Valid UserEntity user, BindingResult result ) {
		if(result.hasErrors()) {
			return "user/add";
		}
		userService.saveUser(user);
		return "redirect:/";
	}
	
	
	
	@GetMapping("/{userId}/edit")
	public String editUser(@PathVariable("userId") int userId, Model model ) {
		
		UserEntity user =userService.findUserById(userId);
		model.addAttribute("userEdit",user);
		
		return "user/edit";
	}
	
	@PostMapping("/{userId}/edit")
	public String saveEditUser(
			@PathVariable("userId") int userId,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("phone") String phone) {
		/*System.out.println(user);
		System.out.println(result);*/
		UserEntity user =userService.findUserById(userId);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPhone(phone);
		
		userService.saveUser(user);
		
		return "redirect:/user/"+user.getId()+"/detail";
	}
	
	@PostMapping("/{userId}/edit/img")
	public String saveFileToDisk(@PathVariable("userId") int userId,@RequestParam("fileUpload") MultipartFile file) throws IOException {
		
		if (!file.isEmpty() && file!=null) {
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
			File dest = new File("D:/tmp/" +userId+"/logo.png");
			ImageIO.write(image, "png", dest);
		}
		
		return "redirect:/user/"+userId+"/detail";
	}
	/*@PostMapping("/login")
	public String loginInSystem(
			@RequestParam("login") String login,
			@RequestParam("password") String password) {
		System.out.println(login);
		System.out.println(password);
		UserEntity user = userService.findUserByLogin(login);
		if (user.getPassword().equals(password)) {
			return "redirect:/user/"+user.getId()+"/detail";
		}
		else return "redirect:/";
		
	}*/

}
