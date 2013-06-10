package edu.SMtool.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.SMtool.entity.Campaign;
import edu.SMtool.entity.Goal;
import edu.SMtool.entity.Project;
import edu.SMtool.entity.Task;
import edu.SMtool.interfaces.CampaignService;
import edu.SMtool.interfaces.GoalService;
import edu.SMtool.interfaces.ProjectService;
import edu.SMtool.interfaces.TaskService;

@Component
public class ProjectBean implements Serializable {

	private static final long serialVersionUID = -1724743009095349712L;
	private List<Project> projectList;
	private Project project = new Project();
	List<Campaign> campaignList;
	List<Task> taskList;
	List<Goal> goalList;
	
	@Autowired
	private GoalService goalService;
	
	@Autowired
	private ServiceUtils serviceUtils;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired 
	private CampaignService campaignService;
	
	@Autowired
	private TaskService taskService;
	
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
	
	
	public String details(){
		System.out.println("in details project");
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		String id = params.get("idProject");
		int idInt = Integer.parseInt(id);
		
		project = projectService.getProjectById(idInt);
		setProject(project);
		
		campaignList = campaignService.getCampaignsByProjectId(idInt);
		setCampaignList(campaignList);
		
		taskList = taskService.getTaskByProjectId(idInt);
		setTaskList(taskList);
		
		goalList = goalService.getProjectGoalsById(idInt);
		setGoalList(goalList);
		
		return "projectDetailHome";
	}
	
	

	public List<Campaign> getCampaignList() {
		return campaignList;
	}

	public void setCampaignList(List<Campaign> campaignList) {
		this.campaignList = campaignList;
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

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	public List<Goal> getGoalList() {
		return goalList;
	}

	public void setGoalList(List<Goal> goalList) {
		this.goalList = goalList;
	}
	
}
