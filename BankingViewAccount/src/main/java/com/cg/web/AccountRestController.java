package com.cg.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Account;
import com.cg.exceptions.AccountException;
import com.cg.exceptions.CustomerException;
import com.cg.service.AccountService;


@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
public class AccountRestController {

	@Autowired
	public AccountService service;
	

	
	
	@GetMapping("/viewaccountbyaccid/{accid}")
	public List<Account> viewAccount(@PathVariable("accid") String accId) throws AccountException  {
		
		
		return service.viewAccount(accId);
	}
	
	
	@GetMapping("/viewaccountsbycustid/{custid}")
	public List<Account> viewAccounts(@PathVariable("custid") String custId) throws CustomerException {
		return service.viewAccounts(custId);
	}

}
