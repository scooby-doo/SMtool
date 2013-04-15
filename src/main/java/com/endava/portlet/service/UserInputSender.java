package com.endava.portlet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.endava.portlet.entity.UserInput;

/**
 * The UserInputSender.java.
 *
 * @author tmoldovan
 *
 */
@Component(value="inputSender")
public class UserInputSender {
	@Autowired
	@Qualifier("jmsTemplate")
	private JmsTemplate jmsTemplate;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	//@Override
	@Transactional
	public void sendInput(UserInput userInput){
		//System.out.println("sending jms input");
		jmsTemplate.convertAndSend(userInput);
		//System.out.println("sent...");
	}
}