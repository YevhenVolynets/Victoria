package ua.victoria.app.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.victoria.app.entity.Ligue;
import ua.victoria.app.entity.StatisticsTeam;
import ua.victoria.app.entity.Team;

@Repository
public interface StatisticsTeamRepository  extends JpaRepository<StatisticsTeam, Integer>{

	@Query("SELECT s FROM StatisticsTeam s WHERE s.ligue = :ligue")
	List<StatisticsTeam> findLigue(@Param("ligue") Ligue ligue);
	
	@Query("SELECT s FROM StatisticsTeam s WHERE s.team = :team")
	StatisticsTeam findStatByTeam(@Param("team") Team team);
}
