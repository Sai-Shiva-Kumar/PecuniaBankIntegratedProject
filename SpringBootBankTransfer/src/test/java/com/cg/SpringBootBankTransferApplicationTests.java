package com.cg;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.dto.TransferFundForm;
import com.cg.exceptions.AccountException;
import com.cg.exceptions.BalanceException;
import com.cg.exceptions.TransactionException;
import com.cg.service.AccountService;



@SpringBootTest
class SpringBootBankTransferApplicationTests {
   
	@Autowired
	private AccountService service;
	
	
	
	@Test
	public void testTransferFund1() throws AccountException, BalanceException, TransactionException 
	{
		TransferFundForm transfer= new TransferFundForm();
		transfer.setFromAccountId("PBI9151730");
		transfer.setToAccountId("PBI6782912");
		transfer.setAmt(250);
		String result= service.transferFund(transfer);
		Assertions.assertEquals("Amount Transfered Successfully",result);
	}
	
	@Test
	public void testTransferFund2() throws AccountException, BalanceException, TransactionException 
	{
		TransferFundForm transfer= new TransferFundForm();
		transfer.setFromAccountId("PBI9151730");
		transfer.setToAccountId("PBI6782914");
		transfer.setAmt(250);
	
		assertThrows(AccountException.class, ()->service.transferFund(transfer));
	}
	
	
}
