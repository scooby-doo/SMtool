package edu.SMtool.interfaces;

import java.util.List;

import edu.SMtool.entity.Task;

public interface TaskService {
	public void addTask();
	public void deleteTask();
	public void editTask(Task task);
	public Task getTaskById(int idTask);
	public List<Task> getAllTasks();

}
