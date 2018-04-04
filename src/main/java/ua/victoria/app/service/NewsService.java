package ua.victoria.app.service;

import java.util.List;

import ua.victoria.app.entity.News;

public interface NewsService {
	
	void saveNews(News news);
	
	News findNewsById(int id);
	
	List<News> findAll();
	
	List<News> findAllAndSortByDate();

}
