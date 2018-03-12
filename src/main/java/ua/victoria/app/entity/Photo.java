package ua.victoria.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "photo")
public class Photo extends BaseEntity{

	@Column(name = "name_photo")
	private String namePhoto;
	
	@Column(name = "description")
	private String description;
	
	

	public Photo() {

	}
	
	

	public Photo(String namePhoto, String description) {
		this.namePhoto = namePhoto;
		this.description = description;
	}



	public String getNamePhoto() {
		return namePhoto;
	}

	public void setNamePhoto(String namePhoto) {
		this.namePhoto = namePhoto;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Photo [namePhoto=" + namePhoto + ", description=" + description + ", getId()=" + getId() + "]";
	}
	
	
	
}
