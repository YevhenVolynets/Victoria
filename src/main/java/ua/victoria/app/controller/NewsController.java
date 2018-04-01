package ua.victoria.app.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.victoria.app.entity.News;
import ua.victoria.app.service.NewsService;
import ua.victoria.app.service.utils.CustomFileUtils;

@Controller
@RequestMapping("/news")
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	@GetMapping("/")
	public String showNews(Model model) throws IOException {
		
		model.addAttribute("allNews", newsService.findAll());
		List<News> list =  newsService.findAll();
		for (News news : list) {
			String oldPathfoto = news.getPathToFoto();
			news.setPathToFoto(CustomFileUtils.getImage("news"+CustomFileUtils.SEPARATOR+oldPathfoto+".png"));
		}
		model.addAttribute("allNews", list);
	
		return "news/allnews";
	}  

	@GetMapping("/{id}")
	public String showOnePost(@PathVariable("id") String id,Model model) throws IOException, ParseException {
		News post = newsService.findNewsById(Integer.valueOf(id));
  
	        Locale ukrainian = new Locale("ua");
	        String[] months  = {
	          "січня", "лютого", "березня", "квітня", "травня", "червня", 
	          "липня", "серпня", "вересня", "жовтня", "листопада", "грудня"};
	        String[] shortMonths = {
	                "січ", "лют", "бер", "кві", "тра", "чер",
	                "лип", "сер", "вер", "жов", "лис", "гру"};
	        String[] weekdays  = {
	        		"","Неділя","Понеділок", "Вівторок", "Середа", "Четвер", "П`ятниця", "Субота"
	  	          };
	        String[] shortWeekdays = {"", "нд", "пн", "вт", "ср", "чт", "пт", "сб"};
	        
	        DateFormatSymbols dfs = DateFormatSymbols.getInstance(ukrainian);
	        dfs.setMonths(months);
	        dfs.setShortMonths(shortMonths);
	        dfs.setWeekdays(weekdays);
	        dfs.setShortWeekdays(shortWeekdays);
	        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, ukrainian);
	        SimpleDateFormat sdf = (SimpleDateFormat) df;
	        sdf.setDateFormatSymbols(dfs);
	        

	        Date jud = new SimpleDateFormat("yyyy-MM-dd").parse(post.getCreateDate().toString());
	        String month = sdf.format(jud);
	        
	        
	        
		String oldPathfoto = post.getPathToFoto();
		post.setPathToFoto(CustomFileUtils.getImage("news"+CustomFileUtils.SEPARATOR+oldPathfoto+".png"));
		
		model.addAttribute("post", post);
		return "news/post";
	}
}
