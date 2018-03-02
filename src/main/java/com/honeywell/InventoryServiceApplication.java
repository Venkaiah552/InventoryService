package com.honeywell;

import java.util.HashSet;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.honeywell.jpa.model.Category;
import com.honeywell.jpa.model.Item;
import com.honeywell.jpa.model.Vendor;
import com.honeywell.jpa.repository.CategoryRepository;
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
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... strings) throws Exception {
		// save a couple of books
		Item appleItem = new Item("Apple");
		appleItem.setPrice(100d);
		appleItem.setSize(Size.SMALL);
		
		Category category = new Category();
		category.setName("Wet");
		category.setPrority("1");
		appleItem.setCategory(category);
		categoryRepository.save(category);
		HashSet<Item> items = new HashSet<Item>();
		items.add(appleItem);
		Vendor vendor = new Vendor("Navesh", items);
		vendor.setAddress("Bangalore");
		vendor.setCity("Bangalore");
		vendorRepository.save(vendor);
		// fetch all books
		for (Vendor book : vendorRepository.findAll()) {
			logger.info(book.toString());
		}

	}
}
