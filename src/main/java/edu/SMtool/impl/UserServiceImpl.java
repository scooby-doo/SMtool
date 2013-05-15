package edu.SMtool.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.SMtool.entity.User;
import edu.SMtool.interfaces.UserService;
import edu.SMtool.interfaces.dao.UserDAO;

@Service("userService")
public class UserServiceImpl implements UserService {

	private static final long serialVersionUID = 2924842574729577809L;
	
	@Autowired
	UserDAO userDAO;

	@Override
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	@Override
	public void deleteUser(User user) {
		userDAO.deleteUser(user);
	}

	@Override
	public void editUser(User user) {
		userDAO.editUser(user);
	}

	@Override
	public User getUserById(int idUser) {
		return userDAO.getUserById(idUser);
	}

	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

}
