package com.honeywell.jpa.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Vendor{
    private int id;
    private String name;
    private Set<Item> items;

    public Vendor() {

    }

    public Vendor(String name) {
        this.name = name;
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

    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Vendor_items", joinColumns = @JoinColumn(name = "Vendor_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

    @Override
    public String toString() {
        String result = String.format(
                "Vendor [id=%d, name='%s']%n",
                id, name);
        if (items != null) {
            for(Item item : items) {
                result += String.format(
                        "Item[id=%d, name='%s']%n",
                        item.getId(), item.getName());
            }
        }

        return result;
    }
}