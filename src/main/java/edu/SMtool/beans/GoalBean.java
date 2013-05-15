package edu.SMtool.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext; 
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.SMtool.entity.Goal;
import edu.SMtool.interfaces.GoalService;

@Component
public class GoalBean implements Serializable {

	private static final long serialVersionUID = -6034384386402355374L;
	private List<Goal> goalList;
	private Goal goal = new Goal();
	
	@Autowired
	private GoalService goalService;
	
	@PostConstruct
	public void init(){
		System.out.println("in init");
		goalList = goalService.getAllGoals();
	}
	
	public void addGoal(){
		goalService.addGoal(this.goal);
	}
	
	public void onEdit(RowEditEvent event){
		Goal newValue = (Goal) event.getObject();
		goalService.editGoal(newValue);
        FacesMessage msg = new FacesMessage("Goal edited",((Goal) event.getObject()).getDescription());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
  
	}
	
	public void onCancel(RowEditEvent event) {  
	    FacesMessage msg = new FacesMessage("Goal edit Cancelled",((Goal) event.getObject()).getDescription());  
	    FacesContext.getCurrentInstance().addMessage(null, msg);  
	} 
	
	public void addNewGoal(){
		Goal newGoal = new Goal();
		goalService.addGoal(newGoal);
		goalList.add(newGoal);
	}
	
	public void removeGoal(Goal goal){
		goalService.deleteGoal(goal);
		goalList.remove(goal);
	}
	
	public String redirectToList(){
		return "#{request.contextPath}/views/goals/goalHome.xhtml?facesRedirect=true";
	}
	
	public Goal getGoal() {
		return goal;
	}
	
	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	public List<Goal> getGoalList(){
		return goalList;
	}
	
	public void setGoalList(List<Goal> goalList){
		this.goalList = goalList;
	}

}
