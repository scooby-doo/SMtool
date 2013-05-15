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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Assignments")
public class Assignment implements Serializable{

	private static final long serialVersionUID = 2333122921262464552L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAssignment")
	private int idAssignment;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name  = "idProject")
	private Project idProject;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idTask")
	private Task idTask;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idResp")
	private Responsible idResp;
	
	
	public int getIdAssignment() {
		return idAssignment;
	}
	public void setIdAssignment(int idAssigment) {
		this.idAssignment = idAssigment;
	}
	
	public Project getIdProject() {
		return idProject;
	}
	public void setIdProject(Project idProject) {
		this.idProject = idProject;
	}
	
	public Task getIdTask() {
		return idTask;
	}
	public void setIdTask(Task idTask) {
		this.idTask = idTask;
	}
	
	public Responsible getIdResp() {
		return idResp;
	}
	public void setIdResp(Responsible idResp) {
		this.idResp = idResp;
	}	

}
