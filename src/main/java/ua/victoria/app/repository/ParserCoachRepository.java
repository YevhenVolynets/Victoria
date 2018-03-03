package ua.victoria.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.victoria.app.entity.ParserCoach;

@Repository
public interface ParserCoachRepository extends JpaRepository<ParserCoach, Integer>{

}
