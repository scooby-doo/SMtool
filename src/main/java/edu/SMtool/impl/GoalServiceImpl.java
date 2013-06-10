package edu.SMtool.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.SMtool.entity.Goal;
import edu.SMtool.interfaces.GoalService;
import edu.SMtool.interfaces.dao.GoalDAO;

@Service("goalService")
public class GoalServiceImpl implements GoalService {

	private static final long serialVersionUID = -9100154238316194355L;
	
	@Autowired
	private GoalDAO goalDAO;
	
	@Override
	public List<Goal> getCampaignGoalsById(int idCampaing){
		return goalDAO.getCampaignGoalsById(idCampaing);
	}
	
	@Override
	public List<Goal> getProjectGoalsById(int idProject){
		return goalDAO.getProjectGoalsById(idProject);
	}
	
	@Override
	public void addGoal(Goal goal) {
		goalDAO.addGoal(goal);
	}

	@Override
	public void deleteGoal(Goal goal) {
		goalDAO.deleteGoal(goal);

	}

	@Override
	public void editGoal(Goal goal) {
		goalDAO.editGoal(goal);

	}

	@Override
	public Goal getGoalById(int idGoal) {
		return goalDAO.getGoalById(idGoal);
	}

	@Override
	public List<Goal> getAllGoals() {
		List<Goal> listGoals = goalDAO.getAllGoals();
		return listGoals;
	}

}
