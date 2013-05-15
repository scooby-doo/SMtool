package edu.SMtool.impl.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import edu.SMtool.entity.Goal;
import edu.SMtool.interfaces.dao.GoalDAO;

@Repository
public class GoalDAOImpl implements GoalDAO {

	private static final long serialVersionUID = -3167786966872449200L;
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addGoal(Goal goal) {
		sessionFactory.getCurrentSession().saveOrUpdate(goal);
	}
	
	@Override
	@Transactional
	public void deleteGoal(Goal goal) {
		sessionFactory.getCurrentSession().delete(goal);
	}

	@Override
	@Transactional
	public void editGoal(Goal goal) {
		sessionFactory.getCurrentSession().update(goal);
	}

	@Override
	public Goal getGoalById(int idGoal) {
		Goal goal = (Goal) sessionFactory.getCurrentSession().get(Goal.class, idGoal);
		return goal;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Goal> getAllGoals() {
		List<Goal> listGoals = sessionFactory.getCurrentSession().createQuery("from Goal").list();
		if (listGoals.isEmpty()) System.out.println("list empty");
		else System.out.println("list full");
		return listGoals;
	}

}
