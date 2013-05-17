package edu.SMtool.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.TabCloseEvent;
import org.springframework.stereotype.Component;

@Component
public class TabBean {
	 public void onTabClose(TabCloseEvent event) {  
	        FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());	  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
	    }  

}
