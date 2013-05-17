package edu.SMtool.interfaces;

import java.io.Serializable;
import java.util.List;

import edu.SMtool.entity.Category;

public interface CategoryService extends Serializable {
	public void addCategory(Category category);
	public void deleteCategory(Category category);
	public void editCategory(Category category);
	public Category getCategoryById(int idCategory);
	public Category getDefaultCategory();
	public List<Category> getAllCategories();

}
