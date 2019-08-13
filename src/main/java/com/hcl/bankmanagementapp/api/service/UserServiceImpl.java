package com.hcl.bankmanagementapp.api.service;
/***
 * @author Anuradha
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bankmanagementapp.api.dto.LoginDTO;
import com.hcl.bankmanagementapp.api.dto.TransactionSummaryDto;
import com.hcl.bankmanagementapp.api.dto.UserDTO;
import com.hcl.bankmanagementapp.api.dto.UserDetailsDto;
import com.hcl.bankmanagementapp.api.entity.TransactionSummary;
import com.hcl.bankmanagementapp.api.entity.User;
import com.hcl.bankmanagementapp.api.exception.LoginNotFoundException;
import com.hcl.bankmanagementapp.api.repository.TransactionSummaryRepository;
import com.hcl.bankmanagementapp.api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	TransactionSummaryRepository transactionSummaryRepo;

	@Override
	public List<TransactionSummaryDto> userLogin(LoginDTO loginDTO) {

		List<TransactionSummary> list_summary = null;
		List<TransactionSummaryDto> list_summaryDto = new ArrayList<>();
		TransactionSummaryDto transactionSummaryDto;

		User user1 = userRepository.findById(loginDTO.getAcct_no()).get();

		if (user1 != null) {

			if (loginDTO.getPassword().equals(user1.getPassword())) {

				list_summary = transactionSummaryRepo.findAll();
				// add data to DTO
				for (TransactionSummary transactionSummary : list_summary) {
					transactionSummaryDto = new TransactionSummaryDto();
					transactionSummaryDto.setAccountNO(transactionSummary.getAccountNO());
					transactionSummaryDto.setAmount(transactionSummary.getAmount());
					transactionSummaryDto.setMerchantName(transactionSummary.getMerchantName());
					transactionSummaryDto.setStatus(transactionSummary.getStatus());
					transactionSummaryDto.setTransactionDate(transactionSummary.getTransactionDate());
					list_summaryDto.add(transactionSummaryDto);
					// transactionSummaryDto=null;
				}

			}else {
				
				 throw new LoginNotFoundException();
			}
		}
		return list_summaryDto;

	}

	public UserDetailsDto registerUser(UserDTO userDto) {

		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		// generate random account number
		Random random = new Random();
		Long acct_no = (long) random.nextInt(100000000);
		user.setAcct_no(acct_no);
		userRepository.save(user);
		UserDetailsDto userDetailsDto = new UserDetailsDto();
		userDetailsDto.setAcc_no(acct_no);
		return userDetailsDto;
	}

}
