package com.honeywell.jpa.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "inventoryStore")
public class InventoryStore {
	private int id;
	@NotNull
	private String storeName;
	private Item item;
	private int quantityPurchased;
	private Vendor vendorDetails;
	private Date inventoryDate;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getQuantityPurchased() {
		return quantityPurchased;
	}

	public void setQuantityPurchased(int quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_Id", nullable = false)
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	// @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy =
	// "vendor")
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendor_Id", nullable = false)
	public Vendor getVendorDetails() {
		return vendorDetails;
	}

	public void setVendorDetails(Vendor vendorDetails) {
		this.vendorDetails = vendorDetails;
	}

	public Date getInventoryDate() {
		if (inventoryDate == null) {
			inventoryDate = new Date();
		}
		return inventoryDate;
	}

	public void setInventoryDate(Date inventoryDate) {
		this.inventoryDate = inventoryDate;
	}
}
