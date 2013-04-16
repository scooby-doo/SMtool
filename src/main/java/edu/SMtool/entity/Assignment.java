package edu.SMtool.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "Assigments")
public class Assignment {
	
	private int idAssigment;
	private Project idProject;
	private Task idTask;
	private Responsible idResp;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAssigment")
	public int getIdAssigment() {
		return idAssigment;
	}
	public void setIdAssigment(int idAssigment) {
		this.idAssigment = idAssigment;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name  = "idProject")
	public Project getIdProject() {
		return idProject;
	}
	public void setIdProject(Project idProject) {
		this.idProject = idProject;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@Column(name = "idTask")
	public Task getIdTask() {
		return idTask;
	}
	public void setIdTask(Task idTask) {
		this.idTask = idTask;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name = "idResp")
	public Responsible getIdResp() {
		return idResp;
	}
	public void setIdResp(Responsible idResp) {
		this.idResp = idResp;
	}
	
	
	
	

}
