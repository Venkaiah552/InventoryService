package com.honeywell.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeywell.jpa.model.InventoryStore;

public interface InventoryRepository extends JpaRepository<InventoryStore, Integer> {

}
