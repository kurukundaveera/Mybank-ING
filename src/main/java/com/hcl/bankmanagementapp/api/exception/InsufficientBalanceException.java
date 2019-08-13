package com.hcl.bankmanagementapp.api.exception;

/***
 * 
 * @author Sushil
 *
 */
public class InsufficientBalanceException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public InsufficientBalanceException(String message)
	{
		super(message);
	}

}
