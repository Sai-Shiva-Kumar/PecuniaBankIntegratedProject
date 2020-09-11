package com.cg.web;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.dto.AccountMessage;
import com.cg.dto.ErrorMessage;
import com.cg.exceptions.AccountException;
import com.cg.exceptions.BalanceException;
import com.cg.exceptions.CustomerException;
import com.cg.exceptions.TransactionException;
import com.cg.util.AccountConstants;

@RestControllerAdvice
public class BankExceptionAdvice {

	Logger logger = LoggerFactory.getLogger(BankExceptionAdvice.class);
	
	@ExceptionHandler(value= {BalanceException.class, TransactionException.class})
	@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason=AccountConstants.INSUFFICIENT_BALANCE)
	public ErrorMessage handleException(Exception ex) {
		logger.error(ex.getMessage());
		return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), ex.getMessage(),LocalDateTime.now().toString());
	}
	
	@ExceptionHandler(value= {AccountException.class, CustomerException.class})
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public ErrorMessage handleException2(Exception ex){
		logger.error(ex.getMessage());
		return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), ex.getMessage(),LocalDateTime.now().toString());
	}

	

}
