package com.endava.portlet.web;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.EventMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.endava.portlet.entity.UserInput;


/**
 * The ShowInputController.java.
 *
 * @author tmoldovan
 *
 */
@Controller(value="showInputController")
@RequestMapping("view")
public class ShowInputController {

	@RenderMapping
	public String showMyInput(){
		return "welcome";
	}

	@RenderMapping(params="myaction=success")
	public String showInput(ModelMap model){
		System.out.println("in showInput");
		UserInput userInput = new UserInput();
		if(model.containsAttribute("userInput")){
			System.out.println("in if");
			userInput.setFirstName((String) model.get("firstName"));
			userInput.setLastName((String) model.get("lastName"));
			userInput.setUserName((String) model.get("userName"));
			userInput.setEmail((String) model.get("email"));
			userInput.setPassword((String) model.get("password"));
			userInput.setAge(Integer.parseInt((String) model.get("firstName")));
		} 
		model.put("userInput", userInput);
		return "collectedInput";
	}

	@EventMapping("addedInputEvent")
	//@ProcessEvent(qname="addedInputEvent")
	public void proccessAddedEvent(EventRequest request, EventResponse response) {
		System.out.println("in receiving portlet");
		Event event = request.getEvent();
		UserInput userInput = (UserInput) event.getValue();
		response.setRenderParameter("firstName", userInput.getFirstName());
		response.setRenderParameter("lastName", userInput.getLastName());
		response.setRenderParameter("userName", userInput.getUserName());
		response.setRenderParameter("age", userInput.getAge().toString());
		response.setRenderParameter("email", userInput.getEmail());
		response.setRenderParameter("password", userInput.getPassword());
		response.setRenderParameter("myaction","success");
		////ModelMap model = new ModelMap();
		//model.put("userInput",addedInput);
		//return "collectedInput";
	}
}