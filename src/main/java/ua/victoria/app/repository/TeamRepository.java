package ua.victoria.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.victoria.app.entity.Footballer;
import ua.victoria.app.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{
	
	@Query("SELECT t FROM Team t WHERE t.nameTeam = :nameTeam")
	Team findTeamByNameTeam(@Param("nameTeam") String nameTeam);
	

}
