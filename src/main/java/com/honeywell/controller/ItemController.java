package com.honeywell.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.honeywell.jpa.model.Item;
import com.honeywell.jpa.repository.ItemRepository;

@Controller
@RequestMapping(value="/item")
public class ItemController {
	
	@Autowired
	ItemRepository itemRepository;
	
	
	@RequestMapping(value="/getAllItems", method=RequestMethod.GET)
	public List<Item> getAllItems(){		
		return itemRepository.findAll();		
	}

	@RequestMapping(value="/getAllItems/{id}", method=RequestMethod.GET)
	public List<Item> getItemById(@PathVariable("id") int id){
		return itemRepository.findById(id);
	}
	
}
