package edu.SMtool.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.SMtool.entity.Task;
import edu.SMtool.interfaces.TaskService;
import edu.SMtool.interfaces.dao.TaskDAO;

@Service("taskService")
public class TaskServiceImpl implements TaskService {

	private static final long serialVersionUID = -5246849046905030117L;
	
	@Autowired
	TaskDAO taskDAO;

	@Override
	public void addTask(Task task) {
		taskDAO.addTask(task);
	}

	@Override
	public void deleteTask(Task task) {
		taskDAO.deleteTask(task);
	}

	@Override
	public void editTask(Task task) {
		taskDAO.editTask(task);
	}

	@Override
	public Task getTaskById(int idTask) {
		return taskDAO.getTaskById(idTask);
	}

	@Override
	public List<Task> getAllTasks() {
		return taskDAO.getAllTasks();
	}

}
