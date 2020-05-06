package com.cg.GreatOutdoor.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="product_user_table")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Range(min=1,max=Long.MAX_VALUE)
	private int product_user_id;
	
	@Column(length=10)
	private long productId;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user ;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getProduct_user_id() {
		return product_user_id;
	}
	public void setProduct_user_id(int product_user_id) {
		this.product_user_id = product_user_id;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public Product(Long productId) {
		super();
		
		this.productId = productId;
		
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [product_user_id=" + product_user_id + ", productId=" + productId + ", user=" + user + "]";
	}
	

    

}
