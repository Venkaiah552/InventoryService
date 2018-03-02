package com.honeywell.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeywell.jpa.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{
	List<Item> findById(int id);
}