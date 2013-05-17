package edu.SMtool.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.SMtool.entity.Campaign;
import edu.SMtool.entity.Category;
import edu.SMtool.entity.Project;
import edu.SMtool.entity.Responsible;
import edu.SMtool.entity.Task;
import edu.SMtool.interfaces.CampaignService;
import edu.SMtool.interfaces.CategoryService;
import edu.SMtool.interfaces.ProjectService;
import edu.SMtool.interfaces.ResponsibleService;
import edu.SMtool.interfaces.TaskService;


@Component
public class ServiceUtils {
	
	@Autowired
	private CampaignService campaignService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private ResponsibleService responsibleService;
	
	@Autowired
	private ProjectService projectService;
	
	
	
	public Campaign getDefaultCampaign(){
		return campaignService.getDefaultCampaign();
	}
	
	public Category getDefaultCategory(){
		return categoryService.getDefaultCategory();
	}
	
	public Task getDefaultTask(){
		return taskService.getDefaultTask();
	}
	
	public Responsible getDefaultResponsible(){
		return responsibleService.getDefaultResponsible();
	}
	
	public Project getDefaultProject(){
		return projectService.getDefaultProject();
	}
	

}
