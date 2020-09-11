package com.cg.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.IBankDao;
import com.cg.entity.Account;
import com.cg.exceptions.AccountException;
import com.cg.exceptions.CustomerException;
import com.cg.util.AccountConstants;


@Service("accountser")
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	private IBankDao dao;
	
	
	@Override
	public List<Account> viewAccounts(String custId) throws CustomerException {
		List<Account> accList = dao.viewAccounts(custId);
		if(accList.isEmpty())
			throw new CustomerException(AccountConstants.INVALID_CUSTOMER);
		accList.sort((acc1, acc2)-> acc1.getAccountName().compareTo(acc2.getAccountName()));
		return accList;
	}

	@Override
	public List<Account> viewAccount(String accId) throws AccountException {
		List<Account> accList = dao.viewAccount(accId);
		if(accList.isEmpty())
			throw new AccountException(AccountConstants.INVALID_ACCOUNT);
		accList.sort((acc1, acc2)-> acc1.getAccountName().compareTo(acc2.getAccountName()));
		return accList;
	}

}
