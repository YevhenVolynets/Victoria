package ua.victoria.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ua.victoria.app.entity.ParserTableResult;
import ua.victoria.app.repository.ParserTableResultRepository;
import ua.victoria.app.service.StatisticsFootballerService;

public class StatisticsFootballerServiceImpl implements StatisticsFootballerService{

	@Autowired
	private ParserTableResultRepository parserTableResultRepository;
	
	public void saveTable() {
		List<ParserTableResult> list = parserTableResultRepository.findAll();
	}
	
}
