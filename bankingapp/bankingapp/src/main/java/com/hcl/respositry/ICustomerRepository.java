package com.hcl.respositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Long>{
Customer findByPanNumber(String panNumber);
}
