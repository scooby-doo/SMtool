package edu.SMtool.interfaces;

import java.io.Serializable;
import java.util.List;

import edu.SMtool.entity.Assignment;


public interface AssignmentService extends Serializable {
	
	public void addAssignment(Assignment assignment);
	public Assignment getAssignmentsById(int id);
	public List<Assignment> getAllAssignments();
	public void deleteAssignment(Assignment assignment);
	public void edit(Assignment assignment);
	

}
