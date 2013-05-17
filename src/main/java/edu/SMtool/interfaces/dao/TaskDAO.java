package edu.SMtool.interfaces.dao;

import java.io.Serializable;
import java.util.List;

import edu.SMtool.entity.Task;

public interface TaskDAO extends Serializable {
	public void addTask(Task task);
	public void deleteTask(Task task);
	public void editTask(Task task);
	public Task getTaskById(int idTask);
	public Task getDefaultTask();
	public List<Task> getAllTasks();

}
