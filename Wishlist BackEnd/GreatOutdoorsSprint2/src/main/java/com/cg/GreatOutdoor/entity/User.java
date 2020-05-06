package com.cg.GreatOutdoor.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="user_table")
public class User {

	
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Range(min=1,max=Long.MAX_VALUE)
	private long userId;
	
	@Column(length=20)
	private String password;
	
	@Column(length=20)
	private String role;
	
	@Column(length=20)
	private String phoneNumber;
	
	@Column(length=20)
	private String email;
	
        @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
        private Set<Address> address=new HashSet<Address>();
       
        public Set<Address> getAddress() {
		
		System.out.println("INSIDE GET Address");
		return address;
	    }

	   public void setAddress(Set<Address> address) {
		this.address = address;
	    }
	    
	   
	   
	   
	    
	    public void addAddress(Address a)
	    { System.out.println("inside ADD PRODUCT");
		this.getAddress().add(a);
		a.setUser(this);
		System.out.println(" address added successfully");
	    }
    
	
	@JsonIgnore
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Product> product= new ArrayList<Product>();
	
	public List<Product> getProduct() {
		
		System.out.println("INSIDE GET PRODUCT");
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}



	public User() {
		super();
	}
	

	

	public User( String password, String role, String phoneNumber, String email) {
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
	public void addProduct(List<Product> p)
	{ System.out.println("inside ADD PRODUCT");
		this.setProduct(p);

		System.out.println(" product added successfully");
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", address=" + address + "]";
	}
	
	
}





