package com.hcl.bankmanagementapp.api.repository;
/***
 * @author Anuradha
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.bankmanagementapp.api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	@Query("select u from User u where u.acct_no=:accountNo")
	public User getUserByAccountNumber(@Param(value = "accountNo") long accountNo);

}
