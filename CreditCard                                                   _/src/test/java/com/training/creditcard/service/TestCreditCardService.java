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

	@Test
	public void TestCreateCreditCard() {

		Customer customer = new Customer();
		customer.setAge(20);
		customer.setCustomerName("rahul");
		customer.setSalary(60000);
		CreditCard creditCard = creditCardService.createCreditCard(customer);
		Assert.assertEquals(creditCard.getCardHolderName(), customer.getCustomerName());

	}

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
