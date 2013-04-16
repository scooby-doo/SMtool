package edu.SMtool.interfaces;

import java.util.List;

import edu.SMtool.entity.Goal;

public interface GoalService {
	public void addGoal();
	public void deleteGoal();
	public void editGoal(Goal goal);
	public Goal getGoalById(int idGoal);
	public List<Goal> getAllGoals();

}
