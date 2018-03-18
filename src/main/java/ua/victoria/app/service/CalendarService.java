package ua.victoria.app.service;

import java.util.List;

import ua.victoria.app.entity.Calendar;

public interface CalendarService {
	
	void saveCalendar(Calendar calendar);

	void workWithPars();
	
	List<Calendar> findAllCalendar();
	
	Calendar findOneCalendar(int id);
}
