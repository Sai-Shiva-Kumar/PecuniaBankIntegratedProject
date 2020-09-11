package com.cg.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.BankDao;
import com.cg.dao.TxnDao;
import com.cg.dto.TransferFundForm;
import com.cg.entity.AccTransaction;
import com.cg.entity.Account;
import com.cg.exceptions.AccountException;
import com.cg.exceptions.BalanceException;
import com.cg.exceptions.TransactionException;
import com.cg.util.AccountConstants;


@Service("accountser")
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	private BankDao accountDao;
	
	@Autowired
	private TxnDao txnDao;

	@Override
	@Transactional
	public String transferFund(TransferFundForm form) throws AccountException, BalanceException, TransactionException {
	Optional<Account> optfromAccount =accountDao.findById(form.getFromAccountId());
	if(!optfromAccount.isPresent())
		throw new AccountException(AccountConstants.INVALID_ACCOUNT + form.getFromAccountId());
	
	Optional<Account> opttoAccount =accountDao.findById(form.getToAccountId());
	if(!opttoAccount.isPresent())
		throw new AccountException(AccountConstants.INVALID_ACCOUNT + form.getToAccountId());
	
	Account fromAcc = optfromAccount.get();
	Account toAcc = opttoAccount.get();
	if(fromAcc.getAccountStatus().equals(AccountConstants.IN_ACTIVE)) 
		throw new TransactionException(form.getFromAccountId() + AccountConstants.IN_ACTIVE_MSG);
	if(toAcc.getAccountStatus().equals(AccountConstants.IN_ACTIVE)) 
		throw new TransactionException(form.getToAccountId() + AccountConstants.IN_ACTIVE_MSG);
	if(fromAcc.getAccountBalance() < form.getAmt())
		throw new BalanceException(AccountConstants.INSUFFICIENT_BALANCE);
	fromAcc.setAccountBalance(fromAcc.getAccountBalance() - form.getAmt());
	toAcc.setAccountBalance(toAcc.getAccountBalance() + form.getAmt());
	accountDao.save(fromAcc);
	accountDao.save(toAcc);
	
	AccTransaction txFrom = new AccTransaction();
	LocalDateTime now = LocalDateTime.now();
	String transId=form.getFromAccountId()+now.getMinute()+now.getSecond();
	
	txFrom.setTransaccountId(transId);
	txFrom.setTransAmount(form.getAmt());
	txFrom.setTransDate(LocalDate.now());
	txFrom.setTransType(AccountConstants.DEBIT);
	txFrom.setTransDescription(AccountConstants.TRANSFER_TO_DESC + form.getToAccountId());
	txFrom.setAccount(fromAcc);
	txnDao.save(txFrom);
	
	AccTransaction txTo = new AccTransaction();
	String transId1=form.getToAccountId()+now.getMinute()+now.getSecond();
	txTo.setTransaccountId(transId1);
	txTo.setTransAmount(form.getAmt());
	txTo.setTransDate(LocalDate.now());
	txTo.setTransType(AccountConstants.CREDIT);
	txTo.setTransDescription(AccountConstants.TRANSFER_FROM_DESC + form.getFromAccountId());
	txTo.setAccount(toAcc);
	txnDao.save(txTo);
	
		return AccountConstants.TRANSFERED;
	}
	
}














