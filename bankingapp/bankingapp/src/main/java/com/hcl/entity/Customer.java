package com.hcl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

	public long getCustomerId() {
		return customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Id
	@SequenceGenerator(name = "customer_id", sequenceName = "customer_sequence", initialValue = 100, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id")
	@Column(name = "id")
	private long customerId;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
		
	@Column(name = "age")
	private int age;
	
	@Column(name = "emailId")
	private String emailId;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "gender",columnDefinition = "VARCHAR(60) CHECK (gender IN ('Female', 'Male'))")
	private String gender;
	
	@Column(name = "panNumber",unique=true)
	private String panNumber;
	
	@Column(name = "address")
	private String address;
}
