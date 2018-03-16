package ua.victoria.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.victoria.app.entity.Ligue;
import ua.victoria.app.entity.StatisticsTeam;
import ua.victoria.app.repository.StatisticsTeamRepository;
import ua.victoria.app.service.StatisticsTeamService;

@Controller
@RequestMapping("/statistics")
public class StatisticsTeamController {
	
	@Autowired
	private StatisticsTeamService statisticsTeamService;
	
//	@Autowired
//	private StatisticsTeamRepository statisticsTeamRepository;

	@GetMapping("/tournament-table")
	public String showTable(Model model) {
		
		model.addAttribute("listStat1",statisticsTeamService.findPremierLigue());
		model.addAttribute("listStat2", statisticsTeamService.findSecondLigue());
		/*System.out.println(statisticsTeamService.findPremierLigue());*/
		
		/*StatisticsTeam st = new StatisticsTeam();
		st.setCountMatch(1);
		st.setDrawMatch(1);
		st.setLoseMatch(1);
		st.setMissedGoal(1);
		st.setPoint(1);
		st.setScoredGoal(1);
		st.setLigue(Ligue.Second);
		
		statisticsTeamRepository.save(st);*/
		
		
		return "statistics/team/statisticsTable";
	}
}
