package com.hcl.bankmanagementapp.api.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bankmanagementapp.api.dto.FundTransferResponseDto;
import com.hcl.bankmanagementapp.api.dto.TransactionDto;
import com.hcl.bankmanagementapp.api.entity.Account;
import com.hcl.bankmanagementapp.api.entity.TransactionSummary;
import com.hcl.bankmanagementapp.api.entity.User;
import com.hcl.bankmanagementapp.api.exception.AccountNumberDoesNotExistsException;
import com.hcl.bankmanagementapp.api.exception.InsufficientBalanceException;
import com.hcl.bankmanagementapp.api.repository.AccountRepository;
import com.hcl.bankmanagementapp.api.repository.TransactionSummaryRepository;
import com.hcl.bankmanagementapp.api.repository.UserRepository;

/***
 * 
 * @author Sushil
 *
 */
@Service
public class TransactionSummaryServiceImpl implements ITransactionSummaryService {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	TransactionSummaryRepository transactionSummaryRepository;
	 
	@Override
	public FundTransferResponseDto fundTransfer(TransactionDto transactionDto) {
		// create summary dto object
		TransactionSummary transactionSummary;
		// get account object for transfer money to other
		Account account = accountRepository.findByAccountNo(transactionDto.getAccountNo());
		System.out.println("transactionDto : " + transactionDto + "-------------optional : " + account);
		// get user object
		User user = userRepository.getUserByAccountNumber(transactionDto.getAccountNo());
		if (account != null) {
			if (account.getBalance() < transactionDto.getAmount()) {
				throw new InsufficientBalanceException("You have insufficient amount " + account.getBalance());
			} else {
				// deduct amount and update data
				double remainingBalance = (account.getBalance()) - (transactionDto.getAmount());
				account.setBalance(remainingBalance);
				accountRepository.save(account);
				// save transaction summary
				transactionSummary = new TransactionSummary();
				// format date
				// date formatter
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
				String currentDateTime = formatter.format(LocalDateTime.now());

				transactionSummary.setAccountNO(transactionDto.getMerchantAccNo());
				transactionSummary.setAmount(transactionDto.getAmount());
				transactionSummary.setStatus("success");
				transactionSummary.setTransactionDate(currentDateTime);
				transactionSummary.setMerchantName(user.getFirst_name());
				// save
				transactionSummaryRepository.save(transactionSummary);
				//set and send dto response
				FundTransferResponseDto responseDto = new FundTransferResponseDto();
				responseDto.setMessage("Amount " + transactionDto.getAmount() + " has been debited from your account "
						+ transactionDto.getAccountNo());
				return responseDto;
			}
		} else {
			throw new AccountNumberDoesNotExistsException(
					transactionDto.getAccountNo() + " account number does not exist!!!");
		}
	}

}
