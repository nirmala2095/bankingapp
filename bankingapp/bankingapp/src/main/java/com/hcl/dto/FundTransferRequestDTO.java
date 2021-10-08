package com.hcl.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FundTransferRequestDTO {

	@NotNull(message="please enter fromaccount")
	@Positive(message="please enter postive value")
	private long fromAccount;

	@NotNull(message="please enter toaccount")
	@Positive(message="please enter postive value")
	private long toAccount;

	@NotNull(message="please enter amount")
	@Positive(message="please enter postive value")
	@Min(100)
	@Max(9000)
	private Double amount;

	private String remarks;

	public long getFromAccount() {
		return fromAccount;
	}

	public long getToAccount() {
		return toAccount;
	}

	public Double getAmount() {
		return amount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setFromAccount(long fromAccount) {
		this.fromAccount = fromAccount;
	}

	public void setToAccount(long toAccount) {
		this.toAccount = toAccount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


}
