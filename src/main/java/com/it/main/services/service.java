package com.it.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.it.main.Repo.ItRepository;
import com.it.main.entities.Category;

@Service
public class service  {
	 
	@Autowired
	private ItRepository itRepository;
	
	public Category addcategory(Category category) {
	  
		if(category.getParent()!=null)
		{
		  Category name = this.itRepository.findByName(category.getParent().getName());
		  category.setParent(name);
		  return this.itRepository.save(category);
		}
	
		  Category save = this.itRepository.save(category);
		return save;
	}
    
	//get all category and its sub category
  public List<Category> getAllCategory()
  {
	  List<Category> all = this.itRepository.findAll();
	  
	  for (Category category : all) {
		System.out.println(category);
	}
	  return all;
  }
  
  //update category
  public Category updateCategory(Category category,String name) {
	  

	    Category findByName = this.itRepository.findByName(name);
	    findByName.setName(category.getName());
	         
	    Category parent = this.itRepository.findByName(category.getParent().getName());
	   findByName.setParent(parent);
	       Category save = itRepository.save(findByName);
	  return save;
  }
  
  //delete
  
    public Category deleteCategory(int id) {
    	  this.itRepository.deleteById(id);
	      return null;
  }

    public Category getByName(String name) {
    	Category findByName = this.itRepository.findByName(name);
    	return findByName;
    }

  
  
	
}
