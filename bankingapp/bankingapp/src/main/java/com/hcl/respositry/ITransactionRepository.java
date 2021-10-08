package com.hcl.respositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.entity.Transaction;

public interface ITransactionRepository extends JpaRepository<Transaction, Long> {

	@Query("from Transaction where accountNo=:accountNo and month(transactionDate)=:month and year(transactionDate)=:year")
	List<Transaction> getTransactionHistory(long accountNo, int month, int year);

}
