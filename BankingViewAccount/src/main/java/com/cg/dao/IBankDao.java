package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.entity.Account;
import com.cg.entity.Customer;

public interface IBankDao extends  JpaRepository<Customer,String> {
	
	@Query("from Account a where a.accountId=:accId")
	public List<Account> viewAccount(@Param("accId") String accountId);
	
	@Query("from Account a where a.customer.customerId=:custId")
	public List<Account> viewAccounts(@Param("custId") String customerId);
	
	
}
