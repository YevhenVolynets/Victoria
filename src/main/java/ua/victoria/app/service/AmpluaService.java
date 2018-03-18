package ua.victoria.app.service;

import java.util.List;

import ua.victoria.app.entity.Amplua;

public interface AmpluaService {
	
	void save(Amplua amlpua);
	
	List<Amplua> findAllAmplua();
	
	Amplua findAmpluaById(int id);
	
	void createAmplua();

}
