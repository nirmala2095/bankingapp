package com.hcl.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.FundTransferRequestDTO;
import com.hcl.dto.MonthlyStatementResponseDTO;
import com.hcl.exception.UserDefinedException;
import com.hcl.service.ITransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	@Autowired
	private ITransactionService transactionService;  
	
	@PostMapping
	public ResponseEntity<String> fundTransfer(@Valid @RequestBody FundTransferRequestDTO fundTransferRequestDTO)
			throws UserDefinedException {
		String response = transactionService.fundTransfer(fundTransferRequestDTO);

		 return new ResponseEntity<String>(response,HttpStatus.OK);

	}
	
	@GetMapping("/{accountNo}/{month}/{year}")
	public List<MonthlyStatementResponseDTO> getMonthStatement(@PathVariable long accountNo,@PathVariable int month,@PathVariable int year ) throws UserDefinedException
	{
		List<MonthlyStatementResponseDTO> statement = transactionService.getMonthlyStatement(accountNo,month,year);

		return statement;
		
	}
}
