package com.honeywell.jpa.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="inventorStore")
public class InventoryStore {
	@NotNull
	private int id;
	
	private int qtySold;
	@NotNull
	private User user;
	
	@NotNull
	private Date txDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQtySold() {
		return qtySold;
	}
	public void setQtySold(int qtySold) {
		this.qtySold = qtySold;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "InventoryStore [id=" + id + ", qtySold=" + qtySold + ", user=" + user + ", txDate=" + txDate + "]";
	}
	
	

}
