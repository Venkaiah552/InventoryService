package com.honeywell.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honeywell.dto.InventoryDetails;
import com.honeywell.dto.VendorInventoryDetails;
import com.honeywell.jpa.model.InventoryStore;
import com.honeywell.jpa.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public List<InventoryDetails> getInventoryDetails() {
		Map<String, InventoryDetails> details = new HashMap<>();
		List<InventoryStore> storeDetailsList = inventoryRepository.findAll();
		if (storeDetailsList != null && !storeDetailsList.isEmpty()) {
			for (InventoryStore inventoryStore : storeDetailsList) {
				InventoryDetails idetails = null;
				if (details.containsKey(inventoryStore.getItem().getName())) {
					idetails = details.get(inventoryStore.getItem().getName());
					idetails.setTotalQuantity(idetails.getTotalQuantity() + inventoryStore.getQuantityPurchased());
				} else {
					idetails = new InventoryDetails();
					idetails.setItemName(inventoryStore.getItem().getName());
					idetails.setTotalQuantity(inventoryStore.getQuantityPurchased());
				}
				details.put(inventoryStore.getItem().getName(), idetails);
			}
		}

		return new ArrayList<>(details.values());
	}

	@Override
	public List<InventoryDetails> getInventoryDetailsByVendorId(int vendorId) {
		Map<String, InventoryDetails> details = new HashMap<>();
		List<InventoryStore> storeDetailsList = inventoryRepository.findByVendorDetails(vendorId);
		if (storeDetailsList != null && !storeDetailsList.isEmpty()) {
			for (InventoryStore inventoryStore : storeDetailsList) {
				InventoryDetails idetails = null;
				if (!details.containsKey(inventoryStore.getItem().getName())) {
					idetails = details.get(inventoryStore.getItem().getName());
					idetails.setTotalQuantity(idetails.getTotalQuantity() + inventoryStore.getQuantityPurchased());
				} else {
					idetails = new InventoryDetails();
					idetails.setItemName(inventoryStore.getItem().getName());
					idetails.setTotalQuantity(inventoryStore.getQuantityPurchased());
				}
				details.put(inventoryStore.getItem().getName(), idetails);
			}
		}

		return new ArrayList<>(details.values());
	}

	@Override
	public List<VendorInventoryDetails> getInventoryDetailsGroupByVendor() {
		return null;
	}

}
