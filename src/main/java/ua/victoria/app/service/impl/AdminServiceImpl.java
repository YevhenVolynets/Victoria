package ua.victoria.app.service.impl;


import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.victoria.app.entity.News;
import ua.victoria.app.repository.NewsRepository;
import ua.victoria.app.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private NewsRepository newsRepository;
	
	@Override
	public void createFolder() {
		 File file = new File("D:\\tmp\\admin");
	        if (!file.exists()) {
	            if (file.mkdir()) {
	                System.out.println("Directory is created!");
	            } else {
	                System.out.println("Failed to create directory!");
	            }
	        }
	}

	@Override
	public void save(News news) {
		newsRepository.save(news);
		
	}

}
