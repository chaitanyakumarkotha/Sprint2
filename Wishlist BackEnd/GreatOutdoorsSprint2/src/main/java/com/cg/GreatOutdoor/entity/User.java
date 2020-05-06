package com.cg.GreatOutdoor.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Range;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "userTable")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Range(min = 1, max = Long.MAX_VALUE)
	private long userId;

	@Column(length = 20)
	private String password;

	@Column(length = 20)
	private String role;

	@Column(length = 20)
	private String phoneNumber;

	@Column(length = 20)
	private String email;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Address> address = new HashSet<Address>();

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public void addAddress(Address a) {
		this.getAddress().add(a);
		a.setUser(this);

	}

	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<WishlistProduct> product = new ArrayList<WishlistProduct>();

	public List<WishlistProduct> getProduct() {

		return product;
	}

	public void setProduct(List<WishlistProduct> product) {
		this.product = product;
	}

	public User() {
		super();
	}

	public User(String password, String role, String phoneNumber, String email) {
		super();

		this.password = password;
		this.role = role;
		this.phoneNumber = phoneNumber;
		this.email = email;

	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@JsonIgnore
	public void addProduct(List<WishlistProduct> p) {
		this.setProduct(p);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", address=" + address + "]";
	}

}
