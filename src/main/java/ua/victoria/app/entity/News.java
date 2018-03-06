package ua.victoria.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "news")
public class News extends BaseEntity{

	@Column(name = "title")
	public String title;
	
	@Column(name = "contents",columnDefinition = "TEXT")
	public String contents;
	
	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="path_to_foto")
	private String pathToFoto;

	public News() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getPathToFoto() {
		return pathToFoto;
	}

	public void setPathToFoto(String pathToFoto) {
		this.pathToFoto = pathToFoto;
	}
	
	
	
}
