package edu.SMtool.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Goals")
public class Goal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idGoal")
	private int id;
	
	@Column(name = "descritpion")
	private String description;
	
	@Column( name = "status")
	private String status;
	
	@Column(name = "comments")
	private String comments;
	

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
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	

}
