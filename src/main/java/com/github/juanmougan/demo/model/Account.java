/**
 * 
 */
package com.github.juanmougan.demo.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author juanma
 *
 */
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID", nullable = false)
	private Customer owner;
	
	private BigDecimal balance = BigDecimal.ZERO;
	
	// TODO remove Eager mapping here
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Movement> movements = new ArrayList<>();

	protected Account() {
	}

	public Account(Customer owner) {
		super();
		this.owner = owner;
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public List<Movement> getMovements() {
		return movements;
	}

	protected void setMovements(List<Movement> movements) {
		this.movements = movements;
	}

	public void addMovement(Movement movement) {
		this.movements.add(movement);
		this.balance = this.balance.add(movement.getAmount());
		movement.setAccount(this);
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
