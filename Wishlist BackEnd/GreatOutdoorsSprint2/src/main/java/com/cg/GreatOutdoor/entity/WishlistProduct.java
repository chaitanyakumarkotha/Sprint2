package com.cg.GreatOutdoor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "WishlistTable")
public class WishlistProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Range(min = 1, max = Long.MAX_VALUE)
	private int productUserId;

	@Column(length = 10)
	private long productId;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public WishlistProduct(long productId) {
		super();

		this.productId = productId;

	}

	public WishlistProduct() {
		super();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getProductUserId() {
		return productUserId;
	}

	public void setProductUserId(int productUserId) {
		this.productUserId = productUserId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "WishlistProduct [productUserId=" + productUserId + ", productId=" + productId + ", user=" + user + "]";
	}

}
