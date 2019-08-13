package com.hcl.bankmanagementapp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.bankmanagementapp.api.entity.Account;
/***
 * 
 * @author Sushil
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	public Account findByAccountNo(long accountNo);

}
