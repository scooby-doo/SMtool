package edu.SMtool.interfaces;

import java.util.List;

import edu.SMtool.entity.Project;

public interface ProjectService {
	public void addProject();
	public void deleteProject();
	public void editProject(Project project);
	public Project getProjectById(int idProject);
	public List<Project> getAllProjects();

}
