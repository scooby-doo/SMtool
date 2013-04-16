package edu.SMtool.interfaces;

import java.util.List;

import edu.SMtool.entity.Event;


public interface EventService {
	public void addEvent();
	public void deleteEvent();
	public void editEvent(Event event);
	public Event getEventById(int idEvent);
	public List<Event> getAllEvents();
}
