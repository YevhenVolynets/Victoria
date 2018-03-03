package ua.victoria.app.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.victoria.app.entity.ParserCoach;
import ua.victoria.app.repository.ParserCoachRepository;
import ua.victoria.app.service.ParserCoachService;

@Service
public class ParserCoachServiceImpl implements ParserCoachService{
	
	Document doc;
	
	@Autowired
	private ParserCoachRepository parserCoachRepository;
	
	@Override
	public void connectToSite() throws IOException {
		
	 doc = Jsoup.connect("http://www.dufll.org.ua/files/").get();
	 
	List<ParserCoach> list = new ArrayList<>();
	
	ParserCoach coachInfo;
	
	Element myEl = doc.getElementsByTag("table").first();
	
	
	for (int i = 4; i <= 248; i+=2) {
		
		coachInfo= new ParserCoach();
		for (int j = 1; j <= 9; j+=2) {
			
			switch (j) {
            case 1: { 
            			String yearString = myEl.childNode(1).childNode(i)
                        		.childNode(1).childNode(0).toString();
            			
            	
            		coachInfo.setYearTeam(yearString);
                     break;}
            
            case 3:  {
            			String nameTeam= myEl.childNode(1).childNode(i)
                        		.childNode(3).childNode(0).toString();
            			coachInfo.setNameTeam(nameTeam);
            		
                     break;}
            
            case 5:   break;
            
            case 7:  {
            			String nameCoach = myEl.childNode(1).childNode(i)
                        		.childNode(7).childNode(0).toString();
            			coachInfo.setNameCoach(nameCoach);
            
                     break;}
            
            case 9:  {
            			String phoneNumber = myEl.childNode(1).childNode(i)
                        		.childNode(9).childNode(0).toString();
            			coachInfo.setPhoneNumber(phoneNumber);
            			
                     break;}
				}
			
		}
		list.add(coachInfo);
		parserCoachRepository.save(coachInfo);
	}
	
	 
	 
	}

	@Override
	public void saveParserCoach(ParserCoach parserCoach) {
		
		parserCoachRepository.save(parserCoach);
	}

}
