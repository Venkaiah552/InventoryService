package com.honeywell.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "category")
public class Category {

	private int id;
	@NotNull
	private String name;
	@NotNull
	private String prority;
	private Set<Item> items;

	public Category() {
		super();
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

	public String getPrority() {
		return prority;
	}

	public void setPrority(String prority) {
		this.prority = prority;
	}
	
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}
}
