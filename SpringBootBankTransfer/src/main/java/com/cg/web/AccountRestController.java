package com.cg.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.AccountForm;
import com.cg.dto.AccountMessage;
import com.cg.dto.SuccessMessage;
import com.cg.dto.TransferFundForm;
import com.cg.entity.Account;
import com.cg.exceptions.AccountException;
import com.cg.exceptions.BalanceException;
import com.cg.exceptions.CustomerException;
import com.cg.exceptions.TransactionException;
import com.cg.service.AccountService;
import com.cg.util.AccountConstants;


@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
public class AccountRestController {

	@Autowired
	public AccountService service;
	
	@PostMapping(AccountConstants.TRANSFER_URL)
 public SuccessMessage transferFund(@RequestBody TransferFundForm form) throws AccountException, BalanceException, TransactionException {
	String msg =  service.transferFund(form);
	return new SuccessMessage(msg);
 }

	

}
