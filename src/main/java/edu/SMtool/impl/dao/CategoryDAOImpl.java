package edu.SMtool.impl.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.SMtool.entity.Category;
import edu.SMtool.interfaces.dao.CategoryDAO;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	private static final long serialVersionUID = 1725742799522713626L;
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addCategory(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
	}

	@Override
	@Transactional
	public void deleteCategory(Category category) {
		sessionFactory.getCurrentSession().delete(category);
	}

	@Override
	@Transactional
	public void editCategory(Category category) {
		sessionFactory.getCurrentSession().update(category);
	}

	@Override
	@Transactional
	public Category getCategoryById(int idCategory) {
		Category category = (Category) sessionFactory.getCurrentSession().get(Category.class, idCategory);
		return category;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Category> getAllCategories() {
		List<Category> categoryList = sessionFactory.getCurrentSession().createQuery("from Category").list();
		return categoryList;
	}

}
