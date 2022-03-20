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

import lombok.Data;

/**
 * Model class for Customer
 * 
 * @author vn51ore
 *
 */
@Data
@Table(name = "customer")
@Entity
public class Customer {

	@Id
	private int accountNumber;
	private int panNumber;
	private String customerName;
	private int age;
	private int salary;

}
