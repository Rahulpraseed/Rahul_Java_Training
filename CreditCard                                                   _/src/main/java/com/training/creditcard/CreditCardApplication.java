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
package com.training.creditcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Main class for CreditCardApplication
 * 
 * @author vn51ore
 *
 */
@EnableSwagger2
@SpringBootApplication
public class CreditCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditCardApplication.class, args);
	}
	
}
