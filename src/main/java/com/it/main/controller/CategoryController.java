package com.it.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.it.main.entities.Category;
import com.it.main.services.service;


@RestController

public class CategoryController {
 
	@Autowired
	private service Cservice;
	
	@PostMapping("/")
	public ResponseEntity<Category> addcatgory(@RequestBody Category category){
		
		
		Category addcategory = Cservice.addcategory(category);
		
		System.out.println(addcategory);
	
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	//For All category
	
	@GetMapping("/")
	public List<Category> getAll()
	{
		List<Category> allCategory = this.Cservice.getAllCategory();
		return allCategory;
	}
	//update Category
	
	@PutMapping("/{name}")
	public Category updateCategory(@RequestBody Category category,@PathVariable String name) {
	
		 Category updateCategory =Cservice.updateCategory(category,name);
		 return updateCategory;
	
	}
    @DeleteMapping("/{name}")
	public Category deletedCategory(@PathVariable String name) {
		
		this.Cservice.deleteCategory(name);
		return null;
	}
	
//	@DeleteMapping("/{id}")
//	  public Category deleteCategory(@PathVariable int id) {
//	
//		  Category deleteCategory = this.Cservice.deleteCategory(id);
//		  return deleteCategory;
//	  }  
	
	
	//Find By name
	@GetMapping("/{name}")
	public Category findByName(@PathVariable String name) {
		
		Category byName = Cservice.getByName(name);
		return byName;
	}
	
		
	
	
	}

		
	
	
	
	
	
    


