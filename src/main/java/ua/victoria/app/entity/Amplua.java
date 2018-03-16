package ua.victoria.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "amplua")
public class Amplua extends BaseEntity{

	@Column(name = "amplua")
	@Enumerated(EnumType.STRING)
	private Position amplua;

	public Amplua() {
		
	}

	public Amplua(Position amplua) {
		this.amplua = amplua;
	}

	public Position getAmplua() {
		return amplua;
	}

	public void setAmplua(Position amplua) {
		this.amplua = amplua;
	}

	@Override
	public String toString() {
		return "Amplua [amplua=" + amplua + "]";
	}
	
	
}
