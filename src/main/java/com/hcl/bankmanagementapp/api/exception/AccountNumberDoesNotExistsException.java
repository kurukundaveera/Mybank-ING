package com.hcl.bankmanagementapp.api.exception;

/***
 * 
 * @author Sushil
 *
 */
public class AccountNumberDoesNotExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AccountNumberDoesNotExistsException(String message)
	{
		super(message);
	}

}
