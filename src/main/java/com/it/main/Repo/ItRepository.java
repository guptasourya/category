package com.it.main.Repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.it.main.entities.Category;

public interface ItRepository extends JpaRepository<Category, Integer>{
	
	public Category findByName(String name);

	@Query(value="select * from category where parent_id=?",nativeQuery = true)
	public List<Category> getChildList(int id);

}