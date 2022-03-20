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

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * Model class for CreditCard
 * 
 * @author vn51ore
 *
 */
@Data
@Component
@Table(name = "creditcard")
@Entity
public class CreditCard {
	@Id
	private int cardNumber;
	private String cardHolderName;
	private String cardStatus;
	private String password;
	private int cardLimit;

}
