package edu.SMtool.interfaces.dao;

import java.io.Serializable;
import java.util.List;

import edu.SMtool.entity.Project;

public interface ProjectDAO extends Serializable {
	public void addProject(Project project);
	public void deleteProject(Project project);
	public void editProject(Project project);
	public Project getProjectById(int idProject);
	public Project getDefaultProject();
	public List<Project> getAllProjects();

}
