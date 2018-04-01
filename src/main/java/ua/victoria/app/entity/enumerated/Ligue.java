package ua.victoria.app.entity.enumerated;

public enum Ligue {
	First("Вища"),
	Second("Перша");
	  String val;
	  private  Ligue (String val) {
	        this.val = val;
	    }
	public String getVal() {
		return val;
	}
}
