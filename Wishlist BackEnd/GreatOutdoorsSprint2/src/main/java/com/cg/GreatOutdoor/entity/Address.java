package com.cg.GreatOutdoor.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "addressTable")
public class Address implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Range(min = 1, max = Long.MAX_VALUE)
	private long addressId;

	@Column(length = 5)
	private String retailerId;

	@Column(length = 10)
	private String buildingNo;

	@Column(length = 20)
	private String city;

	@Column(length = 20)
	private String state;

	@Column(length = 20)
	private String field;

	@Column(length = 6)
	private String zip;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public Address() {
		super();
	}

	public Address(String retailerId, String buildingNo, String city, String state, String field, String zip) {
		super();

		this.retailerId = retailerId;
		this.buildingNo = buildingNo;
		this.city = city;
		this.state = state;
		this.field = field;
		this.zip = zip;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(String retailerId) {
		this.retailerId = retailerId;
	}

	public String getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", retailerId=" + retailerId + ", buildingNo=" + buildingNo
				+ ", city=" + city + ", state=" + state + ", field=" + field + ", zip=" + zip;
	}

}
