package ua.victoria.app.service;

import java.util.List;

import ua.victoria.app.entity.Footballer;

public interface FootballerService {

	void savePlayer(Footballer footballer);
	
	Footballer findByIdPlayer(int id);
	
	List<Footballer> findAll();
}
