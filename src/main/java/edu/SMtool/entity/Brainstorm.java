package edu.SMtool.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="Brainstorm")
public class Brainstorm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idAssigment")
	private int id;

	@Column(name="description")
	private String description;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="status")
	private String status;
	

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
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
