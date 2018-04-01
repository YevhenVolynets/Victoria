package ua.victoria.app.entity.enumerated;

public enum TypeCoach {
	HeadCoach(1),
	CoachAssistant(2),
	GoalkeeperCoach(3),
	Sponsor(4),
	PresidentClub(5);
	  int val;
	  TypeCoach (int val) {
	        this.val = val;
	    }

	  
}
