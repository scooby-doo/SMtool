package edu.SMtool.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.SMtool.entity.Task;
import edu.SMtool.interfaces.TaskService;

@Component
public class TaskBean implements Serializable {

	private static final long serialVersionUID = -1863773854048606227L;
	private List<Task> taskList;
	
	@Autowired
	TaskService taskService;
	
	@PostConstruct
	public void init(){
		taskList = taskService.getAllTasks();
	}
	
	public void onEdit(RowEditEvent event){
		Task newValue = (Task) event.getObject();
		taskService.editTask(newValue);
	}
	
	public void addNewTask(){
		Task newValue = new Task();
		taskService.addTask(newValue);
		taskList.add(newValue);
	}
	
	public void removeTask(Task task){
		taskService.deleteTask(task);
		taskList.remove(task);
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

}
