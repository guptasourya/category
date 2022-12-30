package com.it.main.Repo;


import org.springframework.data.jpa.repository.JpaRepository;


import com.it.main.entities.Category;

public interface ItRepository extends JpaRepository<Category, Integer>{
	
	public Category findByName(String name);

}