package edu.SMtool.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.SMtool.entity.Assignment;
import edu.SMtool.interfaces.AssignmentService;

@Component
public class AssignmentBean implements Serializable {

	private static final long serialVersionUID = -3120641286213614677L;
	private List<Assignment> assignmentList;
	
	@Autowired
	private AssignmentService assignmentService;
	
	@PostConstruct
	public void init(){
		assignmentList = assignmentService.getAllAssignments();
	}
	
	public void onEdit(RowEditEvent event){
		Assignment newAssignment = (Assignment) event.getObject();
		assignmentService.edit(newAssignment);  
	}
	
	public void addNewAssignment(){
		Assignment newAssignment = new Assignment();
		assignmentService.addAssignment(newAssignment);
		assignmentList.add(newAssignment);
	}
	
	public void removeAssignment(Assignment assignment){
		assignmentService.deleteAssignment(assignment);
		assignmentList.remove(assignment);
	}

	public List<Assignment> getAssignmentList() {
		return assignmentList;
	}

	public void setAssignmentList(List<Assignment> assignmentList) {
		this.assignmentList = assignmentList;
	}

}
