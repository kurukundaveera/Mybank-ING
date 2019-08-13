package com.hcl.bankmanagementapp.api.dto;
/***
 * 
 * @author Sushil
 *
 */
public class TransactionSummaryDto {

	private String merchantName;
	private double amount;
	private long accountNO;
	private String transactionDate;
	private String status;

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getAccountNO() {
		return accountNO;
	}

	public void setAccountNO(long accountNO) {
		this.accountNO = accountNO;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TransactionSummaryDto [merchantName=" + merchantName + ", amount=" + amount + ", accountNO=" + accountNO
				+ ", transactionDate=" + transactionDate + ", status=" + status + "]";
	}

}
