package com.hcl.serviceImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.dto.FundTransferRequestDTO;
import com.hcl.dto.MonthlyStatementResponseDTO;
import com.hcl.entity.Account;
import com.hcl.entity.Transaction;
import com.hcl.exception.UserDefinedException;
import com.hcl.respositry.IAccountRepository;
import com.hcl.respositry.ITransactionRepository;
import com.hcl.service.ITransactionService;

@Service
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	private IAccountRepository accountRepository;

	@Autowired
	private ITransactionRepository transactionRepository;

	@Override
	public String fundTransfer(FundTransferRequestDTO fundTransferRequestDTO) throws UserDefinedException {
		Transaction sourceAccount = new Transaction();
		Transaction destinationAccount = new Transaction();

		Optional<Account> fromAccount = accountRepository.findByAccountNumber(fundTransferRequestDTO.getFromAccount());
		Optional<Account> toAccount = accountRepository.findByAccountNumber(fundTransferRequestDTO.getToAccount());
		Account toAccountDetails = toAccount.get();
		Account fromAccountDetails = fromAccount.get();

		if (accountRepository.findByAccountNumber(fromAccountDetails.getAccountNumber()).isPresent()) {
			if (accountRepository.findByAccountNumber(toAccountDetails.getAccountNumber()).isPresent()) {

				if (fromAccountDetails.getAccountNumber() != toAccountDetails.getAccountNumber()) {

					if ((fromAccountDetails.getCurrentBalance() > fundTransferRequestDTO.getAmount())
							&& fundTransferRequestDTO.getAmount() > 0) {

						double fromAccountBalance = fromAccountDetails.getCurrentBalance()
								- fundTransferRequestDTO.getAmount();
						fromAccountDetails.setCurrentBalance(fromAccountBalance);

						accountRepository.save(fromAccountDetails);
						double toAccountBalance = toAccountDetails.getCurrentBalance()
								+ fundTransferRequestDTO.getAmount();
						toAccountDetails.setCurrentBalance(toAccountBalance);
						accountRepository.save(toAccountDetails);

						sourceAccount.setAccountNo(fromAccountDetails.getAccountNumber());
						sourceAccount.setAmount(fundTransferRequestDTO.getAmount());
						sourceAccount.setCurrentBal(fromAccountBalance);
						sourceAccount.setCredit_debit("debit");
						sourceAccount.setMessage(fundTransferRequestDTO.getRemarks());
						System.out.println(fromAccountDetails);
						sourceAccount.setAccount(fromAccountDetails);
						// to set local time
						java.util.Date date = new java.util.Date();
						long time = date.getTime();
						Timestamp transactiondate = new Timestamp(time);
						sourceAccount.setTransactionDate(transactiondate);
						transactionRepository.save(sourceAccount);

						destinationAccount.setAccountNo(toAccountDetails.getAccountNumber());
						destinationAccount.setAmount(fundTransferRequestDTO.getAmount());
						destinationAccount.setCurrentBal(toAccountBalance);
						destinationAccount.setCredit_debit("credit");
						destinationAccount.setMessage(fundTransferRequestDTO.getRemarks());
						destinationAccount.setTransactionDate(transactiondate);
						destinationAccount.setAccount(toAccountDetails);
						transactionRepository.save(destinationAccount);

					} else {
						throw new UserDefinedException(" Insufficient Balance");
					}
				} else {
					throw new UserDefinedException(
							"FromAccount and ToAccount is same.Please enter valid Account Number");

				}
			} else {
				throw new UserDefinedException(" ToAccount not found.Please enter valid Account Number");
			}
		} else {
			throw new UserDefinedException("FromAccount not found.Please enter valid Account Number");
		}
		return "Transaction  is done Succesfully.";
	}

	//To get Transaction History based on Account number,month and year
	@SuppressWarnings("deprecation")
	@Override
	public List<MonthlyStatementResponseDTO> getMonthlyStatement(long accountNo, int month, int year)
			throws UserDefinedException {
		List<Transaction> response = new ArrayList<Transaction>();
		List<MonthlyStatementResponseDTO> transactionHistory = new ArrayList<>();
		java.util.Date date = new java.util.Date();
		long checkYear = date.getYear() + 1900;
		if (accountRepository.findByAccountNumber(accountNo).isPresent() && (month > 0 && month <= 12)
				&& (year <= checkYear)) {
			if (!transactionRepository.getTransactionHistory(accountNo, month, year).isEmpty()) {

				response = transactionRepository.getTransactionHistory(accountNo, month, year);

			} else {

				throw new UserDefinedException("This account number has no transaction history for this period");

			}
		} else {
			throw new UserDefinedException("Please enter valid details");
		}
		response.stream().forEach(history -> {
			MonthlyStatementResponseDTO monthlyHistory = new MonthlyStatementResponseDTO();
			BeanUtils.copyProperties(history, monthlyHistory);

			transactionHistory.add(monthlyHistory);

		});
		return transactionHistory;

	}

}