package com.honeywell.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeywell.jpa.model.Category;
import com.honeywell.jpa.repository.CategoryRepository;
import com.honeywell.util.Size;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> getCategoryByPrority(Size size){		
		//return categoryRepository.findAll(size);	
		
		return null;
	}

	public List<Category> getItemById(int id){
		return categoryRepository.findById(id);
	}
	
}
