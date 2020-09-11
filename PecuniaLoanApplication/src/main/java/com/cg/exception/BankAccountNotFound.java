package com.cg.exception;

@SuppressWarnings("serial")
public class BankAccountNotFound extends RuntimeException 
{
    public BankAccountNotFound(String exception) {
        super(exception);
    }
}
