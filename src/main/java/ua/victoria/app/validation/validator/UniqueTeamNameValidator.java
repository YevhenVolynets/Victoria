package ua.victoria.app.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.victoria.app.service.TeamService;
import ua.victoria.app.validation.annotation.UniqueTeamName;

@Component
public class UniqueTeamNameValidator implements ConstraintValidator<UniqueTeamName, String>{

	private TeamService teamService;
	
	@Autowired
	public UniqueTeamNameValidator(TeamService teamService) {
		this.teamService = teamService;
	}

	@Override
	public void initialize(UniqueTeamName arg0) {

		
	}

	@Override
	public boolean isValid(String nameTeam, ConstraintValidatorContext arg1) {
		if(nameTeam == null) {
			return false;
		}
		if(teamService.findTeamByNameTeam(nameTeam) != null) {
			return false;
		}else
			return true;
		
		
	}

}
