package ua.victoria.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.victoria.app.entity.Calendar;
import ua.victoria.app.entity.Team;

@Repository
public interface CalendarRepository  extends JpaRepository<Calendar, Integer>{

	
	@Query("SELECT c FROM Calendar c where c.teamHome =:team or c.teamGuest= :team order by c.dateGame DESC")
	List<Calendar> findLastMatch(@Param("team") Team team); 
}
