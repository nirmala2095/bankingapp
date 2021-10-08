package com.hcl.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegisterRequestDTO {


	@NotEmpty(message = "firstName should not be empty")
	@Size(min = 3, max = 20, message = " firstName should less than 20 character only")
	private String firstName;

	@NotEmpty(message = "lastName should not be empty")
	@Size(min = 3, max = 20, message = " lastName should less than 20 character only")
	private String lastName;

	@NotEmpty(message = "emailId should not be empty")
	@Email
	@Size(min = 5, max = 100, message = "EmailId size should  be below 100 characterstics only")
	private String emailId;

	@NotEmpty(message = "Please provide a Mobile Number")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Provide valid Mobile Number")
	@Size(max = 10, message = "phone number is of 10 digits")
	private String phoneNumber;

	@NotEmpty(message = "gender should not be empty")
	private String gender;

	@NotEmpty(message = "PanNumber should not be empty")
	@Size(max = 10, message = "PanNumber should be l0 character only")
	@Pattern(regexp = "(^$|[A-Z]{5}[0-9]{4}[A-Z]{1})", message = "Provide valid PanNumber")
	private String panNumber;


	@NotNull(message = "Age should not be empty")
	@Min(18)
	private int age;

	@NotEmpty(message = "Address should not be empty")
	@Size(min = 3, max = 100, message = "Address should be minimum 3 characters and maximum 100 character only")
	private String address;


	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
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

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public void setAge(int age) {
		this.age = age;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
