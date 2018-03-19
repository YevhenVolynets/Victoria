package ua.victoria.app.entity.enumerated;

public enum Gender {
	
	MAN("Чоловік"),WONAN("Жінка");
	private String val;

	private Gender(String val) {
		this.val = val;
	}

	public String getVal() {
		return val;
	}
	
	

}
