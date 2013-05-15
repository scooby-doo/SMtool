package edu.SMtool.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Brainstorm")
public class Brainstorm implements Serializable {

	private static final long serialVersionUID = -2768489942798635923L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idBrainstorm")
	private int id;

	@Column(name="description")
	private String description;
	
	@Column(name="coments")
	private String comments;
	
	@Column(name="ddate")
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
