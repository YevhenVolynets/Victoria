package ua.victoria.app.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
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
import ua.victoria.app.entity.UserDetail;
import ua.victoria.app.entity.UserEntity;
import ua.victoria.app.entity.UserRole;
import ua.victoria.app.entity.enumerated.Gender;
import ua.victoria.app.service.UserDetailService;
import ua.victoria.app.service.UserService;
import ua.victoria.app.service.utils.CustomFileUtils;

@Controller
@SessionAttributes({"userModel","userEdit"})
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDetailService userDetailService;
	
	@InitBinder("user") //вказується назва сессії
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(UserEntity.class, new UserEditor(userService));
	}
	
	@GetMapping("/profile")
	public String showProfile(Model model,Principal principal) throws IOException { 
		
		UserEntity entity = userService.findUserByEmail(principal.getName());
		UserDetail userDetail;
		if(entity.getUserDetail()== null) {
			 userDetail = new UserDetail();
			 entity.setUserDetail(userDetail);
			 userDetailService.saveUserDetail(userDetail);
		}
		
		/*entity.getUserDetail().setImagePath(CustomFileUtils.getImage(entity));*/
		
		/*userService.updateUser(entity);*/
		
		model.addAttribute("img", CustomFileUtils.getImage(entity));
		
		/*File folder = CustomFileUtils.createFolder("user_"+entity.getId());
		
		if ((new File(folder.toString()+CustomFileUtils.SEPARATOR+"logo.png")).exists()) {
			File file = new File("D:/tmp/"+entity.getId()+"/logo.png");
			
			byte[] encodeFileToByte = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
			String encodeFileBase64 = new String(encodeFileToByte);
			model.addAttribute("imageFromDisk",encodeFileBase64);
		} else {
			File file = new File("D:/tmp/default.png");
			byte[] encodeFileToByte = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
			String encodeFileBase64 = new String(encodeFileToByte);
			model.addAttribute("imageFromDisk",encodeFileBase64);
		} */
		
		model.addAttribute("title",entity.getUserDetail().getFirstName() +" "+ entity.getUserDetail().getLastName());
		model.addAttribute("user", entity);
		return "user/profile";
	}
	

	/*@GetMapping("/{userId}/detail")
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
	}*/
	
	/*@PostMapping("/{userId}/edit")
	public String saveEditUser(
			@PathVariable("userId") int userId,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("phone") String phone) {
		System.out.println(user);
		System.out.println(result);
		UserEntity user =userService.findUserById(userId);
		UserDetail userDetail = new UserDetail();
		
		userDetail.setFirstName(firstName);
		userDetail.setLastName(lastName);
		userDetail.setPhone(phone);
		
		userService.saveUser(user);
		
		return "redirect:/user/"+user.getId()+"/detail";
	}*/
	
	
	/*@PostMapping("/add")
	public String saveUser(@ModelAttribute("userModel") @Valid UserEntity user, BindingResult result ) {
		if(result.hasErrors()) {
			return "user/add";
		}
		userService.saveUser(user);
		return "redirect:/";
	}*/
	
	
	
	@GetMapping("/edit")
	public String editUser(Model model,Principal principal ) {
		
		UserEntity userEntity =userService.findUserByEmail(principal.getName());
		
		userService.updateUser(userEntity);
		List<Gender> list = new ArrayList<>();
		list.add(Gender.MAN);list.add(Gender.WONAN);
		model.addAttribute("sex", list);
		model.addAttribute("userEdit",userEntity);
		model.addAttribute("title","Редагування профілю");
		return "user/edit";
	} 
	
	@PostMapping("/saveuser")
	public String saveUserEdit(@ModelAttribute("userEdit") UserEntity userEntity,@RequestParam("birthday") String date) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		  try {

	          Date date1 = formatter.parse(date);  
	          UserDetail userDetail = userEntity.getUserDetail();
	          userDetail.setBirthday(date1);
	          formatter.format(date1);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 
		userDetailService.saveUserDetail(userEntity.getUserDetail());
		userService.updateUser(userEntity);
		return "redirect:/user/profile"; 
	}
	
	
	
	@PostMapping("/edit/img")
	public String saveFileToDisk(@RequestParam("fileUpload") MultipartFile file,Principal principal) throws IOException {
		UserEntity entity = userService.findUserByEmail(principal.getName());
		if (!file.isEmpty() && file!=null) {
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
			File dest = new File(CustomFileUtils.ROOT_PATH+CustomFileUtils.SEPARATOR+"user_"+entity.getId()+CustomFileUtils.SEPARATOR+"logo.png");
			ImageIO.write(image, "png", dest);
		}
		
		return "redirect:/user/profile";
	}
	


}
	
