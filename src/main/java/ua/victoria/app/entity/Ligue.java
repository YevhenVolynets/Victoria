package ua.victoria.app.entity;

public enum Ligue {
	First(1),
	Second(2);
	  int val;
	  private  Ligue (int val) {
	        this.val = val;
	    }
	public int getVal() {
		return val;
	}
}
