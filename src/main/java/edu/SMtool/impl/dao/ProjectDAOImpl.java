package edu.SMtool.impl.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.SMtool.entity.Project;
import edu.SMtool.interfaces.dao.ProjectDAO;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	private static final long serialVersionUID = 1875345360609217543L;
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addProject(Project project) {
		sessionFactory.getCurrentSession().saveOrUpdate(project);
	}

	@Override
	@Transactional
	public void deleteProject(Project project) {
		sessionFactory.getCurrentSession().delete(project);
	}

	@Override
	@Transactional
	public void editProject(Project project) {
		sessionFactory.getCurrentSession().update(project);
	}

	@Override
	@Transactional
	public Project getProjectById(int idProject) {
		Project project = (Project) sessionFactory.getCurrentSession().get(Project.class, idProject);
		return project;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Project> getAllProjects() {
		List<Project> projectList = sessionFactory.getCurrentSession().createQuery("from Project").list();
		return projectList;
	}

}
