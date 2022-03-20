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
package com.training.creditcard.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * Model class for CreditCardHistory
 * 
 * @author vn51ore
 *
 */
@Component
@Data
@Table(name = "creditcard_history")
@Entity
public class CreditCardHistory {
	@Id
	private int cardNumber;
	private String cardHolderName;
	private String cardStatus;
	private LocalDate cancelDate;

}
