/**
 * 
 */
package com.github.juanmougan.demo.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.junit.Test;
import org.mockito.Mock;

/**
 * @author juanma
 *
 */
public class CreditMovementTest {

	@Mock
	Account account;

	/**
	 * Test method for
	 * {@link com.github.juanmougan.demo.model.CreditMovement#setAmount(java.math.BigDecimal)}
	 * .
	 */
	@Test
	public void testSetAmount() {
		// Given
		CreditMovement movement = new CreditMovement(DateTime.now(), new BigDecimal(10), account);
		Boolean positiveAmount = movement.getAmount().compareTo(BigDecimal.ZERO) > 0;
		assertTrue("Should be greater than 0", positiveAmount);
	}

}
