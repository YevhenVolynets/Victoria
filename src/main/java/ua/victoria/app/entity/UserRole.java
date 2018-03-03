package ua.victoria.app.entity;

public enum UserRole {
	
	Creator(1),
	Admin(2),
	User(3),
	Guest(4);
	  int val;
	  private  UserRole (int val) {
	        this.val = val;
	    }
	public int getVal() {
		return val;
	}
	  

}
