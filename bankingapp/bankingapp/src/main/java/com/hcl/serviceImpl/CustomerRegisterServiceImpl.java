package com.hcl.serviceImpl;

import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dto.CustomerRegisterRequestDTO;
import com.hcl.entity.Account;
import com.hcl.entity.Customer;
import com.hcl.exception.UserDefinedException;
import com.hcl.respositry.IAccountRepository;
import com.hcl.respositry.ICustomerRepository;
import com.hcl.service.ICustomerRegisterService;

@Service
public class CustomerRegisterServiceImpl implements ICustomerRegisterService {

	@Autowired
	public ICustomerRepository customerRepository;

	@Autowired
	public IAccountRepository accountRepository;

	@Override
	public String addCustomer(CustomerRegisterRequestDTO customerRegistrationDTO) throws UserDefinedException{

		Customer customerDetails = new Customer();
		Account accountDetails = new Account();

		Random r = new Random();
		if (customerRepository.findByPanNumber(customerRegistrationDTO.getPanNumber())==null) {

			BeanUtils.copyProperties(customerRegistrationDTO, customerDetails);

			customerRepository.save(customerDetails);

			accountDetails.setAccountNumber(r.nextInt(999999999));
			accountDetails.setAccountType("saving");
			accountDetails.setIfsccode("HDFC00001276");
			accountDetails.setBranchAddress("Bangalore");
			accountDetails.setOpeningBalance(10000.00);
			accountDetails.setCurrentBalance(10000.00);
			accountDetails.setCustomerDetails(customerDetails);

			accountRepository.save(accountDetails);

			return "Customer registered successfully and Account Number "+accountDetails.getAccountNumber()+" with opening Balance of 10000.00 is opened";
		}

		else {
			throw new UserDefinedException("PanCard Already Exists......Registration Failed...");
		}

	}
}