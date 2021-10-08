package com.hcl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.CustomerRegisterRequestDTO;
import com.hcl.exception.UserDefinedException;
import com.hcl.service.ICustomerRegisterService;

@RestController
@RequestMapping("/customers")
public class CustomerRegisterController {

	@Autowired
	private ICustomerRegisterService customerRegisterService;

	@PostMapping
	public ResponseEntity<String> customerRegistration(@Valid @RequestBody CustomerRegisterRequestDTO customerRegistrationDTO) throws UserDefinedException {
		String response = customerRegisterService.addCustomer(customerRegistrationDTO);
		 return new ResponseEntity<String>(response,HttpStatus.OK);

	}

}
