package com.hcl.bankmanagementapp.api.service;

import com.hcl.bankmanagementapp.api.dto.FundTransferResponseDto;
import com.hcl.bankmanagementapp.api.dto.TransactionDto;

/***
 * 
 * @author Sushil
 *
 */
public interface ITransactionSummaryService {
	
	public FundTransferResponseDto fundTransfer(TransactionDto transactionDto);

}
