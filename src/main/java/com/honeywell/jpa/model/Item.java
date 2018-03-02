package com.honeywell.jpa.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.honeywell.util.Size;

import java.util.Set;

@Entity
@Table(name = "item")
public class Item {
	private int id;
	@NotNull
	private String name;
	private Set<Vendor> vendors;
	@NotNull
	@Column(name = "size")
    private String size;
	@NotNull
	private Double price;

	private Category category;

	public Item() {

	}

	public Item(String name) {
		this.name = name;
	}

	public Item(String name, Set<Vendor> vendors) {
		this.name = name;
		this.vendors = vendors;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(mappedBy = "items")
	public Set<Vendor> getVendors() {
		return vendors;
	}

	public void setVendors(Set<Vendor> vendors) {
		this.vendors = vendors;
	}

	public Size getSize() {
		return Size.parse(this.size);
	}

	public void setSize(Size size) {
		this.size = size.getValue();
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@ManyToOne
    @JoinColumn(name = "category_id")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}