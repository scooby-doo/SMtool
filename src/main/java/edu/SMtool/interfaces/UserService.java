package edu.SMtool.interfaces;

import java.util.List;

import edu.SMtool.entity.User;

public interface UserService {
	public void addUser();
	public void deleteUser();
	public void editUser(User user);
	public User getUserById(int idUser);
	public List<User> getAllUsers();

}
