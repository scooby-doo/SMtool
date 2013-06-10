package edu.SMtool.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "Task")
public class Task implements Serializable {

	private static final long serialVersionUID = -5841898209655834784L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTask")
	private int id;
	
	@Column(name = "nname")	
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "startDate")
	private Date startDate;
	
	@Column(name = "dl")
	private Date deadLine;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idProject")
	private Project idProject;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idResponsible")
	private Responsible idResp;	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}
	public Project getIdProject() {
		return idProject;
	}
	public void setIdProject(Project idProject) {
		this.idProject = idProject;
	}
	
	
	public Responsible getIdResp() {
		return idResp;
	}
	public void setIdResp(Responsible idResp) {
		this.idResp = idResp;
	}	
}
