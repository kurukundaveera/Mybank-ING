package com.hcl.bankmanagementapp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.bankmanagementapp.api.entity.TransactionSummary;

/***
 * 
 * @author Sushil
 *
 */
@Repository
public interface TransactionSummaryRepository extends JpaRepository<TransactionSummary, Long> {


}
