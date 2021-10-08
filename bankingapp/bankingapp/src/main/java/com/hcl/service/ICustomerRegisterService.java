package com.hcl.service;


import com.hcl.dto.CustomerRegisterRequestDTO;
import com.hcl.exception.UserDefinedException;

public interface ICustomerRegisterService {

	String addCustomer( CustomerRegisterRequestDTO customerRegistrationDTO) throws UserDefinedException;


}
