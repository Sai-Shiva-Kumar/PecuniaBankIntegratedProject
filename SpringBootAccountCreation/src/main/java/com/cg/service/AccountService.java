package com.cg.service;

import com.cg.dto.AccountForm;
import com.cg.dto.CustomerForm;
import com.cg.exceptions.AgeException;
import com.cg.exceptions.CustomerException;
import com.cg.exceptions.LoginException;

public interface AccountService {
	
	public String addAccount(AccountForm account)throws CustomerException;
	public String addCustomer(CustomerForm custForm) throws AgeException;
	public String validateTokenInLoginRestController(String tokenId) throws LoginException;
}
