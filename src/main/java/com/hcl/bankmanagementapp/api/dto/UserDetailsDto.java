package com.hcl.bankmanagementapp.api.dto;

import java.io.Serializable;

public class UserDetailsDto implements Serializable{
	
	private static final long serialVersionUID = -1855263580038277712L;
	private Long acc_no;

	public Long getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(Long acc_no) {
		this.acc_no = acc_no;
	}
	
	
}
