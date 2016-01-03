/**
 * 
 */
package com.github.juanmougan.demo.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.joda.time.DateTime;

/**
 * @author juanma
 *
 */
@Entity
@DiscriminatorValue("C")
public class CreditMovement extends Movement {
	
	public CreditMovement(DateTime timestamp, BigDecimal amount, Account account) {
		super(timestamp, amount, account);
	}
	
	@Override
	public void setAmount(BigDecimal amount) {
		this.amount = amount.abs();
	}

}
