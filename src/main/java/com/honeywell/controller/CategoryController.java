package com.honeywell.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.honeywell.jpa.model.Category;
import com.honeywell.jpa.model.Item;
import com.honeywell.jpa.repository.CategoryRepository;
import com.honeywell.service.CategoryService;
import com.honeywell.util.Size;

@Controller
@RequestMapping(value="/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="/getCategoryByPrority/${size}", method=RequestMethod.GET)
	public List<Category> getCategoryByPrority(@PathVariable("size") Size size){		
		return categoryService.getCategoryByPrority(size);		
	}

	@RequestMapping(value="/getCategory/{id}", method=RequestMethod.GET)
	public List<Category> getItemById(@PathVariable("id") int id){
		return categoryService.getItemById(id);
	}

}
