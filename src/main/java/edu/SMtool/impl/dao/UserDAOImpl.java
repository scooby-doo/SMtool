package edu.SMtool.impl.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.SMtool.entity.User;
import edu.SMtool.interfaces.dao.UserDAO;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final long serialVersionUID = -6068803922224973575L;
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	@Override
	@Transactional
	public void editUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	@Transactional
	public User getUserById(int idUser) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, idUser);
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> getAllUsers() {
		List<User> userList = sessionFactory.getCurrentSession().createQuery("from User").list();
		return userList;
	}

}
