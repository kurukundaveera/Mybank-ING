package com.hcl.bankmanagementapp.api.controller;
/***
 * @author Anuradha
 */
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bankmanagementapp.api.dto.FundTransferResponseDto;
import com.hcl.bankmanagementapp.api.dto.LoginDTO;
import com.hcl.bankmanagementapp.api.dto.TransactionDto;
import com.hcl.bankmanagementapp.api.dto.TransactionSummaryDto;
import com.hcl.bankmanagementapp.api.dto.UserDTO;
import com.hcl.bankmanagementapp.api.dto.UserDetailsDto;
import com.hcl.bankmanagementapp.api.service.TransactionSummaryServiceImpl;
import com.hcl.bankmanagementapp.api.service.UserService;

@RestController
@RequestMapping("/bank")
@CrossOrigin(origins = "*")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	TransactionSummaryServiceImpl transactionSummaryServiceImpl;

	@Autowired
	UserService userService;

	@PostMapping("/fundTransfer")
	public ResponseEntity<FundTransferResponseDto> fundTransfer(@RequestBody TransactionDto transactionDto) {
		logger.info("INSIDE FUND TRANSFER METHOD#####################");
		FundTransferResponseDto transaction_message = transactionSummaryServiceImpl.fundTransfer(transactionDto);
		return new ResponseEntity<FundTransferResponseDto>(transaction_message, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<List<TransactionSummaryDto>> loginUser(@RequestBody LoginDTO loginDTO) {
		logger.info("INSIDE LOGIN METHOD%%%%%%%%%%%%%%%%%%%%");
		List<TransactionSummaryDto> list = userService.userLogin(loginDTO);
		return new ResponseEntity<List<TransactionSummaryDto>>(list, HttpStatus.OK);

	}

	@PostMapping("/register")
	public ResponseEntity<UserDetailsDto> register(@RequestBody UserDTO userDto) {
		logger.info("INSIDE REGISTER METHOD!!!!!!!!!!!!!!!!!!");
		UserDetailsDto acct_no = userService.registerUser(userDto);

		return new ResponseEntity<>(acct_no, HttpStatus.OK);
	}
}
