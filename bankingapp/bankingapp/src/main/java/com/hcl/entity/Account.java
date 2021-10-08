package com.hcl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/*import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;*/
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {
	@Id
	@SequenceGenerator(name = "account_id", sequenceName = "account_sequence", initialValue = 200, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_id")
	@Column(name = "id")
	private long accountId;
	
	private long accountNumber;
	private String ifsccode;
	private Double openingBalance;
	private Double currentBalance;
	private String accountType;
	private String branchAddress;

	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customerDetails;

	public long getAccountId() {
		return accountId;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public Double getOpeningBalance() {
		return openingBalance;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public Customer getCustomerDetails() {
		return customerDetails;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public void setOpeningBalance(Double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public void setCustomerDetails(Customer customerDetails) {
		this.customerDetails = customerDetails;
	}

	

}
