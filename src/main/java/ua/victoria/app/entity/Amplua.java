package ua.victoria.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "amplua")
public class Amplua extends BaseEntity{

	@Column(name = "amplua")
	private String amplua;

	public Amplua() {
		
	}

	public Amplua(String amplua) {
		this.amplua = amplua;
	}

	public String getAmplua() {
		return amplua;
	}

	public void setAmplua(String amplua) {
		this.amplua = amplua;
	}
	
	
}
