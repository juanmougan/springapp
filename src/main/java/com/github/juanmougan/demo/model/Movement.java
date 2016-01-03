/**
 * 
 */
package com.github.juanmougan.demo.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.joda.time.DateTime;

/**
 * @author juanma
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
		name = "MOVEMENT_DISCRIMINATOR", 
		discriminatorType = DiscriminatorType.CHAR
	)
@DiscriminatorValue("M")
public abstract class Movement {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private DateTime timestamp;
	protected BigDecimal amount;
	
	@ManyToOne
	@JoinColumn(name = "ACCOUNT_ID", nullable = false)
	private Account account;

	protected Movement() {
	}

	public Movement(DateTime timestamp, BigDecimal amount, Account account) {
		super();
		this.timestamp = timestamp;
		this.setAmount(amount);
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(DateTime timestamp) {
		this.timestamp = timestamp;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public abstract void setAmount(BigDecimal amount);

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
