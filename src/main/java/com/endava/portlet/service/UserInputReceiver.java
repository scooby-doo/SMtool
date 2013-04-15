package com.endava.portlet.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.endava.portlet.entity.UserInput;

/**
 * The UserInputReceiver.java.
 *
 * @author tmoldovan
 *
 */
@Component(value="inputReceiver")
public class UserInputReceiver implements MessageListener {
	@Autowired
	@Qualifier("input")
	private UserInput userInput;

	@Autowired
	@Qualifier("jmsTemplate")
	private JmsTemplate jmsTemplate;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	@Override
	@Transactional
	public void onMessage(Message message){
		System.out.println("Receiver....");
		ObjectMessage objectMessage = (ObjectMessage) message;
		try {
			this.userInput = (UserInput) objectMessage.getObject();
			System.out.println("input is"+userInput);
			//System.out.println(userInput.getFirstName());
		} catch(JMSException e) {
			e.printStackTrace();
		}
	}

	public UserInput getInput(){
		return this.userInput;
	}

}