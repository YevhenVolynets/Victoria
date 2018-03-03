package ua.victoria.app.service;

import java.io.IOException;

import ua.victoria.app.entity.ParserCoach;

public interface ParserCoachService {
	
	 void connectToSite() throws IOException;
	 
	 void saveParserCoach(ParserCoach parserCoach);

}
