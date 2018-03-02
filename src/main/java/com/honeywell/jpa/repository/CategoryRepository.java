package com.honeywell.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.honeywell.jpa.model.Category;

@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	public List<Category> findById(int id);
	
	//public List<Category> findByPriority();
	

}
