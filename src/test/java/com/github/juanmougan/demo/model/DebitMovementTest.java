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
public class DebitMovementTest {
	
	@Mock
	Account account;

	/**
	 * Test method for {@link com.github.juanmougan.demo.model.DebitMovement#setAmount(java.math.BigDecimal)}.
	 */
	@Test
	public void testSetAmount() {
		// Given
		DebitMovement movement = new DebitMovement(DateTime.now(), new BigDecimal(10), account);
		Boolean negativeAmount = movement.getAmount().compareTo(BigDecimal.ZERO) < 0;
		assertTrue("Should be greater than 0", negativeAmount);
	}

}
