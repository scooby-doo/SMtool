package edu.SMtool.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.SMtool.entity.Event;
import edu.SMtool.interfaces.EventService;
import edu.SMtool.interfaces.dao.EventDAO;

@Service("eventService")
public class EventServiceImpl implements EventService {

	private static final long serialVersionUID = 4493606534679326940L;
	
	@Autowired
	EventDAO eventDAO;
	
	@Override
	public List<Event> getEventByCampaignId(int idCampaign){
		return eventDAO.getEventByCampaignId(idCampaign);
	}

	@Override
	public void addEvent(Event event) {
		eventDAO.addEvent(event);
	}

	@Override
	public void deleteEvent(Event event) {
		eventDAO.deleteEvent(event);
	}

	@Override
	public void editEvent(Event event) {
		eventDAO.editEvent(event);
	}

	@Override
	public Event getEventById(int idEvent) {
		return eventDAO.getEventById(idEvent);
	}

	@Override
	public List<Event> getAllEvents() {
		return eventDAO.getAllEvents();
	}

}
