package ua.victoria.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.victoria.app.entity.StatisticsFootballer;

@Repository
public interface StatisticsFootballerRepository  extends JpaRepository<StatisticsFootballer, Integer>{

}
