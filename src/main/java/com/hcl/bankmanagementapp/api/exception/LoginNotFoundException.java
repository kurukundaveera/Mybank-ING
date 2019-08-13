package com.hcl.bankmanagementapp.api.exception;

import java.io.Serializable;

public class LoginNotFoundException extends RuntimeException implements Serializable{


	private static final long serialVersionUID = 1L;
	private static final String message = " invalid credenils..please try again..";
	
	public LoginNotFoundException() {
		
		super(message);
	}
}
