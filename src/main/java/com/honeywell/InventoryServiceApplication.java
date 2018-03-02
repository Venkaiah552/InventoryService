package com.honeywell;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.honeywell.jpa.model.Category;
import com.honeywell.jpa.model.InventoryStore;
import com.honeywell.jpa.model.Item;
import com.honeywell.jpa.model.Vendor;
import com.honeywell.jpa.repository.CategoryRepository;
import com.honeywell.jpa.repository.InventoryRepository;
import com.honeywell.jpa.repository.ItemRepository;
import com.honeywell.jpa.repository.VendorRepository;
import com.honeywell.util.Size;

@SpringBootApplication
public class InventoryServiceApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(InventoryServiceApplication.class);

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private VendorRepository vendorRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private InventoryRepository inventoryRepository;
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... strings) throws Exception {
		Vendor vendor = createVendor();
		Category category = new Category();
		category.setName("Dry");
		category.setPrority("1");
		categoryRepository.save(category);
		createItems(1,  vendor.getId(), category);
		
		for (Vendor book : vendorRepository.findAll()) {
			logger.info(book.toString());
		}

		for (int i = 0; i < 10; i++) {
			InventoryStore inventoryStore = new InventoryStore();
			inventoryStore.setInventoryDate(new Date());
			inventoryStore.setItem(findItemByName("Apple"+(i+1)));
			inventoryStore.setVendorDetails(vendor);
			inventoryStore.setStoreName("Navesh Store");
			inventoryStore.setQuantityPurchased((i+1)*10);
			inventoryRepository.save(inventoryStore);
		}
		System.out.println("Done");
	}

	private Item findItemByName(String itemName){
		return itemRepository.findByName(itemName);
	}
	private void createItems(int startItem, int vendorId,Category category ) {
		Set<Item> items = new HashSet();
		for (int i = startItem; i < (startItem + 11); i++) {
			Item appleItem = new Item("Apple" + i);
			appleItem.setPrice(100d*i);
			appleItem.setSize(Size.SMALL);
			appleItem.setCategory(category);
			items.add(appleItem);
		}
		Vendor vendor = vendorRepository.findById(vendorId).get();
		if (vendor.getItems() == null) {
			vendor.setItems(items);
		} else {
			vendor.getItems().addAll(items);
		}
		vendorRepository.save(vendor);
	}

	private Vendor createVendor() {
		Vendor vendor = new Vendor("Navesh");
		vendor.setAddress("Bangalore");
		vendor.setCity("Bangalore");
		vendor = vendorRepository.save(vendor);
		return vendor;
	}

	private void updateVendor(Vendor vendor) {
		vendorRepository.save(vendor);
	}
}
