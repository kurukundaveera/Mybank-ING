package com.hcl.bankmanagementapp.api.dto;

import java.io.Serializable;

public class LoginDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private long acct_no;
	private String password;
	
	
	public long getAcct_no() {
		return acct_no;
	}
	public void setAcct_no(long acct_no) {
		this.acct_no = acct_no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginDTO [acct_no=" + acct_no + ", password=" + password + "]";
	}
	
}
