package edu.SMtool.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.SMtool.entity.Brainstorm;
import edu.SMtool.interfaces.BrainstormService;

@Component
public class BrainstormBean implements Serializable {

	private static final long serialVersionUID = 9215979042645330102L;
	private List<Brainstorm> brainstormList;
	private Brainstorm brainstorm = new Brainstorm();

	@Autowired
	private BrainstormService brainstormService;

	@PostConstruct
	public void init() {
		brainstormList = brainstormService.getAllBrainstorms();
	}

	public void onEdit(RowEditEvent event) {
		Brainstorm newValue = (Brainstorm) event.getObject();
		brainstormService.editBrainstorm(newValue);
		FacesMessage msg = new FacesMessage("Brainstorm edited",
				((Brainstorm) event.getObject()).getDescription());
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Brainstorm edit canceled",
				((Brainstorm) event.getObject()).getDescription());
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public void addNewBrainstorm() {
		Brainstorm newBrainstorm = new Brainstorm();
		brainstormService.addBrainstorm(newBrainstorm);
		brainstormList.add(newBrainstorm);
	}

	public void removeBrainstorm(Brainstorm brainstorm) {
		brainstormService.deleteBrainstorm(brainstorm);
		brainstormList.remove(brainstorm);
	}

	public List<Brainstorm> getBrainstormList() {
		return brainstormList;
	}

	public void setBrainstormList(List<Brainstorm> brainstormList) {
		this.brainstormList = brainstormList;
	}

	public Brainstorm getBrainstorm() {
		return brainstorm;
	}

	public void setBrainstorm(Brainstorm brainstorm) {
		this.brainstorm = brainstorm;
	}

}
