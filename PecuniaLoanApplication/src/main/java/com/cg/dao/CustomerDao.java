package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Customer;

@Repository

public interface CustomerDao extends JpaRepository<Customer,String> {


	@Query("from Customer where customerId=:custId")
	public Customer getCustomer(@Param("custId") String customerId);
	public Customer findByCustomerId(String customerId);
	
	
	
}
