package ua.victoria.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.victoria.app.entity.enumerated.Gender;

@Entity
@Table(name = "photo")
@Getter @Setter @NoArgsConstructor
public class Photo extends BaseEntity{

	@Column(name = "name_photo")
	private String namePhoto;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "tags")
	private String tags;

	@Override
	public String toString() {
		return "Photo [namePhoto=" + namePhoto + ", description=" + description + ", tags=" + tags + ", getId()="
				+ getId() + "]";
	}

	

	
	
	
}
