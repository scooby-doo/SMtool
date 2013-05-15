package edu.SMtool.impl.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.SMtool.entity.Assignment;
import edu.SMtool.interfaces.dao.AssignmentDAO;

@Repository
public class AssignmentDAOImpl implements AssignmentDAO {

	private static final long serialVersionUID = -30509167060948820L;
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addAssignment(Assignment assignment) {
		sessionFactory.getCurrentSession().saveOrUpdate(assignment);

	}

	@Override
	@Transactional
	public void deleteAssignment(Assignment assignment) {
		sessionFactory.getCurrentSession().delete(assignment);
	}

	@Override
	@Transactional
	public void editAssignment(Assignment assignment) {
		sessionFactory.getCurrentSession().update(assignment);

	}

	@Override
	@Transactional
	public Assignment getAssignmentById(int idAssignment) {
		Assignment assignment = (Assignment) sessionFactory.getCurrentSession().get(Assignment.class, idAssignment);
		return assignment;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Assignment> getAllAssignments() {
		List<Assignment> assignmentList = sessionFactory.getCurrentSession().createQuery("from Assignment").list();
		return assignmentList;
	}

}
