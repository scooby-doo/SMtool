package edu.SMtool.interfaces.dao;

import java.io.Serializable;
import java.util.List;

import edu.SMtool.entity.Goal;

public interface GoalDAO extends Serializable{
	
	public void addGoal(Goal goal);
	public void deleteGoal(Goal goal);
	public void editGoal(Goal goal);
	public Goal getGoalById(int idGoal);
	public List<Goal> getAllGoals();

}
