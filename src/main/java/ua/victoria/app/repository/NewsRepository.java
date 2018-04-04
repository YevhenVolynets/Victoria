package ua.victoria.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.victoria.app.entity.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
	
	

}
