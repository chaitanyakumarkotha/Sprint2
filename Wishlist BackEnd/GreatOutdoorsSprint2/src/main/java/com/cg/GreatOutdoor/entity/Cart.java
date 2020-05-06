package com.cg.GreatOutdoor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart_table")
public class Cart {
	
	@Id
	private String userId;
	
	@Column
	private String productId;
	
	@Column
	private int quantity;

	public Cart() {
		super();
	}

}
