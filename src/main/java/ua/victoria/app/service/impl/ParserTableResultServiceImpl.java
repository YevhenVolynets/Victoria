package ua.victoria.app.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.victoria.app.entity.ParserTableResult;
import ua.victoria.app.repository.ParserTableResultRepository;
import ua.victoria.app.service.ParserTableResultService;

@Service
public class ParserTableResultServiceImpl implements ParserTableResultService {

	private  ParserTableResultRepository parserTableResultRepository;
	
	@Autowired
	public ParserTableResultServiceImpl(ParserTableResultRepository parserTableResultRepository) {
		this.parserTableResultRepository = parserTableResultRepository;
	}

	@Override
	public void saveParserTableResult(ParserTableResult parserTableResult) {
		parserTableResultRepository.save(parserTableResult);

	}

	@Override
	public void connectToSite() throws IOException {
		
		//List<ParserTableResult> tableResult = new ArrayList<>();
		
		Document doc = Jsoup.connect("http://www.dufll.org.ua/tables/2017/dufll/2004/").get();

		Element tableScoreOne = doc.getElementById("lt_28");
		
		Object aqq;
		int numNodes = 0;

		for (int i = 0; i < 100; i++) {

			aqq = tableScoreOne.childNode(1).childNode(i).nextSibling();
			if (aqq == null) {
				numNodes = i - 1;
				break;
			}
		}
		
		final int finalNumNodes = numNodes;
		final int startNode = 1;
		final int nameNode = startNode + 2;
		final int startTeamNode = nameNode + 2;
		final int lastTeamNode = 2 * (finalNumNodes - 1) + startTeamNode;
		final int lastTableNode = lastTeamNode + 12;
		
		
		
		for (int i = 2; i <= numNodes + 1; i++) {
			String listTeams="";
			ParserTableResult table = new ParserTableResult();
			List<String> tempTeam = new ArrayList<>();
			for (int j = startNode; j <= lastTableNode; j += 2) {

				if (j == startNode) {
					table.setNumInTable(tableScoreOne.childNode(1).childNode(i).childNode(startNode).childNode(0).toString());

				}

				if (j == nameNode) {
					table.setName(tableScoreOne.childNode(1).childNode(i).childNode(nameNode).childNode(0).childNode(0)
							.toString());

				}

				if ((j >= startTeamNode) && (j <= lastTeamNode)) {

					String aaa = tableScoreOne.childNode(1).childNode(i).childNode(j).childNode(0).toString();

					if (aaa.equalsIgnoreCase("x")) {

						tempTeam.add(aaa);

					} else {

						String value = "value";

						int inx = aaa.indexOf(value);


						String substr = aaa.substring(inx + 6, inx + 12).trim();
						int lengt = substr.length();
						String finstr = substr.substring(1, lengt - 1);

						if (finstr.equalsIgnoreCase("\" re")) {
							tempTeam.add("null");
						} else {
							tempTeam.add(finstr);
						}
					} 

				}

				if (j > lastTeamNode) {
					String aaa = tableScoreOne.childNode(1).childNode(i).childNode(j).childNode(0).toString();

					if (j == lastTeamNode + 2) {
						table.setGame(aaa);
					}
					if (j == lastTeamNode + 4) {
						table.setWin(aaa);
					}
					if (j == lastTeamNode + 6) {
						table.setDraw(aaa);
					}
					if (j == lastTeamNode + 8) {
						table.setLose(aaa);
					}
					if (j == lastTeamNode + 10) {
						table.setScoredMissedGoal(aaa);
					}
					if (j == lastTeamNode + 12) {
						table.setPoint(aaa);
					}

				}

			}
			
			for (String string : tempTeam) {
				listTeams += string+",";
			}
			table.setListTeams(listTeams);
			//tableResult.add(table);
			parserTableResultRepository.save(table);
		}

	}

}
