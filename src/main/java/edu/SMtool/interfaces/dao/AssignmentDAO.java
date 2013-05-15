package edu.SMtool.interfaces.dao;

import java.io.Serializable;
import java.util.List;

import edu.SMtool.entity.Assignment;

public interface AssignmentDAO extends Serializable {
	public void addAssignment(Assignment assignment);
	public void deleteAssignment(Assignment assignment);
	public void editAssignment(Assignment assignment);
	public Assignment getAssignmentById(int idAssignment);
	public List<Assignment> getAllAssignments();

}
