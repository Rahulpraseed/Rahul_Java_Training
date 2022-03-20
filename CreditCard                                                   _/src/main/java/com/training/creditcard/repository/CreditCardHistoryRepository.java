/* ********************************************************************************
* Project Name : CreditCardApplication
* Author : vn51ore
*
* Copyright Notice
*
* Copyright (c) 2021 Walmart. All Right Reserved.
* This software is the confidential and proprietary information of WalMart
* You shall not disclose or use Confidential information without the express
* written agreement of Walmart
*********************************************************************************/
package com.training.creditcard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.creditcard.model.CreditCardHistory;

/**
 * Repository class for CreditCardHistory
 * 
 * @author vn51ore
 */
@Repository
public interface CreditCardHistoryRepository extends CrudRepository<CreditCardHistory, Integer> {

}
