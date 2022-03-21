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
package com.training.creditcard.service;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.training.creditcard.model.CreditCard;
import com.training.creditcard.model.Customer;
import com.training.creditcard.repository.CreditCardHistoryRepository;
import com.training.creditcard.repository.CreditCardRepository;
import com.training.creditcard.repository.CustomerRepository;

import junit.framework.Assert;
/**
 * Test class for CreditCardService
 * 
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class TestCreditCardService {

	@InjectMocks
	private CreditCardService creditCardService;

	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private CreditCardRepository creditCardRepository;

	@Mock
	private CreditCardHistoryRepository creditCardHistoryRepository;
	/**
	 * Method to testCreateCreditCard
	 * 
	 * 
	 */
	@Test
	public void testCreateCreditCard() {

		Customer customer = new Customer();
		customer.setAge(20);
		customer.setCustomerName("rahul");
		customer.setSalary(60000);
		CreditCard creditCard = creditCardService.createCreditCard(customer);
		Assert.assertEquals(creditCard.getCardHolderName(), customer.getCustomerName());

	}
	/**
	 * Method to testUpdateCreditCardLimit
	 * 
	 * 
	 */
	@Test
	public void testUpdateCreditCardLimit() {

		CreditCard credit = new CreditCard();
		credit.setCardHolderName("rahul");
		credit.setCardNumber(123);
		credit.setCardLimit(1000);
		credit.setCardNumber(200);
		Optional<CreditCard> optionCard = Optional.of(credit);
		Mockito.when(creditCardRepository.findById(Mockito.any())).thenReturn(optionCard);
		CreditCard creditCard = creditCardService.updateCreditCardLimit(credit.getCardNumber());
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
		credit.setCardLimit(1000);
		credit.setCardNumber(200);
		int dueAmount = 1000;
		Optional<CreditCard> optionCard = Optional.of(credit);
		Mockito.when(creditCardRepository.findById(Mockito.any())).thenReturn(optionCard);
		CreditCard creditCard = creditCardService.creditCardDuesAccept(credit.getCardNumber(), dueAmount);
		Assert.assertEquals(creditCard.getCardLimit(), 2000);

	}
	/**
	 * Method to testcancelCreditCard
	 * 
	 * 
	 */
	@Test
	public void testcancelCreditCard() {

		CreditCard credit = new CreditCard();
		credit.setCardHolderName("rahul");
		credit.setCardNumber(123);
		credit.setCardLimit(1000);
		credit.setCardNumber(200);
		credit.setCardStatus("unblock");
		LocalDate date = LocalDate.now();

		Optional<CreditCard> option = Optional.of(credit);
		Mockito.when(creditCardRepository.findById(Mockito.any())).thenReturn(option);

		String creditCard = creditCardService.cancelCreditCard(credit.getCardNumber());
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
		credit.setCardLimit(1000);
		credit.setCardNumber(200);
		credit.setCardStatus("unblock");
		Optional<CreditCard> optionCard = Optional.of(credit);
		Mockito.when(creditCardRepository.findById(Mockito.any())).thenReturn(optionCard);
		String creditCard = creditCardService.blockCreditCard(credit.getCardNumber());
		Assert.assertEquals(creditCard, "block");

	}
	/**
	 * Method to testUnblockCreditCard
	 * 
	 * 
	 */
	@Test
	public void testUnblockCreditCard() {

		CreditCard credit = new CreditCard();
		credit.setCardHolderName("rahul");
		credit.setCardNumber(123);
		credit.setCardLimit(1000);
		credit.setCardNumber(200);
		credit.setCardStatus("block");
		Optional<CreditCard> optionCard = Optional.of(credit);
		Mockito.when(creditCardRepository.findById(Mockito.any())).thenReturn(optionCard);
		String creditCard = creditCardService.unBlockCreditCard(credit.getCardNumber());
		Assert.assertEquals(creditCard, "unblock");

	}
}
