package com.honeywell.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeywell.jpa.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	Item findByName(String name);
}