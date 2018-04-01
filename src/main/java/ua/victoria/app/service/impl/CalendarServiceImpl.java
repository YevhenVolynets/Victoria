package ua.victoria.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.victoria.app.entity.Calendar;
import ua.victoria.app.entity.ParserTableResult;
import ua.victoria.app.entity.Team;
import ua.victoria.app.entity.enumerated.Ligue;
import ua.victoria.app.repository.CalendarRepository;
import ua.victoria.app.repository.ParserTableResultRepository;
import ua.victoria.app.repository.TeamRepository;
import ua.victoria.app.service.CalendarService;

@Service
public class CalendarServiceImpl implements CalendarService{
	
	@Autowired
	private ParserTableResultRepository parserTableResultRepository;
	
	@Autowired
	private CalendarRepository calendarRepository;
	
	@Autowired
	private TeamRepository teamRepository; 

	@Override
	public void saveCalendar(Calendar calendar) {
		calendarRepository.save(calendar);
	}
	
	@Override
	public void workWithPars() {
		List<ParserTableResult> list = parserTableResultRepository.findAll();
		int i = 1;
		int j = 1;
		for (ParserTableResult parserTableResult : list) {
			
			String listResult = parserTableResult.getListTeams();
			/*List<String> result = new ArrayList<>();*/
			if(parserTableResult.getLigue()==Ligue.First) {
				j = 1;
			}
			if (parserTableResult.getLigue()==Ligue.Second) {
				j = 10;
			}
			for (String retval : listResult.split(",")) {
				Calendar calendar = new Calendar();
				/*result.add(retval);*/
				if(retval.equalsIgnoreCase("X")) {
					
					j++;continue;
				}else if(retval.equalsIgnoreCase("null")) {
					/*Team teamHome = teamRepository.findOne(i);
					Team teamGuest = teamRepository.findOne(j);
					calendar.setTeamHome(teamHome);
					calendar.setTeamGuest(teamGuest);
					List<String> result = new ArrayList<>();
					for (String res : retval.split(":")) {
						result.add(res);
			        }
					calendar.setScoreHome(909);
					calendar.setScoreGuest(909);
					calendar.setLigue(parserTableResult.getLigue());
					saveCalendar(calendar);*/
					j++;
					continue; 
				}
				else {
					Team teamHome = teamRepository.findOne(i);
					Team teamGuest = teamRepository.findOne(j);
					calendar.setTeamHome(teamHome);
					calendar.setTeamGuest(teamGuest);
					List<String> result = new ArrayList<>();
					for (String res : retval.split(":")) {
						result.add(res);
			        }
					calendar.setScoreHome(Integer.valueOf(result.get(0)));
					calendar.setScoreGuest(Integer.valueOf(result.get(1)));
					calendar.setLigue(parserTableResult.getLigue());
					saveCalendar(calendar);
					j++;
				}
	        }
			
			i++;
		}
	}

	@Override
	public List<Calendar> findAllCalendar() {
		
		return calendarRepository.findAll();
	}

	@Override
	public Calendar findOneCalendar(int id) {
		
		return calendarRepository.findOne(id);
	}

	@Override
	public Calendar findLastMatch(Team team) {
	
		return calendarRepository.findLastMatch(team).get(0);
	}

	@Override
	public List<Calendar> findGuestCalendar(Team teamgust) {
		
		return calendarRepository.findGuestCalendar(teamgust);
	}

	@Override
	public List<Calendar> findHomeCalendar(Team teamhome) {
		
		return calendarRepository.findHomeCalendar(teamhome);
	}

}
