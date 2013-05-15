package edu.SMtool.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.SMtool.entity.Assignment;
import edu.SMtool.interfaces.AssignmentService;
import edu.SMtool.interfaces.dao.AssignmentDAO;

@Service("assignmentService")
public class AssignmentServiceImpl implements AssignmentService {

	private static final long serialVersionUID = -127904028712556207L;
	
	@Autowired
	AssignmentDAO assignmentDAO;

	@Override
	public void addAssignment(Assignment assignment) {
		assignmentDAO.addAssignment(assignment);
	}

	@Override
	public Assignment getAssignmentsById(int idAssignment) {
		return assignmentDAO.getAssignmentById(idAssignment);
	}

	@Override
	public List<Assignment> getAllAssignments() {
		return assignmentDAO.getAllAssignments();
	}

	@Override
	public void deleteAssignment(Assignment assignment) {
		assignmentDAO.deleteAssignment(assignment);

	}

	@Override
	public void edit(Assignment assignment) {
		assignmentDAO.editAssignment(assignment);

	}

}
