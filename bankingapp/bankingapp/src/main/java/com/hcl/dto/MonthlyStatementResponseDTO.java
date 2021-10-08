package com.hcl.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyStatementResponseDTO {
	private long transactionId;

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

	private Date transactionDate;

	private long accountNo;

	private Double amount;

	private Double currentBal;

	private String credit_debit;

	private String message;
	
	

}
