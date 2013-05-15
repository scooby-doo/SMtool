package edu.SMtool.impl.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.SMtool.entity.Resource;
import edu.SMtool.interfaces.dao.ResourceDAO;

@Repository
public class ResourceDAOImpl implements ResourceDAO {

	private static final long serialVersionUID = -6177773516519098545L;
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addResource(Resource resource) {
		sessionFactory.getCurrentSession().saveOrUpdate(resource);
	}

	@Override
	@Transactional
	public void deleteResource(Resource resource) {
		sessionFactory.getCurrentSession().delete(resource);
	}

	@Override
	@Transactional
	public void editResource(Resource resource) {
		sessionFactory.getCurrentSession().update(resource);
	}

	@Override
	@Transactional
	public Resource getResourceById(int idResource) {
		Resource resource = (Resource) sessionFactory.getCurrentSession().get(Resource.class, idResource);
		return resource;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Resource> getAllResources() {
		List<Resource> resourceList = sessionFactory.getCurrentSession().createQuery("from Resource").list();
		return resourceList;
	}

}
