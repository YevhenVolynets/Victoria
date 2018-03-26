package ua.victoria.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.victoria.app.entity.Footballer;
import ua.victoria.app.repository.FootballerRepository;
import ua.victoria.app.service.FootballerService;

@Service
public class FootballerServiceImpl implements FootballerService{

	@Autowired
	private FootballerRepository footballerRepository;
	
	@Override
	public void savePlayer(Footballer footballer) {
		footballerRepository.save(footballer);
		
	}

	@Override
	public Footballer findByIdPlayer(int id) {
		
		return footballerRepository.findOne(id);
	}

	@Override
	public List<Footballer> findAll() {
	
		return footballerRepository.findAll();
	}

}
