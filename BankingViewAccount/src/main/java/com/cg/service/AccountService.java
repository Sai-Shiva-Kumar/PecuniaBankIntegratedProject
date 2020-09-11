package com.cg.service;

import java.util.List;

import com.cg.entity.Account;
import com.cg.exceptions.AccountException;
import com.cg.exceptions.CustomerException;

public interface AccountService {
	
	public List<Account> viewAccounts(String custId)throws CustomerException;
	public List<Account> viewAccount(String accId)throws AccountException;
}
