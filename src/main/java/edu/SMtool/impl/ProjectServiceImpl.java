package edu.SMtool.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.SMtool.entity.Project;
import edu.SMtool.interfaces.ProjectService;
import edu.SMtool.interfaces.dao.ProjectDAO;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	private static final long serialVersionUID = -841927985127782100L;
	
	@Autowired
	ProjectDAO projectDAO;
	
	@Override
	public void addProject(Project project) {
		projectDAO.addProject(project);
	}

	@Override
	public void deleteProject(Project project) {
		projectDAO.deleteProject(project);
	}

	@Override
	public void editProject(Project project) {
		projectDAO.editProject(project);
	}

	@Override
	public Project getProjectById(int idProject) {
		return projectDAO.getProjectById(idProject);
	}

	@Override
	public List<Project> getAllProjects() {
		return projectDAO.getAllProjects();
	}

}
