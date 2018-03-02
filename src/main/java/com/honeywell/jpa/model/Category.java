package com.honeywell.jpa.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="category")
public class Category {
	
	@NotNull
	private int id;
	@NotNull
	private String name;
	@NotNull
	private String prority;

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

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", prority=" + prority + "]";
	}
	
	
	
}
