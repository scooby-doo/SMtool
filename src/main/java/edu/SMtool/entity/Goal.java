package edu.SMtool.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Goal")
public class Goal implements Serializable {

	private static final long serialVersionUID = 6037462445359369801L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idGoal")
	private int id;
	
	@Column(name = "description")
	private String description;
	
	@Column( name = "status")
	private String status;
	
	@Column(name = "coments")
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
