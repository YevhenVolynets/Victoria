package ua.victoria.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.victoria.app.entity.Footballer;
import ua.victoria.app.entity.Team;
@Repository
public interface FootballerRepository extends JpaRepository<Footballer, Integer>{
	
	@Query("SELECT f FROM Footballer f WHERE f.team = :team ORDER BY f.numberShirt ASC")
	List<Footballer> findPlayerByIdTeamAndSortByNumberShirt(@Param("team") Team team);
	
	@Query("SELECT f FROM Footballer f WHERE f.team = :team ORDER BY f.statistics.goal DESC")
	List<Footballer> findPlayerByIdTeamAndSortByNumberGoal(@Param("team") Team team);

	@Query("SELECT f FROM Footballer f WHERE f.team = :team")
	List<Footballer> findPlayerByTeam(@Param("team") Team team);
}
