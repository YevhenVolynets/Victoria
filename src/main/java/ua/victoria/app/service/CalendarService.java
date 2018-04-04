package ua.victoria.app.service;

import java.util.List;

import org.springframework.data.domain.Page;

import ua.victoria.app.entity.Calendar;
import ua.victoria.app.entity.Team;

public interface CalendarService {
	
	void saveCalendar(Calendar calendar);

	void workWithPars();
	
	List<Calendar> findAllCalendar();
		
	Calendar findOneCalendar(int id);
	
	Calendar findLastMatch(Team team);
	
	List<Calendar> findGuestCalendar(Team teamguest);
	
	List<Calendar> findHomeCalendar(Team teamhome);
	
	Page<Calendar> getPagebleCalendar(
			int pageNumber,
			int pageSize,
			String sort,
			String sortByField);
}
