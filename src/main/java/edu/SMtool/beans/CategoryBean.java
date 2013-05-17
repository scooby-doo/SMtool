package edu.SMtool.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.SMtool.entity.Category;
import edu.SMtool.interfaces.CategoryService;

@Component
public class CategoryBean implements Serializable {

	private static final long serialVersionUID = -2461784312184123384L;
	private List<Category> categoryList;
	
	@Autowired
	private CategoryService categoryService;
	
	@PostConstruct
	public void init(){
		categoryList = categoryService.getAllCategories();
	}
	
	public void onEdit(RowEditEvent event){
		Category newValue = (Category) event.getObject();
		categoryService.editCategory(newValue);
	}
	
	public void addNewCategory(){
		Category newCategory = new Category();
		categoryService.addCategory(newCategory);
		categoryList.add(newCategory);
	}
	
	public void removeCategory(Category category){
		categoryService.deleteCategory(category);
		categoryList.remove(category);
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	
	

}
