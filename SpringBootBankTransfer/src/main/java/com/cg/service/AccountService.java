package com.cg.service;

import com.cg.dto.TransferFundForm;
import com.cg.exceptions.AccountException;
import com.cg.exceptions.BalanceException;
import com.cg.exceptions.TransactionException;


public interface AccountService {
	

	
	public String transferFund(TransferFundForm form) throws AccountException, BalanceException, TransactionException;
}
