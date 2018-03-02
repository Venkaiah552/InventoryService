package com.honeywell.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeywell.jpa.model.Item;
import com.honeywell.jpa.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	public List<Item> getAllItems(){
		return itemRepository.findAll();
	}

	public List<Item> getItemById(int id){
		return itemRepository.findById(id);
	}

}
