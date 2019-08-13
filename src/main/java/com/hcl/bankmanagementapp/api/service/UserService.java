package com.hcl.bankmanagementapp.api.service;
/***
 * @author Anuradha
 */
import java.util.List;

import com.hcl.bankmanagementapp.api.dto.UserDTO;
import com.hcl.bankmanagementapp.api.dto.UserDetailsDto;

import org.springframework.stereotype.Service;

import com.hcl.bankmanagementapp.api.dto.LoginDTO;
import com.hcl.bankmanagementapp.api.dto.TransactionSummaryDto;

@Service
public interface UserService {

	public UserDetailsDto registerUser(UserDTO userDto);

	public List<TransactionSummaryDto> userLogin(LoginDTO loginDTO);
}
