package com.honeywell.jpa.model;

import javax.persistence.*;

@Entity
public class Category {
	
	private int id;
	private String name;
	private String prority;

	public Category() {
		super();
	}
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
	
	
}
