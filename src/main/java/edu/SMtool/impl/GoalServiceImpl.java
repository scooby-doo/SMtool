package edu.SMtool.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.SMtool.entity.Goal;
import edu.SMtool.interfaces.GoalService;

public class GoalServiceImpl implements GoalService {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void addGoal() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteGoal() {
		// TODO Auto-generated method stub

	}

	@Override
	public void editGoal(Goal goal) {
		// TODO Auto-generated method stub

	}

	@Override
	public Goal getGoalById(int idGoal) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Goal> getAllGoals() {
		System.out.println("sessionFactory is");
		System.out.println(sessionFactory);
		List<Goal> listGoals = sessionFactory.getCurrentSession().createQuery("from Goal").list();
		for(Goal goals : listGoals) {
			System.out.println(goals.getDescription());
		}
		return listGoals;
	}
	
	/*public static void main(String[] args){
		GoalServiceImpl goalService = new GoalServiceImpl();
		goalService.getAllGoals();
	}*/

}
