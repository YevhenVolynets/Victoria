package ua.victoria.app.entity;

public enum Position {
	
	GOALKEEPER ("ГК(Голкіпер)"),
	 СENTRAL_DEFENDER("ЦЗ(центральний захисник)"),
	 RIGHT_DEFENDER("ПЗ(правий захисник)"),
	 LEFT_DEFENDER("ЛЗ(лівий захисник)"),
	 CENTRAL_MIDFIELDER("ЦПЗ(центральний півзахисник)"),
	 RIGHT_MIDFIELDER("ППЗ(правий півзахисник)"),
	 LEFT_MIDFIELDER("ЛПЗ(лівий півзахисник)"),
	CENTRAL_FORWARD("ЦФ(центральний форвард)"),
	RIGHT_FORWARD("ПФ(правий форвард)"),
	LEFT_FORWARD("ЛФ(лівий форвард)");
	  String val;
	  private  Position (String val) {
	        this.val = val;
	    }
	public String getVal() {
		return val;
	}

}

