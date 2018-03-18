package ua.victoria.app.service;

import java.io.IOException;

import ua.victoria.app.entity.ParserTableResult;

public interface ParserTableResultService {
	
	void saveParserTableResult(ParserTableResult parserTableResult);
	
	void connectToSite(String id) throws IOException;

}
