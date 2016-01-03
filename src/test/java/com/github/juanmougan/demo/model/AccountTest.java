/**
 * 
 */
package com.github.juanmougan.demo.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.junit.Test;

/**
 * @author juanma
 *
 */
public class AccountTest {

	/**
	 * Test method for
	 * {@link com.github.juanmougan.demo.model.Account#addMovement(com.github.juanmougan.demo.model.Movement)}
	 * .
	 */
	@Test
	public void testAddMovement() {
		// Given
		Account account = new Account();
		Movement credit = new CreditMovement(DateTime.now(), new BigDecimal(10), account);
		Movement debit = new DebitMovement(DateTime.now(), BigDecimal.ONE, account);
		// When
		account.addMovement(credit);
		account.addMovement(debit);
		// Then
		assertEquals("Balance should be 9", new BigDecimal(9), account.getBalance());
	}

}
