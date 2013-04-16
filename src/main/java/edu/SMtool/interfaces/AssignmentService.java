package edu.SMtool.interfaces;

import java.util.List;

import edu.SMtool.entity.Assignment;


public interface AssignmentService {
	
	public void addAssignment();
	public Assignment getAssignmentsById(int id);
	public List<Assignment> getAllAssignments();
	public void deleteAssignment(int id);
	public void edit(Assignment assignment);
	

}
