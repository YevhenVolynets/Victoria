package ua.victoria.app.service.impl;


import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.victoria.app.entity.News;
import ua.victoria.app.repository.NewsRepository;
import ua.victoria.app.service.AdminService;
import ua.victoria.app.service.utils.CustomFileUtils;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private NewsRepository newsRepository;
	
	@Override
	public void createFolder(String foldername) {
		 CustomFileUtils.createFolder(foldername);
	}

	@Override
	public void save(News news) {
		newsRepository.save(news);
		
	}

}
