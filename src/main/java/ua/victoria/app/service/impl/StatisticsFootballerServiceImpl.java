package ua.victoria.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.victoria.app.entity.ParserTableResult;
import ua.victoria.app.entity.StatisticsFootballer;
import ua.victoria.app.repository.ParserTableResultRepository;
import ua.victoria.app.repository.StatisticsFootballerRepository;
import ua.victoria.app.service.StatisticsFootballerService;

@Service
public class StatisticsFootballerServiceImpl implements StatisticsFootballerService{

	@Autowired
	private ParserTableResultRepository parserTableResultRepository;
	
	@Autowired
	private StatisticsFootballerRepository statisticsFootballerRepository;
	
	public void saveTable() {
		List<ParserTableResult> list = parserTableResultRepository.findAll();
	}

	@Override
	public void saveStatistics(StatisticsFootballer statisticsFootballer) {
		
		statisticsFootballerRepository.save(statisticsFootballer);
	}
	
	
	
}
