package com.cg.GreatOutdoor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ALLPRODUCTS")
public class AllProducts {
//	@Id
//	@Column(length=10)
//	private String productId;
	
	
	@Id
	@Column(name = "Product_Id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;
	
	
	
	
	

	@Column(length=5)
	private double price;
	
	@Column(length=7)
	private String colour;
	
	@Column(length=10)
	private String dimension;
	
	@Column(length=15)
	private String specification;
	
	@Column(length=10)
	private String manufacturer;
	
	@Column(length=3)
	private int quantity;
	
	@Column(length=10)
	private int productCategory;
	
	@Column(length=10)
	private String productName;
	

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public AllProducts( double price, String colour, String dimension, String specification,
			String manufacturer, int quantity, int productCategory, String productName) {
		super();
		
		this.price = price;
		this.colour = colour;
		this.dimension = dimension;
		this.specification = specification;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.productCategory = productCategory;
		this.productName = productName;
	}

	public AllProducts() {
		super();
	}

	@Override
	public String toString() {
		return "AllProducts [productId=" + productId + ", price=" + price + ", colour=" + colour + ", dimension="
				+ dimension + ", specification=" + specification + ", manufacturer=" + manufacturer + ", quantity="
				+ quantity + ", productCategory=" + productCategory + ", productName=" + productName + "]";
	}

	
}
