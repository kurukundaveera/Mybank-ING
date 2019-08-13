package com.hcl.bankmanagementapp.api.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/***
 * @author Anuradha
 */
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.bankmanagementapp.api.dto.UserDTO;
import com.hcl.bankmanagementapp.api.dto.UserDetailsDto;
import com.hcl.bankmanagementapp.api.entity.User;
import com.hcl.bankmanagementapp.api.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserServiceImpl userServiceImpl;
	User userEntity;
	UserDTO userDto;

	@Before
	public void setUp() {
		
		userEntity = new User();
		userEntity.setEmail_id("anshu@hcl.com");
		userEntity.setFirst_name("Anshu");
		userEntity.setLast_name("Rathour");
		userEntity.setMobile_no("7236689509");
		userEntity.setPassword("anshu");
		
		
		userDto = new UserDTO();
		userDto.setEmail_id("anshu@hcl.com");
		userDto.setFirst_name("Anshu");
		userDto.setLast_name("Rathour");
		userDto.setMobile_no("7236689509");
		userDto.setPassword("anshu");	
		
	}
	
	@Test
	public void testRegisterUser(){
//		Mockito.when(userRepository.findById(userEntity.getEmail_id())).thenReturn(userEntity);
//		UserDetailsDto userDto = userServiceImpl.registerUser(userDto);
//		Assert.assertEquals(userEntity.getEmail_id(), userDto.getEmail_id());
	}

}
