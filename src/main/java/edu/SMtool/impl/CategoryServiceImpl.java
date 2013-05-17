package edu.SMtool.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.SMtool.entity.Category;
import edu.SMtool.interfaces.CategoryService;
import edu.SMtool.interfaces.dao.CategoryDAO;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	private static final long serialVersionUID = -2929723879934010173L;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Override
	@Transactional
	public Category getDefaultCategory(){
		return categoryDAO.getDefaultCategory();
	}

	@Override
	public void addCategory(Category category) {
		categoryDAO.addCategory(category);
	}

	@Override
	public void deleteCategory(Category category) {
		categoryDAO.deleteCategory(category);
	}

	@Override
	public void editCategory(Category category) {
		categoryDAO.editCategory(category);

	}

	@Override
	public Category getCategoryById(int idCategory) {
		return categoryDAO.getCategoryById(idCategory);
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryDAO.getAllCategories();
	}

}
