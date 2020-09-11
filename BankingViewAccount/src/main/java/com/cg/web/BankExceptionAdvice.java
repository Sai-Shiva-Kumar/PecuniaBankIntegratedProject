package com.cg.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.dto.AccountMessage;
import com.cg.dto.ErrorInfo;
import com.cg.exceptions.AccountException;
import com.cg.exceptions.CustomerException;
import com.cg.exceptions.LoginException;

@RestControllerAdvice
public class BankExceptionAdvice {

	Logger logger = LoggerFactory.getLogger(BankExceptionAdvice.class);
	
	
	
	@ExceptionHandler(value= {AccountException.class, CustomerException.class})
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public AccountMessage handleException2(Exception ex){
		logger.error(ex.getMessage());
		return new AccountMessage(ex.getMessage());
	}

	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.FORBIDDEN)
	public ErrorInfo handleLoginException(LoginException ex) {
		return new ErrorInfo(HttpStatus.FORBIDDEN.toString(),ex.getMessage().toString());
		
	}
	

}
