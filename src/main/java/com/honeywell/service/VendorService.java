package com.honeywell.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeywell.jpa.model.Item;
import com.honeywell.jpa.model.Vendor;
import com.honeywell.jpa.repository.VendorRepository;

@Service
public class VendorService {
	
	@Autowired
	VendorRepository vendorRepository;
	
	public List<Vendor> getVendors(){
		return vendorRepository.findAll();
	}

	public List<Vendor> findById(int id){
		return vendorRepository.findById(id);
	}
	
	
}
