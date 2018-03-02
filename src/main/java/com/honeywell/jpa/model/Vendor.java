package com.honeywell.jpa.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Set;

@Entity
@Table(name = "vendor")
public class Vendor {
	private int id;
	@NotNull
	private String name;
	private Set<Item> items;
	@NotNull
	private String address;
	@NotNull
	private String city;

	public Vendor() {

	}

	public Vendor(String name) {
		this.name = name;
	}
	public Vendor(String name, Set<Item> items){
        this.name = name;
        this.items = items;
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

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "vendor_items", joinColumns = @JoinColumn(name = "vendor_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		String result = String.format("Vendor [id=%d, name='%s']%n", id, name);
		if (items != null) {
			for (Item item : items) {
				result += String.format("Item[id=%d, name='%s']%n", item.getId(), item.getName());
			}
		}

		return result;
	}
}