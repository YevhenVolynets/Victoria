package ua.victoria.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.victoria.app.entity.ParserTableResult;

@Repository
public interface ParserTableResultRepository extends JpaRepository<ParserTableResult, Integer> {

}
