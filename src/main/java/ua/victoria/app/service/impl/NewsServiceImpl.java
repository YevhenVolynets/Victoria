package ua.victoria.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ua.victoria.app.entity.News;
import ua.victoria.app.repository.NewsRepository;
import ua.victoria.app.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService{

	@Autowired
	private NewsRepository newsRepository;
	
	@Override
	public void saveNews(News news) {
		newsRepository.save(news);
	}

	@Override
	public News findNewsById(int id) {
		
		return newsRepository.findOne(id);
	}

	@Override
	public List<News> findAll() {
		
		return newsRepository.findAll();
	}

	@Override
	public List<News> findAllAndSortByDate() {
		
		return newsRepository.findAll(new Sort(Sort.Direction.DESC, "createDate"));
	}

}
