package com.honeywell.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.honeywell.jpa.model.Item;
import com.honeywell.jpa.model.Vendor;
import com.honeywell.jpa.repository.VendorRepository;
import com.honeywell.service.ItemService;
import com.honeywell.service.VendorService;

@Controller
@RequestMapping(value="/vendor")
public class VendorController {
	
	@Autowired
	VendorService vendorService;
	
	@Autowired
	ItemService itemService;
	
	
	@RequestMapping(value="/getAllVendors", method=RequestMethod.GET)
	public List<Vendor> getVendors(){		
		List<Vendor> vendorList = vendorService.getVendors();
		return vendorList;
		
	}
	
	@RequestMapping(value="/getAllVendors/{id}", method=RequestMethod.GET)
	public List<Vendor> getVendorById(@PathVariable("id") int id){		
		List<Vendor> vendorList = vendorService.findById(id);
		return vendorList;
		
	}
	
	@RequestMapping(value="/getAllVendors/{Itemid}", method=RequestMethod.GET)
	public List<Vendor> getVendorByItem(@PathVariable("Itemid") int id){			
		List<Vendor> vendorList = new ArrayList<>();
		List<Item> itemList = itemService.getItemById(id);
		for(Item item:itemList ) {
			vendorList.addAll(vendorService.findById(item.getId()));
		}
		return vendorList;
		
	}
	

}
