package edu.SMtool.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.SMtool.entity.Responsible;
import edu.SMtool.interfaces.ResponsibleService;

@Component
public class ResponsibleBean implements Serializable {

	private static final long serialVersionUID = 2125990878246573743L;
	private List<Responsible> responsibleList;
	
	@Autowired
	ResponsibleService responsibleService;
	
	@PostConstruct
	public void init(){
		responsibleList = responsibleService.getAllResponsibles();
	}
	
	public void onEdit(RowEditEvent event){
		Responsible newValue = (Responsible) event.getObject();
		responsibleService.editResponsible(newValue);
	}
	
	public void addNewResponsible(){
		Responsible newResp = new Responsible();
		responsibleService.addResponsible(newResp);
		responsibleList.add(newResp);
	}
	
	public void removeResponsible(Responsible responsible){
		responsibleService.deleteResponsible(responsible);
		responsibleList.remove(responsible);
	}

	public List<Responsible> getResponsibleList() {
		return responsibleList;
	}

	public void setResponsibleList(List<Responsible> responsibleList) {
		this.responsibleList = responsibleList;
	}
	
	
}
