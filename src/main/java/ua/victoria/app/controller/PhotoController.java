package ua.victoria.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ua.victoria.app.service.PhotoService;

@Controller
public class PhotoController {

	@Autowired
	private PhotoService photoService;
	
	@GetMapping("/photos")
	public String showPhoto(Model model) {	
		model.addAttribute("allphoto", photoService.findllPhoto());
		model.addAttribute("title", "Фото");
		return "photo";
	}
}
