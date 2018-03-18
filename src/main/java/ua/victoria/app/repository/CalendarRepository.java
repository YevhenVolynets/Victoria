package ua.victoria.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.victoria.app.entity.Calendar;

@Repository
public interface CalendarRepository  extends JpaRepository<Calendar, Integer>{

}
