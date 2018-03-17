package ua.victoria.app.entity;

public enum Position {
	
	Golkepeer("Голкіпер"),
	Zaxysnyk("Захисник"),
	Pivzaxysnyk("Півзахисник"),
	Napadaychyi("Нападаючий");
	  String val;
	  private  Position (String val) {
	        this.val = val;
	    }
	public String getVal() {
		return val;
	}

}

/*Golkepeer(1),
Zaxysnyk(2),
Pivzaxysnyk(3),
Napadaychyi(4);
  int val;
  private  Position (int val) {
        this.val = val;
    }
public int getVal() {
	return val;
}*/