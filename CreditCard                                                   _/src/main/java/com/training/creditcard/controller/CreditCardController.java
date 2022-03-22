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
package com.training.creditcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.creditcard.model.CreditCard;
import com.training.creditcard.model.Customer;
import com.training.creditcard.service.CreditCardService;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller class for CreditCardController
 * 
 * @author vn51ore
 *
 */
@Slf4j
@RestController
public class CreditCardController {

	@Autowired
	private CreditCardService creditCardService;

	/**
	 * Method to createCreditCard
	 * 
	 * @param customer
	 * @return response
	 */
	@PostMapping("/customer")
	public CreditCard createCreditCard(@RequestBody Customer customer) {
		log.info("createCreditCard methods start with argument customer{}", customer);
		CreditCard response = creditCardService.createCreditCard(customer);
		log.debug("createCreditCard methods end");
		return response;

	}

	/**
	 * Method to updateCardLimit
	 * 
	 * @param cardNumber
	 * @return response
	 */
	@PutMapping("/updateCardLimit/{cardNumber}")
	public CreditCard updateCardLimit(@PathVariable int cardNumber) {
		log.info("updateCardLimit methods start with argument cardNumber{}", cardNumber);
		CreditCard response = creditCardService.updateCreditCardLimit(cardNumber);
		log.debug("updateCardLimit methods end");
		return response;

	}

	/**
	 * Method to creditCardDuesAccept
	 * 
	 * @param cardNumber
	 * @param dueAmount
	 * @return response
	 */
	@PutMapping("/creditCardDuesAccept/{cardNumber}/{dueAmount}")
	public CreditCard creditCardDuesAccept(@PathVariable int cardNumber, @PathVariable int dueAmount) {
		log.info("creditCardDuesAccept methods start with argument cardNumber,dueAmount {}{}", cardNumber, dueAmount);
		CreditCard response = creditCardService.creditCardDuesAccept(cardNumber, dueAmount);
		log.debug("creditCardDuesAccept methods end");
		return response;

	}

	/**
	 * Method to cancelCreditCard
	 * 
	 * @param cardNumber
	 */
	@DeleteMapping("/cancelCreditCard")
	public String cancelCreditCard(@PathVariable int cardNumber) {
		log.info("cancelCreditCard methods start with argument cardNumber{}", cardNumber);
		String response = creditCardService.cancelCreditCard(cardNumber);
		log.debug("cancelCreditCard methods end");
		return response;

	}

	/**
	 * Method to blockCreditCard
	 * 
	 * @param cardNumber
	 * @return response
	 */
	@PutMapping("/blockCreditCard/{cardNumber}")
	public String blockCreditCard(@PathVariable int cardNumber) {
		log.info("blockCreditCard methods start with argument cardNumber{}", cardNumber);
		String response = creditCardService.blockCreditCard(cardNumber);
		log.debug("blockCreditCard methods end");
		return response;

	}

	/**
	 * Method to unBlockCreditCard
	 * 
	 * @param cardNumber
	 * @return response
	 */
	@PutMapping("/unBlockCreditCard/{cardNumber}")
	public String unBlockCreditCard(@PathVariable int cardNumber) {
		log.info("unBlockCreditCard methods start with argument cardNumber{}", cardNumber);
		String response = creditCardService.unBlockCreditCard(cardNumber);
		log.debug("unBlockCreditCard methods end");
		return response;

	}
	/**
	 * Method to getCreditCardById
	 * 
	 * @param cardNumber
	 * @return response
	 */
	@GetMapping("/getCreditCardById/{cardNumber}")
	public CreditCard getCreditCardById(@PathVariable int cardNumber) {
		log.info("getCreditCardById methods start with argument cardNumber{}", cardNumber);
		CreditCard response = creditCardService.getCreditCardById(cardNumber);
		log.debug("getCreditCardById methods end");
		return response;

	}

}
