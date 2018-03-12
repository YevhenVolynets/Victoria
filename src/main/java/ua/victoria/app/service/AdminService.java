package ua.victoria.app.service;

import ua.victoria.app.entity.News;

public interface AdminService {
	
	void createFolder();
	
	void save(News news);

}
