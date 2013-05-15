package edu.SMtool.interfaces.dao;

import java.io.Serializable;
import java.util.List;

import edu.SMtool.entity.Event;

public interface EventDAO extends Serializable {
	public void addEvent(Event event);
	public void deleteEvent(Event event);
	public void editEvent(Event event);
	public Event getEventById(int idEvent);
	public List<Event> getAllEvents();
}
