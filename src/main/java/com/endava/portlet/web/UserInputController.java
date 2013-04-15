package com.endava.portlet.web;

import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.validation.Valid;
import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.endava.portlet.entity.UserInput;
import com.endava.portlet.service.UserInputSender;


/**
 * The UserInputController.java.
 *
 * @author tmoldovan
 *
 */
@Controller(value="userInputController")
@RequestMapping("view")
public class UserInputController {

	@Autowired
	@Qualifier("inputSender")
	UserInputSender userSender;

	@RenderMapping
	public ModelAndView defaultFunc(){
		return new ModelAndView("collectInput","userInput",new UserInput());
	}

	@RenderMapping(params="myaction=showNewForm")
	public String showNewForm(RenderRequest request,ModelMap map){
		map.put("userInput", new UserInput());
		return "collectInput";
	}

	@RenderMapping(params="myaction=showForm")
	public String showForm(RenderRequest request, ModelMap map){
		UserInput userInput;
		if(map.containsAttribute("userInput")){
			userInput = (UserInput) map.get("userInput");
		} else {
			userInput = new UserInput();
		}
		map.put("userInput",userInput);
		return "collectInput";
	}

	@ActionMapping(params="myaction=addInput")
	public void addInput(@Valid @ModelAttribute(value="userInput") UserInput userInput, BindingResult result, ActionResponse response){
		if(result.hasErrors()) {
			response.setRenderParameter("myaction", "showForm");
		} else {
			System.out.println("noo errors");
			userSender.sendInput(userInput);

			QName eventName = new QName("addedInputEvent");
			response.setEvent(eventName, new UserInput(userInput));

			response.setRenderParameter("myaction", "showNewForm");
		}
	}
}