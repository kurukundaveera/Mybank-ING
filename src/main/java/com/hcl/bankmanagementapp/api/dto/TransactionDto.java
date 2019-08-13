package com.hcl.bankmanagementapp.api.dto;
/***
 * 
 * @author Sushil
 *
 */
public class TransactionDto {

	private long accountNo;
	private long merchantAccNo;
	private double amount;
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public long getMerchantAccNo() {
		return merchantAccNo;
	}
	public void setMerchantAccNo(long merchantAccNo) {
		this.merchantAccNo = merchantAccNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
