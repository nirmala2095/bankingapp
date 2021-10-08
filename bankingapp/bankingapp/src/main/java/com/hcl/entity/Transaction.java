package com.hcl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Transaction")
public class Transaction {

	public long getTransactionId() {
		return transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public Double getAmount() {
		return amount;
	}

	public Double getCurrentBal() {
		return currentBal;
	}

	public String getCredit_debit() {
		return credit_debit;
	}

	public String getMessage() {
		return message;
	}

	public Account getAccount() {
		return account;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setCurrentBal(Double currentBal) {
		this.currentBal = currentBal;
	}

	public void setCredit_debit(String credit_debit) {
		this.credit_debit = credit_debit;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Id
	@SequenceGenerator(name = "transaction_id", sequenceName = "transaction_sequence", initialValue = 300, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_id")
	@Column(name = "transactionId")
	private long transactionId;

	@Column(name = "transactionDate")
	private Date transactionDate;

	@Column(name = "accountNo")
	private long accountNo;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "currentBal")
	private Double currentBal;

	@Column(name = "credit_debit")
	private String credit_debit;

	@Column(name = "message")
	private String message;
	
	@ManyToOne
	private Account account; 
}
