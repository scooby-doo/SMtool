package edu.SMtool.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.SMtool.entity.Event;
import edu.SMtool.interfaces.EventService;

@Component
public class EventBean implements Serializable {

	private static final long serialVersionUID = 978679372469029004L;
	private List<Event> eventList;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private ServiceUtils serviceUtils;
	
	@PostConstruct
	public void init(){
		eventList = eventService.getAllEvents();
	}
	
	public void onEdit(RowEditEvent event){
		Event newValue = (Event) event.getObject();
		eventService.editEvent(newValue);
	}
	
	public void addNewEvent(){
		Event newEvent = new Event();
		newEvent.setIdCampaign(serviceUtils.getDefaultCampaign());
		eventService.addEvent(newEvent);
		eventList.add(newEvent);
	}
	
	public void removeEvent(Event event){
		eventService.deleteEvent(event);
		eventList.remove(event);
	}

	public List<Event> getEventList() {
		return eventList;
	}

	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}

}
