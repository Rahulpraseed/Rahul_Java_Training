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

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.training.creditcard.controller.CreditCardController;
import com.training.creditcard.model.CreditCard;
import com.training.creditcard.model.Customer;
import com.training.creditcard.repository.CreditCardRepository;
import com.training.creditcard.service.CreditCardService;

import junit.framework.Assert;
/**
 * Test class for CreditCardController
 * 
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class TestCreditCardController {

	@InjectMocks
	private CreditCardController creditCardController;

	@Mock
	private CreditCardService creditCardService;

	@Mock
	private CreditCardRepository creditCardRepository;
	
	/**
	 * Method to TestCreateCreditCard
	 * 
	 * 
	 */

	@Test
	public void TestCreateCreditCard() {

		Customer customer = new Customer();
		customer.setAge(20);
		customer.setCustomerName("rahul");
		customer.setSalary(60000);
		CreditCard credit = new CreditCard();
		credit.setCardHolderName("rahul");
		Mockito.when(creditCardService.createCreditCard(Mockito.any())).thenReturn(credit);
		CreditCard creditCard = creditCardController.createCreditCard(customer);
		Assert.assertEquals(creditCard.getCardHolderName(), customer.getCustomerName());
	}

	/**
	 * Method to TestUpdateCardLimit
	 * 
	 * 
	 */
	@Test
	public void TestUpdateCardLimit() {

		CreditCard credit = new CreditCard();
		credit.setCardHolderName("rahul");
		credit.setCardNumber(123);
		credit.setCardLimit(25000);
		credit.setCardNumber(200);
		Optional<CreditCard> optionCard = Optional.of(credit);
		Mockito.when(creditCardService.updateCreditCardLimit(Mockito.anyInt())).thenReturn(credit);
		CreditCard creditCard = creditCardController.updateCardLimit(credit.getCardNumber());
		Assert.assertEquals(creditCard.getCardLimit(), 25000);
	}
	/**
	 * Method to testCreditCardDuesAccept
	 * 
	 * 
	 */
	@Test
	public void testCreditCardDuesAccept() {

		CreditCard credit = new CreditCard();
		credit.setCardHolderName("rahul");
		credit.setCardNumber(123);
		credit.setCardLimit(25000);
		credit.setCardNumber(200);
		int dueAmount = 200;
		Optional<CreditCard> optionCard = Optional.of(credit);
		Mockito.when(creditCardService.creditCardDuesAccept(Mockito.anyInt(), Mockito.anyInt())).thenReturn(credit);
		CreditCard creditCard = creditCardController.creditCardDuesAccept(credit.getCardNumber(), dueAmount);
		Assert.assertEquals(creditCard.getCardLimit(), 25000);
	}
	/**
	 * Method to testCancelCreditCard
	 * 
	 * 
	 */
	@Test
	public void testCancelCreditCard() {

		CreditCard credit = new CreditCard();
		credit.setCardHolderName("rahul");
		credit.setCardNumber(123);
		credit.setCardLimit(25000);
		credit.setCardNumber(200);
		credit.setCardStatus("Cancel");
		Optional<CreditCard> optionCard = Optional.of(credit);
		Mockito.when(creditCardService.cancelCreditCard(Mockito.anyInt())).thenReturn(credit.getCardStatus());
		String creditCard = creditCardController.cancelCreditCard(credit.getCardNumber());
		Assert.assertEquals(creditCard, "Cancel");
	}
	/**
	 * Method to testBlockCreditCard
	 * 
	 * 
	 */
	@Test
	public void testBlockCreditCard() {

		CreditCard credit = new CreditCard();
		credit.setCardHolderName("rahul");
		credit.setCardNumber(123);
		credit.setCardLimit(25000);
		credit.setCardNumber(200);
		credit.setCardStatus("Block");
		Optional<CreditCard> optionCard = Optional.of(credit);
		Mockito.when(creditCardService.blockCreditCard(Mockito.anyInt())).thenReturn(credit.getCardStatus());
		String creditCard = creditCardController.blockCreditCard(credit.getCardNumber());
		Assert.assertEquals(creditCard, "Block");
	}
	/**
	 * Method to testUnBlockCreditCard
	 * 
	 * 
	 */
	@Test
	public void testUnBlockCreditCard() {

		CreditCard credit = new CreditCard();
		credit.setCardHolderName("rahul");
		credit.setCardNumber(123);
		credit.setCardLimit(25000);
		credit.setCardNumber(200);
		credit.setCardStatus("unBlock");
		Optional<CreditCard> optionCard = Optional.of(credit);
		Mockito.when(creditCardService.unBlockCreditCard(Mockito.anyInt())).thenReturn(credit.getCardStatus());
		String creditCard = creditCardController.unBlockCreditCard(credit.getCardNumber());
		Assert.assertEquals(creditCard, "unBlock");
	}
}
