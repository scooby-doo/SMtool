package edu.SMtool.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Resource")
public class Resource implements Serializable {

	private static final long serialVersionUID = 2871467860308064732L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idResource")	
	private int id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "link")
	private String link;
	
	@Column(name = "coments")
	private String comments;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCategory")
	private Category idCategory;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	

	public Category getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Category idCategory) {
		this.idCategory = idCategory;
	}
	
	
	

}
