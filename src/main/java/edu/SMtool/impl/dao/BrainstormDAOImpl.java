package edu.SMtool.impl.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.SMtool.entity.Brainstorm;
import edu.SMtool.interfaces.dao.BrainstormDAO;

@Repository
public class BrainstormDAOImpl implements BrainstormDAO {

	private static final long serialVersionUID = 4653448270923845319L;
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addBrainstorm(Brainstorm brainstorm) {
		sessionFactory.getCurrentSession().saveOrUpdate(brainstorm);

	}

	@Override
	@Transactional
	public void deleteBrainstorm(Brainstorm brainstorm) {
		sessionFactory.getCurrentSession().delete(brainstorm);

	}

	@Override
	@Transactional
	public void editBrainstorm(Brainstorm brainstorm) {
		sessionFactory.getCurrentSession().update(brainstorm);

	}

	@Override
	public Brainstorm getBrainstormById(int idBrainstorm) {
		Brainstorm brainstorm = (Brainstorm) sessionFactory.getCurrentSession().get(Brainstorm.class, idBrainstorm);
		return brainstorm;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Brainstorm> getAllBrainstorms() {
		List<Brainstorm> brainstormList = sessionFactory.getCurrentSession().createQuery("from Brainstorm").list();
		return brainstormList;
	}

}
