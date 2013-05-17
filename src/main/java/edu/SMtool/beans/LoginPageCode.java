package edu.SMtool.beans;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("session")
public class LoginPageCode implements Serializable {
	private static final long serialVersionUID = 448866362582597385L;
	
	 public String getFacebookUrlAuth() {
	        HttpSession session =
	        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	        String sessionId = session.getId();
	        String appId = "377737765678750";
	        String redirectUrl = "http://smtool.wow.md/views/socialNetwork/accountHome.jsf";
	        String returnValue = "https://www.facebook.com/dialog/oauth?client_id="
	                + appId + "&redirect_uri=" + redirectUrl
	                + "&scope=email,user_birthday&state=" + sessionId;
	        return returnValue;
	    }
	 
	    public String getUserFromSession() {
	        HttpSession session =
	        (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	        String userName = (String) session.getAttribute("FACEBOOK_USER");
	        if (userName != null) {
	        	System.out.println("heelo" + userName);
	            return "Hello " + userName;
	        }
	        else {
	        	System.out.println("no user");
	            return "";
	        }
	    }
	
	

}
