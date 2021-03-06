package edu.SMtool.impl.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.SMtool.entity.Task;
import edu.SMtool.interfaces.dao.TaskDAO;

@Repository
public class TaskDAOImpl implements TaskDAO {

	private static final long serialVersionUID = 1559035927361942798L;
		
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Task> getTaskByProjectId(int idProject){
		@SuppressWarnings("unchecked")
		List<Task> taskList = sessionFactory.getCurrentSession().createCriteria(Task.class)
				.add(Restrictions.eq("idProject.id",idProject)).list();
		if(taskList == null) { taskList = new ArrayList<Task>(); }
		return taskList;
	}
	
	@Override
	@Transactional
	public Task getDefaultTask(){
		return getTaskById(1);
	}

	@Override
	@Transactional
	public void addTask(Task task) {
		sessionFactory.getCurrentSession().saveOrUpdate(task);
	}

	@Override
	@Transactional
	public void deleteTask(Task task) {
		sessionFactory.getCurrentSession().delete(task);
	}

	@Override
	@Transactional
	public void editTask(Task task) {
		sessionFactory.getCurrentSession().update(task);
	}

	@Override
	@Transactional
	public Task getTaskById(int idTask) {
		Task task = (Task) sessionFactory.getCurrentSession().get(Task.class, idTask);
		return task;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Task> getAllTasks() {
		List<Task> taskList = sessionFactory.getCurrentSession().createQuery("from Task").list();
		return taskList;
	}

}
