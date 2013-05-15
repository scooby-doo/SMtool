package edu.SMtool.impl.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.SMtool.entity.Event;
import edu.SMtool.interfaces.dao.EventDAO;

@Repository
public class EventDAOImpl implements EventDAO {

	private static final long serialVersionUID = -6669096739307757920L;
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addEvent(Event event) {
		sessionFactory.getCurrentSession().saveOrUpdate(event);
	}

	@Override
	@Transactional
	public void deleteEvent(Event event) {
		sessionFactory.getCurrentSession().delete(event);
	}

	@Override
	@Transactional
	public void editEvent(Event event) {
		sessionFactory.getCurrentSession().delete(event);
	}

	@Override
	@Transactional
	public Event getEventById(int idEvent) {
		Event event = (Event) sessionFactory.getCurrentSession().get(Event.class, idEvent);
		return event;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Event> getAllEvents() {
		List<Event> eventList = sessionFactory.getCurrentSession().createQuery("from Event").list();
		return eventList;
	}

}
