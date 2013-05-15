package edu.SMtool.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.SMtool.entity.Project;
import edu.SMtool.interfaces.ProjectService;

@Component
public class ProjectBean implements Serializable {

	private static final long serialVersionUID = -1724743009095349712L;
	private List<Project> projectList;
	private Project project = new Project();
	
	@Autowired
	private ProjectService projectService;
	
	@PostConstruct
	public void init(){
		projectList = projectService.getAllProjects();
	}
	
	public void addNewProject(){
		Project project = new Project();
		projectService.addProject(project);
		projectList.add(project);
	}
	
	public void removeProject(Project project){
		projectService.deleteProject(project);
		projectList.remove(project);
	}
	
	public void onEdit(RowEditEvent event){
		Project newValue = (Project) event.getObject();
		projectService.editProject(newValue);
        FacesMessage msg = new FacesMessage("Project edited",((Project) event.getObject()).getDescription());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
  
	}
	
	public void onCancel(RowEditEvent event) {  
	    FacesMessage msg = new FacesMessage("Project edit Cancelled",((Project) event.getObject()).getDescription());  
	    FacesContext.getCurrentInstance().addMessage(null, msg);  
	}
	
	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	
}
