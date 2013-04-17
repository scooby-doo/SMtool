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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAssigment")
	private int idAssigment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name  = "idProject")
	private Project idProject;
	
	@OneToOne(fetch = FetchType.LAZY)
	@Column(name = "idTask")
	private Task idTask;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name = "idResp")
	private Responsible idResp;
	
	
	public int getIdAssigment() {
		return idAssigment;
	}
	public void setIdAssigment(int idAssigment) {
		this.idAssigment = idAssigment;
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
