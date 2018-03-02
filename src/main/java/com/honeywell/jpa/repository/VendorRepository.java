package com.honeywell.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeywell.jpa.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer>{
	
	List<Vendor> findById(int id);
	
}