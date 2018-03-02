package com.honeywell.service;

import java.util.List;

import com.honeywell.dto.InventoryDetails;
import com.honeywell.dto.VendorInventoryDetails;

public interface InventoryService {
	List<InventoryDetails> getInventoryDetails();

	List<InventoryDetails> getInventoryDetailsByVendorId(int vendorId);

	List<VendorInventoryDetails> getInventoryDetailsGroupByVendor();

}
