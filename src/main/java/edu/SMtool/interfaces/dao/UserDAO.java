package edu.SMtool.interfaces.dao;

import java.io.Serializable;
import java.util.List;

import edu.SMtool.entity.User;

public interface UserDAO extends Serializable {
	public void addUser(User user);
	public void deleteUser(User user);
	public void editUser(User user);
	public User getUserById(int idUser);
	public List<User> getAllUsers();

}
