package com.honeywell.jpa.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Item {
    private int id;
    private String name;
    private Set<Vendor> vendors;

    public Item(){

    }

    public Item(String name){
        this.name = name;
    }

    public Item(String name, Set<Vendor> vendors){
        this.name = name;
        this.vendors = vendors;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}