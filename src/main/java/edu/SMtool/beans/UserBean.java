package edu.SMtool.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.SMtool.entity.User;
import edu.SMtool.interfaces.UserService;

@Component
public class UserBean implements Serializable {

	private static final long serialVersionUID = 6037630908378830296L;
	private List<User> userList;
	
	@Autowired
	UserService userService;
	
	@PostConstruct
	public void init(){
		userList = userService.getAllUsers();
	}
	
	public void onEdit(RowEditEvent event){
		User newUser = (User) event.getObject();
		userService.editUser(newUser);
	}
	
	public void addNewUser(){
		User newUser = new User();
		userService.addUser(newUser);
		userList.add(newUser);
	}
	
	public void removeUser(User user){
		userService.deleteUser(user);
		userList.remove(user);
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
