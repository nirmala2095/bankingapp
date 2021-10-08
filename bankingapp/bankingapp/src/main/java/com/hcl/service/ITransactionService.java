package com.hcl.service;

import java.util.List;

import com.hcl.dto.FundTransferRequestDTO;
import com.hcl.dto.MonthlyStatementResponseDTO;
import com.hcl.exception.UserDefinedException;

public interface ITransactionService {
	String fundTransfer( FundTransferRequestDTO fundTransferRequestDTO) throws UserDefinedException;
	List<MonthlyStatementResponseDTO> getMonthlyStatement(long accountNo, int month, int year) throws UserDefinedException;

}
