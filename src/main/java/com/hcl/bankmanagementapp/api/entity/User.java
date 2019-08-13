package com.hcl.bankmanagementapp.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class User {

	private String first_name;
	private String last_name;
	@Id
	private long acct_no;
	private String email_id;
	private String mobile_no;
	private String password;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getAcct_no() {
		return acct_no;
	}

	public void setAcct_no(long acct_no) {
		this.acct_no = acct_no;
	}

	@Override
	public String toString() {
		return "User [first_name=" + first_name + ", last_name=" + last_name + ", email_id=" + email_id + ", mobile_no="
				+ mobile_no + ", password=" + password + ", acct_no=" + acct_no + "]";
	}

}
