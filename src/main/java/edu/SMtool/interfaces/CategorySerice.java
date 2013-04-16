package edu.SMtool.interfaces;

import java.util.List;

import edu.SMtool.entity.Category;

public interface CategorySerice {
	public void addCategory();
	public void deleteCategory();
	public void editCategory(Category category);
	public Category getCategoryById(int idCategory);
	public List<Category> getAllCategory();

}
