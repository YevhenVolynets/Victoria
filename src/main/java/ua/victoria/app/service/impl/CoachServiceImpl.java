package ua.victoria.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.victoria.app.entity.Coach;
import ua.victoria.app.entity.ParserCoach;
import ua.victoria.app.repository.CoachRepository;
import ua.victoria.app.repository.ParserCoachRepository;
import ua.victoria.app.service.CoachService;

@Service
public class CoachServiceImpl implements CoachService {

	@Autowired
	private CoachRepository coachRepository;
	
	@Autowired
	private ParserCoachRepository parserCoachRepository;
	
	@Override
	public void saveCoach(Coach coach) {
		
		coachRepository.save(coach);
	}
	
	public void CoachToTeam(int year) {
		String yearStr =String.valueOf(year);
		List<ParserCoach> list = parserCoachRepository.findCoachByYear(yearStr);
		List<String> tmpName = new ArrayList<>();
		for (ParserCoach parserCoach : list) {
			String nameTeam = parserCoach.getNameTeam();
			if (nameTeam.indexOf(",")!=-1) {
				 for (String retval : nameTeam.split(",", 2)) {
					 tmpName.add(retval);
			        }
			}else {
				tmpName.add(nameTeam);
			}
		}
	}

}
