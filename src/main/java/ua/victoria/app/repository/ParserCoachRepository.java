package ua.victoria.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.victoria.app.entity.ParserCoach;

@Repository
public interface ParserCoachRepository extends JpaRepository<ParserCoach, Integer>{

	@Query("SELECT p FROM ParserCoach p WHERE p.yearTeam = :yearTeam")
	List<ParserCoach> findCoachByYear(@Param("yearTeam") String year);
	
	
}
