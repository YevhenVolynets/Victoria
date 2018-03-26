package ua.victoria.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.victoria.app.entity.Coach;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Integer>{
	

}
