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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.training.creditcard.model.CreditCard;
import com.training.creditcard.model.CreditCardHistory;
import com.training.creditcard.model.Customer;
import com.training.creditcard.repository.CreditCardHistoryRepository;
import com.training.creditcard.repository.CreditCardRepository;
import com.training.creditcard.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Service class for CreditCardService
 * 
 * @author vn51ore
 *
 */
@Slf4j
@Service
public class CreditCardService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CreditCardRepository creditCardRepository;

	@Autowired
	private CreditCardHistoryRepository creditCardHistoryRepository;

	/**
	 * Method to createCreditCard
	 * 
	 * @param customer
	 * @return creditCard
	 */
	public CreditCard createCreditCard(Customer customer) {
		log.info("createCreditCard methods start with argument customer{}", customer);
		CreditCard creditCard = new CreditCard();
		if (customer.getSalary() > 50000 && customer.getAge() > 18) {
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			customerRepository.save(customer);
			creditCard.setCardHolderName(customer.getCustomerName());
			creditCard.setCardNumber(customer.getAccountNumber() + 1000);
			creditCard.setCardLimit(5000);
			creditCard.setPassword(passwordEncoder.encode(customer.getCustomerName().substring(0, 3).concat("123")));
			creditCard.setCardStatus("UnBlock");
			creditCardRepository.save(creditCard);
			log.debug("createCreditCard methods end");

		}
		return creditCard;

	}

	/**
	 * Method to updateCardLimit
	 * 
	 * @param cardNumber
	 * @return creditCard
	 */
	public CreditCard updateCreditCardLimit(int cardNumber) {
		log.info("updateCreditCardLimit methods start with argument cardNumber{}", cardNumber);
		Optional<CreditCard> credit = creditCardRepository.findById(cardNumber);
		CreditCard cardDetails = credit.get();
		cardDetails.setCardLimit(25000);
		creditCardRepository.save(cardDetails);
		log.debug("updateCreditCardLimit methods end");
		return cardDetails;

	}

	/**
	 * Method to creditCardDuesAccept
	 * 
	 * @param cardNumber
	 * @param dueAmount
	 * @return creditCard
	 */
	public CreditCard creditCardDuesAccept(int cardNumber, int dueAmount) {
		log.info("creditCardDuesAccept methods start with argument cardNumber{}{}", cardNumber, dueAmount);
		Optional<CreditCard> credit = creditCardRepository.findById(cardNumber);
		CreditCard cardDetails = credit.get();
		cardDetails.setCardLimit(cardDetails.getCardLimit() + dueAmount);
		creditCardRepository.save(cardDetails);
		log.debug("creditCardDuesAccept methods end");
		return cardDetails;

	}

	/**
	 * Method to cancelCreditCard
	 * 
	 * @param cardNumber
	 */
	public String cancelCreditCard(int cardNumber) {
		String status = null;
		log.info("cancelCreditCard methods start with argument cardNumber{}", cardNumber);
		LocalDate date = LocalDate.now();
		CreditCardHistory creditCardHistory = new CreditCardHistory();

		if (!ObjectUtils.isEmpty(creditCardRepository.findById(cardNumber))) {
			Optional<CreditCard> customer = creditCardRepository.findById(cardNumber);
			creditCardHistory.setCardHolderName(customer.get().getCardHolderName());
			creditCardHistory.setCardNumber(cardNumber);
			creditCardHistory.setCancelDate(date);
			creditCardHistory.setCardStatus("Cancel");
			creditCardHistoryRepository.save(creditCardHistory);
			creditCardRepository.deleteById(cardNumber);
			status = "Cancel";
		} else {
			status = "Fraud detection";
		}
		log.debug("cancelCreditCard methods end");
		return status;

	}

	/**
	 * Method to blockCreditCard
	 * 
	 * @param cardNumber
	 * @return status
	 */
	public String blockCreditCard(int cardNumber) {
		log.info("blockCreditCard methods start with argument cardNumber{}", cardNumber);
		String status = null;
		if (!ObjectUtils.isEmpty(creditCardRepository.findById(cardNumber))) {
			Optional<CreditCard> credit = creditCardRepository.findById(cardNumber);
			CreditCard cardDetails = credit.get();
			cardDetails.setCardStatus("Block");
			creditCardRepository.save(cardDetails);

			status = "Block";
		} else {
			status = "Fraud detected";
		}
		log.debug("blockCreditCard methods end");
		return status;
	}

	/**
	 * Method to unBlockCreditCard
	 * 
	 * @param cardNumber
	 * @return status
	 */
	public String unBlockCreditCard(int cardNumber) {
		log.info("unBlockCreditCard methods start with argument cardNumber{}", cardNumber);
		String status = null;
		if (!ObjectUtils.isEmpty(creditCardRepository.findById(cardNumber))) {
			Optional<CreditCard> credit = creditCardRepository.findById(cardNumber);
			CreditCard cardDetails = credit.get();
			cardDetails.setCardStatus("Unblock");
			creditCardRepository.save(cardDetails);
			status = "unblock";
		} else {
			status = "Fraud detected";
		}
		log.debug("unBlockCreditCard methods end");
		return status;
	}
}
