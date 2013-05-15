package edu.SMtool.impl.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.SMtool.entity.Responsible;
import edu.SMtool.interfaces.dao.ResponsibleDAO;

@Repository
public class ResponsibleDAOImpl implements ResponsibleDAO {

	private static final long serialVersionUID = -885567407485009122L;
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addResponsible(Responsible responsible) {
		sessionFactory.getCurrentSession().saveOrUpdate(responsible);
	}

	@Override
	@Transactional
	public void deleteResponsible(Responsible responsible) {
		sessionFactory.getCurrentSession().delete(responsible);
	}

	@Override
	@Transactional
	public void editResponsible(Responsible responsible) {
		sessionFactory.getCurrentSession().update(responsible);
	}

	@Override
	@Transactional
	public Responsible getResponsibleById(int idResponsible) {
		Responsible responsible = (Responsible) sessionFactory.getCurrentSession().get(Responsible.class, idResponsible);
		return responsible;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Responsible> getAllResponsibles() {
		List<Responsible> responsibleList = sessionFactory.getCurrentSession().createQuery("from Responsible").list();
		return responsibleList;
	}

}
